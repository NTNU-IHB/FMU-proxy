package no.mechatronics.sfi.grpc_fmu.client

import no.mechatronics.sfi.grpc_fmu.FmiDefinitions

fun main(args: Array<String>) {

    GenericFmuClient("127.0.0.1", 7000).use {

        println("connected")

        println(it.getModelName())
        val fmu = it.createInstance()
        fmu.init()

        val modelVariables: FmiDefinitions.ScalarVariables = fmu.getModelVariables()

        modelVariables.valuesList.forEach {
            println(it.name)
            println(it.causality)

            FmiDefinitions.Start.newBuilder().setBoolValue(true)

            val value: Any? = when (it.start.valueCase) {
                FmiDefinitions.Start.ValueCase.INTVALUE -> it.start.intValue
                FmiDefinitions.Start.ValueCase.REALVALUE -> it.start.realValue
                FmiDefinitions.Start.ValueCase.STRVALUE -> it.start.strValue
                FmiDefinitions.Start.ValueCase.BOOLVALUE -> it.start.boolValue
                else -> null
            }
            println(value)

        }

       // println(fmu.read("BulkModulus"))

    }


}