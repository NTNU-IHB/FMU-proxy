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

package no.ntnu.ihb.fmuproxy.web.fmu

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import no.ntnu.ihb.fmuproxy.web.ServletContextListenerImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Serializable
import java.util.*
import javax.annotation.PostConstruct
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

    private var stop = false

    @Transient
    private lateinit var thread: Thread

    /**
     * instance access to static field
     */
    val fmus: List<RemoteFmu>
        get() = Companion.fmus

    @PostConstruct
    fun setup() {
        LOG.debug("setup")
        thread = Thread() {
            while (!stop && !Thread.currentThread().isInterrupted) {
                FmuTimePair.purge(map)
                try {
                    Thread.sleep(LIFE_TIME)
                } catch (ex: InterruptedException) {
                    //ignore
                }
            }
        }.apply {
            start()
        }

        ServletContextListenerImpl.onDestroy {
            stop = true
            thread.interrupt()
            LOG.debug("destroy")
        }

    }

    companion object {

        val LOG: Logger = LoggerFactory.getLogger(FmuService::class.java)

        val map: MutableMap<String, FmuTimePair>
                = Collections.synchronizedMap(hashMapOf())

        val proxies: List<RemoteProxy>
            @Synchronized
            get() = map.values.map { it.remoteFmu }

        val fmus: List<RemoteFmu>
            get() = proxies.flatMap { it.fmus }

    }

}

/**
 * @author Lars Ivar Hatledal
 */
@WebServlet(urlPatterns = ["/availablefmus"])
class AvailableFmuServlet: HttpServlet() {

    private val mapper = jacksonObjectMapper()

    override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {

        with (response) {
            contentType = CONTENT_TYPE_TEXT_HTML

            writer.use {
                mapper.writeValue(it, FmuService.fmus)
            }

        }

    }
}

@WebServlet(urlPatterns = ["/ping"])
class KeepAlive: HttpServlet() {

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {

        val uuid = request.inputStream.bufferedReader().readText().trim()
        LOG.trace("Received ping from FMU with uuid=$uuid")

        FmuService.map[uuid]?.apply {

            signOfLifeGiven()

            with(response) {
                contentType = CONTENT_TYPE_TEXT_HTML
                writer.use {
                    it.println("success")
                    it.flush()
                }
            }

        } ?: with(response) {
                contentType = CONTENT_TYPE_TEXT_HTML
                writer.use {
                    it.println("fail")
                    it.flush()
                }
            }

    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(KeepAlive::class.java)
    }

}

@WebServlet(urlPatterns = ["/register"])
class RegisterFmuServlet: HttpServlet() {

    private val mapper = jacksonObjectMapper()

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {

        try {

            request.inputStream.bufferedReader().use {
                val remoteFmu = mapper.readValue(it, RemoteProxy::class.java).apply {
                    host = request.remoteHost
                }
                FmuService.map[remoteFmu.uuid] = FmuTimePair(remoteFmu)
                LOG.info("$remoteFmu connected!")
            }

            with(response) {
                contentType = CONTENT_TYPE_TEXT_HTML
                writer.use {
                    it.println("success")
                    it.flush()
                }
            }

        } catch (ex: Exception) {

            with(response) {
                contentType = CONTENT_TYPE_TEXT_HTML
                writer.use {
                    it.println("error")
                    it.flush()
                }
            }

            LOG.error("$ex")
        }

    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(RegisterFmuServlet::class.java)
    }

}

/**
 * Used to determine if a remote FMU is alive or not
 */
class FmuTimePair(
        val remoteFmu: RemoteProxy
) {

    private var lastSignOfLife = System.currentTimeMillis()

    val isDead: Boolean
        get() = (System.currentTimeMillis() - lastSignOfLife) > LIFE_TIME

    fun signOfLifeGiven() {
        lastSignOfLife = System.currentTimeMillis()
    }

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(FmuTimePair::class.java)

        fun purge(map: MutableMap<String, FmuTimePair>) {
            val it = map.iterator()
            for (entry in it) {
                if (entry.value.isDead) {
                    it.remove()
                    LOG.info("Purged RemoteFmu with uuid=${entry.value.remoteFmu.uuid} due to inactivity..")
                }
            }
        }

    }

}


