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

import com.google.gson.GsonBuilder
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import no.mechatronics.sfi.fmuproxy.net.NetworkInfo
import no.mechatronics.sfi.fmuproxy.net.SimpleSocketAddress
import no.mechatronics.sfi.fmuproxy.net.findAvailablePort
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import java.net.InetSocketAddress

internal class Heartbeat(
        private val remoteAddress: SimpleSocketAddress,
        private val networkInfo: NetworkInfo,
        private val modelDescriptionXml: String
): Closeable {

    private var thread: Thread? = null
    private var stop: Boolean = false

    private var connected: Boolean = false
    private val uuid: String = UUID.randomUUID().toString()

    val jsonData: String
        get() {
            val gson = GsonBuilder().create()
            val map = mapOf(
                    "uuid" to uuid,
                    "networkInfo" to networkInfo,
                    "modelDescriptionXml" to modelDescriptionXml
            )
            return gson.toJson(map)
        }

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(Heartbeat::class.java)
    }

    fun start() {

        if (thread == null) {
            thread = Thread(){
                run()
            }.apply {
                start()
            }
            LOG.info("Heartbeat started")
        } else {
            LOG.warn("Heartbeat has alread been started..")
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
            LOG.info("Heartbeat stopped")
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
                    connected = it == "success"
                    LOG.trace("pinged remote successfully")
                    sleep(1000L)
                }, { ex ->
                    connected = false
                    LOG.debug("Failed to ping remote: $ex")
                })

            } else {

                post("registerfmu", jsonData, {
                    connected = it == "success"
                    if (connected) {
                        LOG.trace("Successfully connected to remote!")
                    }
                }, { ex ->
                    LOG.debug("Failed to connect to remote: $ex")
                    sleep(5000L)
                })

            }

        }

    }

    private fun post(ctx: String, data: String, responseCallback: (String) -> Unit, onError: (Exception) -> Unit) {

        try {

            val urlString = "${remoteAddress.urlString}/fmu-proxy/$ctx"
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

fun main(args: Array<String>) {

    val xml = """
<?xml version="1.0" encoding="ISO-8859-1"?>
<fmiModelDescription
  fmiVersion="2.0"
  modelName="bouncingBall"
  guid="{8c4e810f-3df3-4a00-8276-176fa3c9f003}"
  numberOfEventIndicators="1">

<CoSimulation
  modelIdentifier="bouncingBall"/>

<ModelVariables>
  <ScalarVariable name="h" valueReference="0" description="height, used as state"
                  causality="local" variability="continuous" initial="exact">
    <Real start="1"/>
  </ScalarVariable>
  <ScalarVariable name="der(h)" valueReference="1" description="velocity of ball"
                  causality="local" variability="continuous" initial="calculated">
    <Real derivative="1"/>
  </ScalarVariable>
  <ScalarVariable name="v" valueReference="2" description="velocity of ball, used as state"
                  causality="local" variability="continuous" initial="exact">
    <Real start="0" reinit="true"/>
  </ScalarVariable>
  <ScalarVariable name="der(v)" valueReference="3" description="acceleration of ball"
                  causality="local" variability="continuous" initial="calculated">
    <Real derivative="3"/>
  </ScalarVariable>
  <ScalarVariable name="g" valueReference="4" description="acceleration of gravity"
                  causality="parameter" variability="fixed" initial="exact">
    <Real start="9.81"/>
  </ScalarVariable>
  <ScalarVariable name="e" valueReference="5" description="dimensionless parameter"
                  causality="parameter" variability="tunable" initial="exact">
    <Real start="0.7" min="0.5" max="1"/>
  </ScalarVariable>
</ModelVariables>

<ModelStructure>
  <Derivatives>
    <Unknown index="2" />
    <Unknown index="4" />
  </Derivatives>
  <InitialUnknowns>
    <Unknown index="2"/>
    <Unknown index="4"/>
  </InitialUnknowns>
</ModelStructure>

</fmiModelDescription>
    """.trimIndent()

    val beat = Heartbeat(
            remoteAddress = SimpleSocketAddress("localhost", 8080),
            networkInfo = NetworkInfo("localhost", mapOf("jsonRpc/http" to 9090)),
            modelDescriptionXml = xml)


    beat.start()

    println("Press any key to quit..")
    Scanner(System.`in`).apply {

        if (hasNext()) {
            beat.stop()
        }

    }


}