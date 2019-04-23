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

package no.ntnu.ihb.fmuproxy.jsonrpc

import info.laht.yajrpc.RpcHandler
import info.laht.yajrpc.net.http.RpcHttpServer
import info.laht.yajrpc.net.tcp.RpcTcpServer
import info.laht.yajrpc.net.ws.RpcWebSocketServer
import no.ntnu.ihb.fmi4j.importer.Fmu
import no.ntnu.ihb.fmuproxy.jsonrpc.service.RpcFmuService
import no.ntnu.ihb.fmuproxy.net.FmuProxyServer


/**
 * @author Lars Ivar Hatledal
 */
class FmuProxyJsonHttpServer(
        private val service: RpcFmuService
): RpcHttpServer(RpcHandler(service)), FmuProxyServer {

    override val simpleName = "jsonRpc/http"

    override fun addFmu(fmu: Fmu) {
        service.addFmu(fmu)
    }

    override fun removeFmu(fmu: Fmu) {
        service.removeFmu(fmu)
    }

}

/**
 * @author Lars Ivar Hatledal
 */
class FmuProxyJsonTcpServer(
        private val service: RpcFmuService
): RpcTcpServer(RpcHandler(service)), FmuProxyServer {

    override val simpleName = "jsonRpc/tcp"

    override fun addFmu(fmu: Fmu) {
        service.addFmu(fmu)
    }

    override fun removeFmu(fmu: Fmu) {
        service.removeFmu(fmu)
    }

}

/**
 * @author Lars Ivar Hatledal
 */
class FmuProxyJsonWsServer(
        private val service: RpcFmuService
): RpcWebSocketServer(RpcHandler(service)), FmuProxyServer {

    override val simpleName = "jsonRpc/ws"

    override fun addFmu(fmu: Fmu) {
        service.addFmu(fmu)
    }

    override fun removeFmu(fmu: Fmu) {
        service.removeFmu(fmu)
    }

}

///**
// * @author Lars Ivar Hatledal
// */
//class FmuProxyJsonZmqServer(
//        private val service: RpcFmuService
//): RpcZmqServer(RpcHandler(service)), FmuProxyServer {
//
//    override val simpleName = "jsonRpc/zmq"
//
//    override fun addFmu(fmu: Fmu) {
//        service.addFmu(fmu)
//    }
//
//    override fun removeFmu(fmu: Fmu) {
//        service.removeFmu(fmu)
//    }
//
//}