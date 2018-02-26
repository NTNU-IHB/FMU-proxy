package no.mechatronics.sfi.rmu

interface RmuServer {

    fun start(port: Int)

    fun stop()

}