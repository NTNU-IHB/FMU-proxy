//package no.mechatronics.sfi.grpc_fmu.web.heartbeat
//
//import no.mechatronics.sfi.grpc_fmu.RemoteFmu
//import no.mechatronics.sfi.grpc_fmu.web.fmu.FmuBean
//import no.mechatronics.sfi.grpc_fmu.web.fmu.Fmus
//import org.slf4j.Logger
//import org.slf4j.LoggerFactory
//import org.zeromq.ZContext
//import org.zeromq.ZFrame
//import org.zeromq.ZMQ
//import org.zeromq.ZMsg
//
//private const val HEARTBEAT_LIVENESS = 3L       //  3-5 is reasonable
//private const val HEARTBEAT_INTERVAL = 1000L    //  msecs
//
//private const val PPP_READY = "\u0001" //  Signals worker is ready
//private const val PPP_HEARTBEAT = "\u0002"      //  Signals worker heartbeat
//
//
