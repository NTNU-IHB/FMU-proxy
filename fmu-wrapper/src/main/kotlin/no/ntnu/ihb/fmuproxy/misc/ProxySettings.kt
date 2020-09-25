package no.ntnu.ihb.fmuproxy.misc

class ProxySettings(
    val fmuName: String,
    remoteString: String?
) {

    val remote = remoteString?.let {
        RemoteAddress.parse(it)
    }

}

data class RemoteAddress(
    val host: String,
    val port: Int
) {

    val strRepr = "$host:$port"

    companion object {

        fun parse(str: String): RemoteAddress {
            println("str=$str")
            val (host, port) = str.split(":")
            return RemoteAddress(host, port.toInt())
        }

    }

}
