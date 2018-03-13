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

package no.mechatronics.sfi.fmu_proxy.heartbeat

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import no.mechatronics.sfi.fmu_proxy.fmu.RemoteFmu
import no.mechatronics.sfi.fmu_proxy.net.SimpleSocketAddress
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.zeromq.ZContext
import org.zeromq.ZFrame
import org.zeromq.ZMQ
import org.zeromq.ZMsg
import java.io.Closeable

private const val HEARTBEAT_LIVENESS = 3L      //  3-5 is reasonable
private const val HEARTBEAT_INTERVAL = 1000L    //  msecs
private const val INTERVAL_INIT = 1000L   //  Initial reconnect
private const val INTERVAL_MAX = 32000L   //  After exponential backoff

private const val PPP_READY = "\u0001"//  Signals worker is ready
private const val PPP_HEARTBEAT = "\u0002"//  Signals worker heartbeat

/**
 *
 * @author Lars Ivar Hatledal
 */
internal class Heartbeat(
        private val remoteAddress: SimpleSocketAddress,
        private val remoteFmu: RemoteFmu
): Closeable {


    private var started = false
    private var inner: InnerClass? = null


    fun start() {
       if (!started) {
           inner = InnerClass()
           LOG.debug("${javaClass.simpleName} started!")
       }
    }

    fun stop() {
        inner?.also {
            it.stop()
            LOG.debug("${javaClass.simpleName} stopped!")
        }
    }

    override fun close() {
        stop()
    }

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(Heartbeat::class.java)
    }

    private inner class InnerClass : Runnable {

        private val thread: Thread
        private var stop = false
        private val ctx: ZContext = ZContext()
        private val gson: Gson = GsonBuilder().create()

        init {
            thread = Thread(this).apply { start() }
        }

        fun stop() {
            stop = true
            ctx.close()
            thread.join()
        }

        private fun workerSocket(ctx: ZContext): ZMQ.Socket {
            return ctx.createSocket(ZMQ.DEALER).also { worker ->
                worker.identity = remoteFmu.guid.toByteArray(ZMQ.CHARSET)
                worker.connect("tcp://${remoteAddress.host}:${remoteAddress.port}")

                ZMsg().apply {
                    add(PPP_READY)
                    add(gson.toJson(remoteFmu).toByteArray(ZMQ.CHARSET))
                    send(worker)
                }

            }

        }

        override fun run() {

            var worker = workerSocket(ctx)
            val poller = ctx.createPoller(1).apply {
                register(worker, ZMQ.Poller.POLLIN)
            }

            //  If liveness hits zero, queue is considered disconnected
            var liveness = HEARTBEAT_LIVENESS
            var interval = INTERVAL_INIT

            //  Send out heartbeats at regular intervals
            var heartbeatAt = System.currentTimeMillis() + HEARTBEAT_INTERVAL

            while (!stop) {

                if (poller.poll(HEARTBEAT_INTERVAL) == -1) break //  Interrupted

                if (poller.pollin(0)) {
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

                    LOG.debug("FmuHeartbeat failure, can't reach remote @ $remoteAddress, \n reconnecting in $interval msec")

                    Thread.sleep(interval)
                    if (interval < INTERVAL_MAX) {
                        interval *= 2
                    }

                    poller.unregister(worker)
                    ctx.destroySocket(worker)
                    worker = workerSocket(ctx)
                    poller.register(worker, ZMQ.Poller.POLLIN)
                    liveness = HEARTBEAT_LIVENESS
                }

                if (System.currentTimeMillis() > heartbeatAt) {
                    heartbeatAt = System.currentTimeMillis() + HEARTBEAT_INTERVAL
                    ZFrame(PPP_HEARTBEAT).apply {
                        send(worker, 0 )
                    }
                }

            }
        }
    }

}


