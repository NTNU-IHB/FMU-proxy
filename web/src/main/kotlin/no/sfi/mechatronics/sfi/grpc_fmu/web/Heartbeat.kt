package no.sfi.mechatronics.sfi.grpc_fmu.web

import org.zeromq.ZFrame
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zeromq.*

private const val HEARTBEAT_LIVENESS = 3       //  3-5 is reasonable
private const val HEARTBEAT_INTERVAL = 1000    //  msecs

private const val PPP_READY = "\u0001" //  Signals worker is ready
private const val PPP_HEARTBEAT = "\u0002"      //  Signals worker heartbeat

private const val PORT = 7777

object Heartbeat {

    private val LOG: Logger = LoggerFactory.getLogger(Heartbeat::class.java)

    private lateinit var thread: Thread
    private val workers: MutableMap<String, Worker> = HashMap()

    fun start() {

        thread = Thread({

            val context = ZContext()
            val backend = context.createSocket(ZMQ.ROUTER)

            backend.bind("tcp://*:$PORT")

            var heartbeat_at = System.currentTimeMillis() + HEARTBEAT_INTERVAL

            while (!Thread.currentThread().isInterrupted) {

                val items: Array<ZMQ.PollItem> = arrayOf<ZMQ.PollItem>(ZMQ.PollItem(backend, ZMQ.Poller.POLLIN))

                val rc = ZMQ.poll(items, 1, HEARTBEAT_INTERVAL.toLong())
                if (rc == -1) {
                    break              //  Interrupted
                }

                //  Handle worker activity on backend
                if (items[0].isReadable) {
                    val msg = ZMsg.recvMsg(backend) ?: break          //  Interrupted

                    val address = msg.unwrap()
                    val uuid = String(address.data)

                    //  Forward message to client if it's not a READY
                    val frame = msg.first
                    if (String(frame.data, ZMQ.CHARSET) == PPP_READY) {

                        val data = String(msg.last.data, ZMQ.CHARSET);
                        val remoteFmu = RemoteFmu.parse(data)
                        LOG.info("FMU {} connected!", remoteFmu)
                        RemoteFmus.add(remoteFmu)
                        workers[uuid] = Worker(address)

                    }

                    msg.destroy()

                    if (uuid in workers) {
                        workers[uuid]!!.updateExpiry()
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
            context.destroy()

        })

    }

    private fun purge(workers: MutableMap<String, Worker>) {
        val it = workers.entries.iterator()
        while (it.hasNext()) {
            val next = it.next()
            val worker = next.value

            if (System.currentTimeMillis() > worker.expiry) {
                it.remove()
                val guid = next.key
                RemoteFmus.remove(guid)
                LOG.info("{}, disconnected!", guid)
            }
        }
    }

    private class Worker(
            internal val address: ZFrame          //  Address of worker
    ) {
        internal var expiry: Long = 0             //  Expires at this time

        init {
            updateExpiry()
        }

        internal fun updateExpiry() {
            expiry = System.currentTimeMillis() + HEARTBEAT_INTERVAL * HEARTBEAT_LIVENESS
        }

    };

}




