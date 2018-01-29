package no.mechatronics.sfi.grpc_fmu.web.fmu

import no.mechatronics.sfi.grpc_fmu.web.ServletContextListenerImpl
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zeromq.ZContext
import org.zeromq.ZFrame
import org.zeromq.ZMQ
import org.zeromq.ZMsg
import java.util.*
import javax.annotation.PostConstruct
import javax.faces.bean.ApplicationScoped
import javax.faces.bean.ManagedBean

private const val HEARTBEAT_LIVENESS = 3L       //  3-5 is reasonable
private const val HEARTBEAT_INTERVAL = 1000L    //  msecs

private const val PPP_READY = "\u0001" //  Signals worker is ready
private const val PPP_HEARTBEAT = "\u0002"      //  Signals worker heartbeat

@ManagedBean(eager = true)
@ApplicationScoped()
class FmuService {

    private val beat: Heartbeat = Heartbeat(7000)
    val fmus: MutableSet<FmuBean> = Collections.synchronizedSet(HashSet())

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(FmuService::class.java)
    }

    @PostConstruct
    fun init() {
        beat.start()
        LOG.info("FmuHeartbeat started")

        ServletContextListenerImpl.onDestroy {
            beat.stopBlocking()
            LOG.info("FmuHeartbeat stopped")
        }

    }

    fun add(fmu: FmuBean): Boolean {
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
                                    val remoteFmu = RemoteFmu.fromJson(data)

                                    if (add(FmuBean(remoteFmu))) {
                                        LOG.info("FMU {} connected!", remoteFmu)
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