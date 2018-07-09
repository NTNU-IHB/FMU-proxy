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
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

private const val CONTENT_TYPE_TEXT_HTML = "text/html"

val service: FmuService
    get() = FmuService.INSTANCE


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
                        .toJson(service.fmus)

                writer.println(info)
                writer.close()

        }

    }
}

@WebServlet(urlPatterns = ["/keepalive"])
class KeepAlive: HttpServlet() {

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {

        val guid = req.inputStream.reader().readText()

    }

}

@WebServlet(urlPatterns = ["/registerfmu"])
class RegisterFmuServlet: HttpServlet() {

    override fun doPost(req: HttpServletRequest, resp: HttpServletResponse) {

        try {

            val json = req.inputStream.reader().readText()
            val remoteFmu = Gson().fromJson(json, RemoteFmu::class.java)
            service.fmus.add(remoteFmu)

            with(resp) {
                contentType = CONTENT_TYPE_TEXT_HTML
                writer.println("success")
                writer.close()
            }

        } catch (ex: Exception) {

        }

    }


    private class Runner: Runnable {

        override fun run() {

        }

    }

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(RegisterFmuServlet::class.java)
    }

}