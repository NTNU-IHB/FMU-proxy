package no.mechatronics.sfi.grpc_fmu.templates

object HeartbeatTemplate {

    fun generate(packageName: String) : String {

        return """

package ${packageName};

import org.zeromq.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription;

class Heartbeat {

    private final static Logger LOG = LoggerFactory.getLogger(Heartbeat.class);

    private Thread thread;
    private boolean stop;

    private final String xml;
    private final int remotePort;
    private final String remoteAddress;
    private final ModelDescription modelDescription;

    public Heartbeat(String xml, String remoteAddress, int remotePort) {
        this.xml = xml;
        this.remotePort = remotePort;
        this.remoteAddress = remoteAddress;
        this.modelDescription = ModelDescription.parseModelDescription(xml);
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(new InnerClass());
        }
    }

    public void stop() {

        if (thread != null) {
            stop = true;
            thread.interrupt();
        }

    }

    private final class InnerClass implements Runnable {

        private final static int HEARTBEAT_LIVENESS = 3;      //  3-5 is reasonable
        private final static int HEARTBEAT_INTERVAL = 1000;    //  msecs
        private final static int INTERVAL_INIT = 1000;    //  Initial reconnect
        private final static int INTERVAL_MAX = 32000;    //  After exponential backoff

        private final static String PPP_READY = "\001";//  Signals worker is ready
        private final static String PPP_HEARTBEAT = "\002";//  Signals worker heartbeat

        private ZMQ.Socket worker_socket(ZContext ctx) {
            ZMQ.Socket worker = ctx.createSocket(ZMQ.DEALER);
            worker.setIdentity(modelDescription.getGuid().getBytes(ZMQ.CHARSET));
            worker.connect("tcp://" + remote_address + ':' + remote_port);

            //  Tell queue we're ready for work
            LOG.debug("Heartbeat server ready!");
            ZMsg msg = new ZMsg();
            msg.add(PPP_READY);
            msg.add(remoteAddress.getBytes(ZMQ.CHARSET));
            msg.add(remotePort);
            msg.add(xml.getBytes(ZMQ.CHARSET));
            msg.send(worker);

            return worker;
        }

        @Override
        public void run() {

            ZContext ctx = new ZContext();
            ZMQ.Socket worker = worker_socket(ctx);

            //  If liveness hits zero, queue is considered disconnected
            int liveness = HEARTBEAT_LIVENESS;
            int interval = INTERVAL_INIT;

            //  Send out heartbeats at regular intervals
            long heartbeat_at = System.currentTimeMillis() + HEARTBEAT_INTERVAL;

            OUTER:
            while (!Thread.currentThread().isInterrupted() && !stop) {
                ZMQ.PollItem items[] = {new ZMQ.PollItem(worker, ZMQ.Poller.POLLIN)};
                int rc = ZMQ.poll(items, HEARTBEAT_INTERVAL);
                if (rc == -1) {
                    break;              //  Interrupted
                }
                if (items[0].isReadable()) {
                    ZMsg msg = ZMsg.recvMsg(worker);
                    if (msg == null) {
                        break;          //  Interrupted
                    }
                    switch (msg.size()) {
                        case 1:
                            ZFrame frame = msg.getFirst();
                            if (PPP_HEARTBEAT.equals(new String(frame.getData()))) {
                                liveness = HEARTBEAT_LIVENESS;
                            } else {
                                LOG.warn("E: invalid message\n");
                                msg.dump(System.out);
                            }
                            msg.destroy();
                            break;
                        default:
                            LOG.warn("E: invalid message\n");
                            msg.dump(System.out);
                            break;
                    }
                    interval = INTERVAL_INIT;
                } else if (--liveness == 0) {
                    LOG.warn("Heartbeat failure, can't reach queue");
                    LOG.info("Reconnecting in {} msec", interval);
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        break OUTER;
                    }

                    if (interval < INTERVAL_MAX) {
                        interval *= 2;
                    }
                    ctx.destroySocket(worker);
                    worker = worker_socket(ctx);
                    liveness = HEARTBEAT_LIVENESS;
                }
                if (System.currentTimeMillis() > heartbeat_at) {
                    heartbeat_at = System.currentTimeMillis() + HEARTBEAT_INTERVAL;
//                    LOG.debug("Worker heartbeat..");
                    ZFrame frame = new ZFrame(PPP_HEARTBEAT);
                    frame.send(worker, 0);
                }
            }
            ctx.destroy();

            LOG.info("{} stopped!", Heartbeat.class.getSimpleName());

        }

    }

}

            """

    }

}