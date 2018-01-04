package no.mechatronics.sfi.grpc_fmu.heartbeating

import no.mechatronics.sfi.grpc_fmu.RemoteFmu
import no.mechatronics.sfi.grpc_fmu.RemoteFmus
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zeromq.ZContext
import org.zeromq.ZFrame
import org.zeromq.ZMQ
import org.zeromq.ZMsg

private const val HEARTBEAT_LIVENESS = 3L       //  3-5 is reasonable
private const val HEARTBEAT_INTERVAL = 1000L    //  msecs

private const val PPP_READY = "\u0001" //  Signals worker is ready
private const val PPP_HEARTBEAT = "\u0002"      //  Signals worker heartbeat


object CentralHeartbeat {

    private val LOG: Logger = LoggerFactory.getLogger(CentralHeartbeat::class.java)

    private var stop: Boolean = false
    private var thread: Thread? = null
    private val workers: MutableMap<String, Worker> = HashMap()

    @JvmOverloads
    fun start(port: Int = 7777) {

        if (thread == null) {

            thread = Thread({

                ZContext().use { ctx ->

                    val backend = ctx.createSocket(ZMQ.ROUTER)
                    val poller = ctx.createPoller(1).apply {
                        register(ZMQ.PollItem(backend, ZMQ.Poller.POLLIN))
                    }

                    backend.bind("tcp://*:$port")

                    var heartbeat_at = System.currentTimeMillis() + HEARTBEAT_INTERVAL

                    while (!stop) {

                        if (poller.poll(HEARTBEAT_INTERVAL) == -1) break

                        //  Handle worker activity on backend
                        if (poller.pollin(0)) {

                            val msg = ZMsg.recvMsg(backend) ?: break          //  Interrupted

                            val address = msg.unwrap()
                            val uuid = String(address.data, ZMQ.CHARSET)

                            //  Forward message to client if it's not a READY
                            val frame = msg.first
                            if (String(frame.data, ZMQ.CHARSET) == PPP_READY) {

                                val data = String(msg.last.data, ZMQ.CHARSET);
                                val remoteFmu = RemoteFmu.fromJson(data)

                                if (RemoteFmus.add(remoteFmu)) {
                                    LOG.info("FMU {} connected!", remoteFmu)
                                    workers[uuid] = Worker(address)
                                }

                            }

                            msg.destroy()

                            if (uuid in workers) {
                                workers[uuid]?.updateExpiry()
                            } else {
                                LOG.error("No worker with uuid={}", uuid)
                            }

                        }

                        if (System.currentTimeMillis() >= heartbeat_at) {
                            for (worker in workers.values) {

                                worker.address.send(backend,
                                        ZFrame.REUSE + ZFrame.MORE)
                                val frame = ZFrame(PPP_HEARTBEAT)
                                frame.send(backend, 0)

                            }
                            heartbeat_at = System.currentTimeMillis() + HEARTBEAT_INTERVAL
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
                it.remove()
                val guid = next.key
                if (RemoteFmus.remove(guid)) {
                    LOG.info("{}, disconnected!", guid)
                }
            }
        }
    }

    internal class Worker(
            internal val address: ZFrame          //  Address of worker
    ) {
        var expiry: Long             //  Expires at this time

        init {
            expiry = nextExpiry()
        }

        fun nextExpiry() = System.currentTimeMillis() + HEARTBEAT_INTERVAL * HEARTBEAT_LIVENESS

        fun updateExpiry() {
            expiry = nextExpiry()
        }

    };

}
