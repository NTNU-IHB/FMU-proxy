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
        }

    }

    override fun close() {
        stop()
    }

    fun stop() {
        thread?.also {
            stop = true
            it.interrupt()
        }
    }

    private fun run() {

        fun sleep(millis: Long) {
            try {
                Thread.sleep(millis)
            } catch (ex: InterruptedException) {
                // ignore
            }
        }

        while (!stop && !Thread.currentThread().isInterrupted) {

            if (connected) {

                post("ping", uuid, {
                    connected = it == "success"
                    sleep(500L)
                }, { ex ->
                    connected = false
                    LOG.trace("$ex")
                })

            } else {

                post("registerfmu", jsonData, {
                    connected = it == "success"
                    println("$it == success = $connected")
                }, { ex ->
                    LOG.trace("$ex")
                    sleep(2500L)
                })

            }

        }

    }


    private fun post(ctx: String, data: String, responseCallback: (String) -> Unit, onError: (Exception) -> Unit) {

        try {

            val urlString = "${remoteAddress.urlString()}/fmu-proxy/$ctx"
            val url = URL(urlString)
            (url.openConnection() as HttpURLConnection).apply {
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