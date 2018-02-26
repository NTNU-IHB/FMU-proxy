package no.mechatronics.sfi.rmu.json_rpc

import info.laht.yaj_rpc.RpcHandler
import info.laht.yaj_rpc.net.ws.RpcWebSocketServer
import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.rmu.RmuServer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class JsonRpcFmuServer(
        fmuFile: FmuFile
): RmuServer {

    private val handler = RpcHandler(FmuService(fmuFile))
    private var server = RpcWebSocketServer(handler)

    override fun start(port: Int) = server.start(port)
    override fun stop() = server.stop()

    private companion object {
        val LOG: Logger = LoggerFactory.getLogger(JsonRpcFmuServer::class.java)
    }

}