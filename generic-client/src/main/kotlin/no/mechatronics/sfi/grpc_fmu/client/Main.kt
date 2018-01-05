package no.mechatronics.sfi.grpc_fmu.client

import no.mechatronics.sfi.grpc_fmu.FmiDefinitions

fun main(args: Array<String>) {

    GenericFmuClient("127.0.0.1", 8000).use {

        println("connected")

        println(it.getModelName())
        val fmu = it.createInstance()
        fmu.init()

        val modelVariables: FmiDefinitions.ScalarVariables = fmu.getModelVariables()

        modelVariables.valuesList.forEach {
            println("name: ${it.name}")
            println("Causality: ${it.causality}")
            println("Variability: ${it.variability}")
            val value: Any? = when (it.start.valueCase) {
                FmiDefinitions.Start.ValueCase.INTVALUE -> it.start.intValue
                FmiDefinitions.Start.ValueCase.REALVALUE -> it.start.realValue
                FmiDefinitions.Start.ValueCase.STRVALUE -> it.start.strValue
                FmiDefinitions.Start.ValueCase.BOOLVALUE -> it.start.boolValue
                else -> null
            }
            println("Start: $value")

        }

       // println(fmu.read("BulkModulus"))

    }


}