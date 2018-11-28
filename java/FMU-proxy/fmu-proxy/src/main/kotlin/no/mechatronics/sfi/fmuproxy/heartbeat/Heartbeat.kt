/*
 * The MIT License
 *
 * Copyright 2017-2018. Norwegian University of Technology
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

package no.mechatronics.sfi.fmuproxy.heartbeat

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import no.mechatronics.sfi.fmuproxy.net.SimpleSocketAddress
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

/**
 * @author Lars Ivar Hatledal
 */
internal class Heartbeat(
        private val remote: SimpleSocketAddress,
        private val ports: Map<String, Int>,
        private val modelDescriptions: List<String>
): Closeable {

    private var stop: Boolean = false
    private var connected: Boolean = false
    private var thread: Thread? = null
    private val uuid: String = UUID.randomUUID().toString()

    val jsonData: String by lazy {
        val mapper = jacksonObjectMapper()
        val map = mapOf(
                "uuid" to uuid,
                "ports" to ports,
                "modelDescriptions" to modelDescriptions
        )
        mapper.writeValueAsString(map)
    }

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(Heartbeat::class.java)
    }

    fun start() {

        if (thread == null) {
            thread = Thread{
                run()
            }.apply {
                start()
            }
            LOG.info("Heartbeat started. Connecting to remote @${remote.host}:${remote.port}")
        } else {
            LOG.warn("Heartbeat has already been started..")
        }

    }

    override fun close() {
        stop()
    }

    fun stop() {
        thread?.also {
            stop = true
            it.interrupt()
            it.join(1000)
            LOG.info("Heartbeat stopped!")
        }
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (ex: InterruptedException) {
            // ignore
        }
    }

    private fun run() {


        while (!stop && !Thread.currentThread().isInterrupted) {

            if (connected) {

                post("ping", uuid, {
                    connected = (it == "success")
                    if (connected) {
                        LOG.trace("Remote pinged successfully!")
                    } else {
                        LOG.debug("Failed to ping remote!")
                    }
                    sleep(1000L)
                }, { ex ->
                    connected = false
                    LOG.info("Failed to ping remote..")
                    LOG.debug(".. due to caught Exception:", ex)
                })

            } else {

                post("register", jsonData, {
                    connected = (it == "success")
                    if (connected) {
                        LOG.info("Successfully connected to remote!")
                    }
                }, { ex ->
                    LOG.info("Failed to connect to remote..")
                    LOG.debug(".. due to caught Exception:", ex)
                    sleep(3500L)
                })

            }

        }

    }

    private fun post(ctx: String, data: String, responseCallback: (String) -> Unit, onError: (Exception) -> Unit) {

        try {

            val urlString = "${remote.urlString}/fmu-proxy/$ctx"
            (URL(urlString).openConnection() as HttpURLConnection).apply {
                requestMethod = "POST"
                doOutput = true
                setRequestProperty("Content-Type", "application/text")

                DataOutputStream(outputStream).use {
                    it.writeBytes(data)
                    it.flush()
                }

                responseCallback(inputStream.reader().readText().trim())
            }

        } catch (ex: Exception) {
            onError(ex)
        }

    }

}
