package no.mechatronics.sfi.fmu_proxy

import info.laht.yaj_rpc.net.RpcServer

interface FmuProxyServer: RpcServer {

    val simpleName: String

}