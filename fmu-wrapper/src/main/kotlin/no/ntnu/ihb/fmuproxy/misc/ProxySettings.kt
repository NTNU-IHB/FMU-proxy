package no.ntnu.ihb.fmuproxy.misc

class ProxySettings(
    val fmuName: String,
    remoteString: String?
) {

    val remote = remoteString?.let {
        RemoteAddress.parse(it)
    }

    override fun toString(): String {
        return "ProxySettings(fmuName='$fmuName', remote=$remote)"
    }

}

data class RemoteAddress(
    val host: String,
    val port: Int
) {

    val strRepr = "$host:$port"

    companion object {

        fun parse(str: String): RemoteAddress {
            val (host, port) = str.split(":")
            return RemoteAddress(host, port.toInt())
        }

    }

}
