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

package no.mechatronics.sfi.fmu_proxy.web.fmu

import com.google.gson.GsonBuilder
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.fmi4j.modeldescription.variables.TypedScalarVariable
import no.mechatronics.sfi.fmu_proxy.web.ServletContextListenerImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zeromq.ZContext
import org.zeromq.ZFrame
import org.zeromq.ZMQ
import org.zeromq.ZMsg
import java.io.Serializable
import java.util.*
import javax.annotation.PostConstruct
import javax.faces.bean.ApplicationScoped
import javax.faces.bean.ManagedBean
import kotlin.collections.HashSet

private const val HEARTBEAT_LIVENESS = 3L       //  3-5 is reasonable
private const val HEARTBEAT_INTERVAL = 1000L    //  msecs

private const val PPP_READY = "\u0001" //  Signals worker is ready
private const val PPP_HEARTBEAT = "\u0002"      //  Signals worker heartbeat

private const val PORT = 7000


data class NetworkInfo(
        val host: String,
        val grpcPort: Int,
        val wsPort: Int,
        val tcpPort: Int,
        val httpPort: Int,
        val zmqPort: Int
): Serializable

@ManagedBean
data class RemoteFmu(
        val guid: String,
        val networkInfo: NetworkInfo,
        val modelDescriptionXml: String
): Serializable {

    private var _modelDescription: SimpleModelDescription? = null

    val modelName: String
        get() = modelDescription.modelName

    val description: String
        get() = modelDescription.description ?: "-"

    val modelDescription: SimpleModelDescription
        get() = _modelDescription ?: ModelDescriptionParser.parse(modelDescriptionXml).also { _modelDescription = it }

    val modelVariables: List<TypedScalarVariable<*>>
        get() = modelDescription.modelVariables.variables

    override fun toString(): String {
        return "RemoteFmu(guid='$guid', networkInfo=$networkInfo)"
    }

}

@ManagedBean(eager = true)
@ApplicationScoped()
class FmuService {

    private lateinit var beat: Heartbeat
    val fmus: MutableSet<RemoteFmu> = Collections.synchronizedSet(HashSet())

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(FmuService::class.java)
    }

    @PostConstruct
    fun init() {
        beat = Heartbeat(PORT).apply {
            start()
        }

        LOG.info("Heartbeat started")

        ServletContextListenerImpl.onDestroy {
            beat.stopBlocking()
            LOG.info("FmuHeartbeat stopped")
        }

    }

    fun add(fmu: RemoteFmu): Boolean {
        synchronized(fmus) {
            return fmus.add(fmu)
        }
    }

    fun remove(guid: String): Boolean {
        synchronized(fmus) {
            for (fmu in fmus) {
                if (fmu.guid == guid) {
                    return fmus.remove(fmu)
                }
            }
        }
        return false
    }

    inner class Heartbeat(
            private val port: Int
    ) {

        private var stop: Boolean = false
        private var thread: Thread? = null
        private val gson = GsonBuilder().create()
        private val workers: MutableMap<String, Worker> = HashMap()

        fun start() {

            if (thread == null) {

                thread = Thread({

                    ZContext().use { ctx ->

                        val backend = ctx.createSocket(ZMQ.ROUTER).apply {
                            rcvHWM = 1
                            bind("tcp://*:$port")
                        }
                        val poller = ctx.createPoller(1).apply {
                            register(ZMQ.PollItem(backend, ZMQ.Poller.POLLIN))
                        }

                        var heartbeatAt = System.currentTimeMillis() + HEARTBEAT_INTERVAL

                        while (!stop) {

                            if (poller.poll(HEARTBEAT_INTERVAL) == -1) {
                                break
                            }

                            if (poller.pollin(0)) {

                                val msg = ZMsg.recvMsg(backend) ?: break          //  Interrupted

                                val address: ZFrame = msg.unwrap()
                                val uuid = String(address.data, ZMQ.CHARSET)

                                if (String(msg.first.data, ZMQ.CHARSET) == PPP_READY) {

                                    val data = String(msg.last.data, ZMQ.CHARSET);
                                    val remoteFmu = gson.fromJson(data, RemoteFmu::class.java).apply {
                                        init()
                                    }

                                    if (add(remoteFmu)) {
                                        LOG.info("FMU $remoteFmu connected!")
                                        workers[uuid] = Worker(address)
                                    }

                                }

                                if (uuid in workers) {
                                    workers[uuid]!!.updateExpiry()
                                }

                                msg.destroy()

                            }

                            if (System.currentTimeMillis() >= heartbeatAt) {
                                for (worker in workers.values) {

                                    worker.address.send(backend,
                                            ZFrame.REUSE + ZFrame.MORE)
                                    val frame = ZFrame(PPP_HEARTBEAT)
                                    frame.send(backend, 0)

                                }
                                heartbeatAt = System.currentTimeMillis() + HEARTBEAT_INTERVAL
                            }

                            purge(workers)

                        }

                        workers.clear()

                    }

                }).apply { start() }
            }

        }

        fun stop() {
            thread?.apply {
                stop = true
            }
        }

        fun stopBlocking() {
            thread?.apply {
                stop = true
                join()
            }
        }

        private fun purge(workers: MutableMap<String, Worker>) {
            val it = workers.entries.iterator()
            while (it.hasNext()) {
                val next = it.next()
                val worker = next.value

                if (System.currentTimeMillis() > worker.expiry) {
                    val guid: String = next.key
                    if (remove(guid)) {
                        LOG.info("{}, disconnected!", guid)
                    }
                    it.remove()
                }
            }
        }

        inner class Worker(
                internal val address: ZFrame          //  Address of worker
        ) {
            var expiry: Long             //  Expires at this time

            init {
                expiry = nextExpiry()
            }

            private fun nextExpiry() = System.currentTimeMillis() + HEARTBEAT_INTERVAL * HEARTBEAT_LIVENESS

            fun updateExpiry() {
                expiry = nextExpiry()
            }

        }

    }

}