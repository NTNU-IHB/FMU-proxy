package no.mechatronics.sfi.grpc_fmu.client

import no.mechatronics.sfi.grpc_fmu.FmiDefinitions

fun main(args: Array<String>) {

    GenericFmuClient("127.0.0.1", 52523).use {

        println("connected")

        println(it.getModelName())
        val fmu = it.createInstance()
        fmu.init()

        val modelVariables: FmiDefinitions.ScalarVariables = fmu.getModelVariables()

        modelVariables.valuesList.forEach {
            println(it.name)
        }

        println(fmu.read("BulkModulus"))

    }


}