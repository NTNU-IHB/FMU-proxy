package no.mechatronics.sfi.grpc_fmu.client

fun main(args: Array<String>) {

    GenericFmuClient("127.0.0.1", 57134).use {

        println("connected")

        println(it.getModelName())

    }

}