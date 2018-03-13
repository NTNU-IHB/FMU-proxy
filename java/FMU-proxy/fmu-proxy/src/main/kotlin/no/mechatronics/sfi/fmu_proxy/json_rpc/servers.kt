package no.mechatronics.sfi.fmu_proxy.json_rpc

import info.laht.yaj_rpc.RpcHandler
import info.laht.yaj_rpc.net.http.RpcHttpServer
import info.laht.yaj_rpc.net.tcp.RpcTcpServer
import info.laht.yaj_rpc.net.ws.RpcWebSocketServer
import info.laht.yaj_rpc.net.zmq.RpcZmqServer
import no.mechatronics.sfi.fmu_proxy.net.FmuProxyServer


class FmuProxyJsonHttpServer(
        handler: RpcHandler
): RpcHttpServer(handler), FmuProxyServer {

    override val simpleName = "jsonRpc/http"

}

class FmuProxyJsonWsServer(
        handler: RpcHandler
): RpcWebSocketServer(handler), FmuProxyServer {

    override val simpleName = "jsonRpc/ws"

}

class FmuProxyJsonTcpServer(
        handler: RpcHandler
): RpcTcpServer(handler), FmuProxyServer {

    override val simpleName = "jsonRpc/tcp"

}

class FmuProxyJsonZmqServer(
        handler: RpcHandler
): RpcZmqServer(handler), FmuProxyServer {

    override val simpleName = "jsonRpc/zmq"

}