package no.ntnu.ihb.fmuproxy.misc

data class ProxySettings(
        val host: String,
        val port: Int,
        val fmuName: String
)
