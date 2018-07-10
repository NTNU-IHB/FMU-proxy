/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology (NTNU)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package no.mechatronics.sfi.fmuproxy.web.fmu

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import no.mechatronics.sfi.fmuproxy.web.ServletContextListenerImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Serializable
import java.util.*
import javax.annotation.PostConstruct
import javax.annotation.PreDestroy
import javax.faces.bean.ApplicationScoped
import javax.faces.bean.ManagedBean
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

private const val LIFE_TIME = 3500L //consider remote FMU dead after this amount silence
private const val CONTENT_TYPE_TEXT_HTML = "text/html"

@ManagedBean(eager = true)
@ApplicationScoped
class FmuService: Serializable {

    @Transient
    private lateinit var thread: Thread

    val fmus: List<RemoteFmu>
        get() = FmuService.fmus

    private var stop = false

    @PostConstruct
    fun setup() {
        LOG.info("setup")
        thread = Thread() {
            while (!stop && !Thread.currentThread().isInterrupted) {
                FmuTimePair.purge(map)
                try {
                    Thread.sleep(LIFE_TIME)
                } catch (ex: InterruptedException) {
                    //ignore
                }
            }
        }
        thread.start()

        ServletContextListenerImpl.onDestroy {
            stop = true
            thread.interrupt()
            LOG.info("destroy")
        }

    }

    companion object {

        val LOG: Logger = LoggerFactory.getLogger(FmuService::class.java)

        val map: MutableMap<String, FmuTimePair> = Collections.synchronizedMap(hashMapOf())

        val fmus: List<RemoteFmu>
            get() = map.values.map { it.remoteFmu }

    }

}

/**
 * @author Lars Ivar Hatledal
 */
@WebServlet(urlPatterns = ["/availablefmus"])
class AvailableFmuServlet: HttpServlet() {

    override fun doGet(req: HttpServletRequest, resp: HttpServletResponse) {

        with (resp) {
            contentType = CONTENT_TYPE_TEXT_HTML

            val info = GsonBuilder()
                    .setPrettyPrinting()
                    .create()
                    .toJson(FmuService.fmus)

            writer.use {
                it.println(info)
            }

        }

    }
}

@WebServlet(urlPatterns = ["/ping"])
class KeepAlive: HttpServlet() {

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {

        val uuid = req.inputStream.reader().readText()
        FmuService.map[uuid]?.apply {

            update()

            with(resp) {
                writer.use {
                    it.println("success")
                    it.flush()
                }
            }

        }

    }

}

@WebServlet(urlPatterns = ["/registerfmu"])
class RegisterFmuServlet: HttpServlet() {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(RegisterFmuServlet::class.java)
    }

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {

        try {

            val json = req.inputStream.reader().readText().trim()
            val remoteFmu = Gson().fromJson(json, RemoteFmu::class.java)
            FmuService.map[remoteFmu.uuid] = FmuTimePair(remoteFmu)

            LOG.info("$remoteFmu connected!")

            with(resp) {
                contentType = CONTENT_TYPE_TEXT_HTML
                writer.use {
                    it.println("success")
                    it.flush()
                }
            }

        } catch (ex: Exception) {
            LOG.error("$ex")
        }

    }

}

class FmuTimePair(
        val remoteFmu: RemoteFmu
) {

    private var lastSignOfLife = System.currentTimeMillis()

    val isDead: Boolean
        get() = (System.currentTimeMillis() - lastSignOfLife) > LIFE_TIME

    fun update() {
        lastSignOfLife = System.currentTimeMillis()
    }

    companion object {

        val LOG: Logger = LoggerFactory.getLogger(FmuTimePair::class.java)

        fun purge(map: MutableMap<String, FmuTimePair>) {
            val it = map.iterator()
            for (entry in it) {
                if (entry.value.isDead) {
                    it.remove()
                    LOG.debug("Purged RemoteFmu with uuid=${entry.value.remoteFmu.uuid} due to inactivity..")
                }
            }
        }

    }

}


