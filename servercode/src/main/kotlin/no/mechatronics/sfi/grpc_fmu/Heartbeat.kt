/*
 * The MIT License
 *
 * Copyright 2017. Norwegian University of Technology
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

package no.mechatronics.sfi.grpc_fmu

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zeromq.ZContext
import org.zeromq.ZFrame
import org.zeromq.ZMQ
import org.zeromq.ZMsg

class Heartbeat(
        private val remoteAddress: SocketAddress,
        private val remoteFmu: RemoteFmu) {

    private var thread: Thread? = null
    private var stop: Boolean = false

    fun start() {
        if (thread == null) {
            thread = Thread(InnerClass()).apply {
                start()
            }

        }
    }

    fun stop() {
        thread?.apply {
            stop = true
            interrupt()
        }
    }

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(Heartbeat::class.java)

        private val HEARTBEAT_LIVENESS = 3L      //  3-5 is reasonable
        private val HEARTBEAT_INTERVAL = 1000L    //  msecs
        private val INTERVAL_INIT = 1000L   //  Initial reconnect
        private val INTERVAL_MAX = 32000L   //  After exponential backoff

        private val PPP_READY = "\u0001"//  Signals worker is ready
        private val PPP_HEARTBEAT = "\u0002"//  Signals worker heartbeat
    }

    private inner class InnerClass : Runnable {

        private fun workerSocket(ctx: ZContext): ZMQ.Socket {
            val worker = ctx.createSocket(ZMQ.DEALER)
            worker.identity = (remoteFmu.guid.toByteArray(ZMQ.CHARSET))
            worker.connect("tcp://${remoteAddress.hostAddress}:${remoteAddress.port}")

            //  Tell queue we're ready for work
            LOG.debug("Heartbeat server ready!")
            val msg = ZMsg()
            msg.add(PPP_READY)
            msg.add(RemoteFmu.toJson(remoteFmu).toByteArray(ZMQ.CHARSET))
            msg.send(worker)

            return worker
        }

        override fun run() {

            val ctx = ZContext()
            var worker = workerSocket(ctx)

            //  If liveness hits zero, queue is considered disconnected
            var liveness = HEARTBEAT_LIVENESS
            var interval = INTERVAL_INIT

            //  Send out heartbeats at regular intervals
            var heartbeat_at = System.currentTimeMillis() + HEARTBEAT_INTERVAL

            OUTER@ while (!Thread.currentThread().isInterrupted && !stop) {
                val items = arrayOf<ZMQ.PollItem>(ZMQ.PollItem(worker, ZMQ.Poller.POLLIN))
                val rc = ZMQ.poll(items, HEARTBEAT_INTERVAL)
                if (rc == -1) {
                    break              //  Interrupted
                }
                if (items[0].isReadable) {
                    val msg = ZMsg.recvMsg(worker) ?: break          //  Interrupted
                    when (msg.size) {
                        1 -> {
                            val frame = msg.first
                            if (PPP_HEARTBEAT == String(frame.data)) {
                                liveness = HEARTBEAT_LIVENESS
                            } else {
                                LOG.warn("E: invalid message\n")
                                msg.dump(System.out)
                            }
                            msg.destroy()
                        }
                        else -> {
                            LOG.warn("E: invalid message\n")
                            msg.dump(System.out)
                        }
                    }
                    interval = INTERVAL_INIT
                } else if (--liveness == 0L) {
                    LOG.warn("Heartbeat failure, can't reach remote")
                    LOG.info("Reconnecting in {} msec", interval)
                    try {
                        Thread.sleep(interval.toLong())
                    } catch (e: InterruptedException) {
                        break@OUTER
                    }

                    if (interval < INTERVAL_MAX) {
                        interval *= 2
                    }
                    ctx.destroySocket(worker)
                    worker = workerSocket(ctx)
                    liveness = HEARTBEAT_LIVENESS
                }
                if (System.currentTimeMillis() > heartbeat_at) {
                    heartbeat_at = System.currentTimeMillis() + HEARTBEAT_INTERVAL
                    //                    LOG.debug("Worker heartbeat..");
                    val frame = ZFrame(PPP_HEARTBEAT)
                    frame.send(worker, 0)
                }
            }
            ctx.destroy()

            LOG.debug("{} stopped!", Heartbeat::class.java.simpleName)

        }



    }


}
