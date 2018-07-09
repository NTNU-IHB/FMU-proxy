package no.mechatronics.sfi.fmuproxy.heartbeat

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import no.mechatronics.sfi.fmuproxy.fmu.RemoteFmu
import no.mechatronics.sfi.fmuproxy.net.NetworkInfo
import no.mechatronics.sfi.fmuproxy.net.SimpleSocketAddress
import no.mechatronics.sfi.fmuproxy.net.findAvailablePort
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.Closeable
import java.io.DataOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import java.net.InetSocketAddress



internal class Heartbeat(
        private val remoteAddress: SimpleSocketAddress,
        private val remoteFmu: RemoteFmu
): Closeable {

    private var thread: Thread? = null

    private var stop: Boolean = false

    private var timeStamp = -1L

    private val connected: Boolean
        get() = timeStamp != -1L && (System.currentTimeMillis() - timeStamp) < 2500L

    var server: MyHttpServer? = null

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
            it.interrupt()
            stop = true
        }
    }

    private fun run() {

        server = MyHttpServer()

        while (!stop && !Thread.currentThread().isInterrupted) {

            if (connected) {

                try {
                    Thread.sleep(1000)
                } catch (ex: InterruptedException) {
                    LOG.debug("Thread interrupted..")
                }

            } else {

                val urlString = "http://${remoteAddress.host}:${remoteAddress.port}/fmu-proxy/registerfmu"

                val url = URL(urlString)
                (url.openConnection() as HttpURLConnection).apply {
                    requestMethod = "POST"
                    doOutput = true
                    setRequestProperty("Content-Type", "application/text")

                    DataOutputStream(outputStream).use {
                        it.writeBytes("${remoteFmu.toJson()}")
                        it.flush()
                    }

                    println("responseCode=$responseCode")
                    println("responseMessage=${inputStream.reader().readText()}")

                }

            }

        }

    }

    inner class MyHttpServer {

        private val server: HttpServer
        private val port: Int

        init {


            val handler = HttpHandler { t ->

                timeStamp = System.currentTimeMillis()

                val response = "I'm alive".toByteArray()
                t.sendResponseHeaders(200, response.size.toLong())
                t.responseBody.use {
                    it.write(response)
                }
            }

            port = findAvailablePort()
            server = HttpServer.create(InetSocketAddress(port), 0).apply {
                createContext("/", handler)
                executor = null
                start()
            }

        }

        fun stop() {
            server?.stop(0)
        }

    }



    companion object {
        val LOG: Logger = LoggerFactory.getLogger(Heartbeat::class.java)
    }


}

fun main(args: Array<String>) {

    val beat = Heartbeat(
            SimpleSocketAddress("localhost", 8080),
            RemoteFmu("myGuid", "myModel", NetworkInfo("localhost", mapOf("jsonRpc/http" to 9090)), "<fmiModelDescription></fmiModelDescription>")
    )

    beat.start()

    println("Press any key to quit..")
    Scanner(System.`in`).apply {

        if (hasNext()) {
            beat.stop()
        }

    }


}