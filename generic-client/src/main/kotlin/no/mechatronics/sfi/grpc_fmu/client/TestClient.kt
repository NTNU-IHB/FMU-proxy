package no.mechatronics.sfi.grpc_fmu.client

import no.mechatronics.sfi.grpc_fmu.FmiDefinitions

fun main(args: Array<String>) {

    GenericFmuClient("127.0.0.1", 50943).use {


        println("Connected to remote FMU ${it.getModelName()}")

        it.createInstance().use { fmu ->
            fmu.init()

            fmu.modelVariables.valuesList.forEach {

                println("name: ${it.varName}")
                println("Causality: ${it.causality}")
                println("Variability: ${it.variability}")
                println("Initial: ${it.initial}")

                val startValue: Any? = when (it.type) {
                    FmiDefinitions.VariableType.INTEGER -> it.start.intValue
                    FmiDefinitions.VariableType.REAL -> it.start.realValue
                    FmiDefinitions.VariableType.STRING -> it.start.strValue
                    FmiDefinitions.VariableType.BOOLEAN -> it.start.boolValue
                    else -> null
                }
                println("Start: ${startValue}")

                val value: Any? = when (it.type) {
                    FmiDefinitions.VariableType.INTEGER -> it.start.intValue
                    FmiDefinitions.VariableType.REAL -> it.start.realValue
                    FmiDefinitions.VariableType.STRING -> it.start.strValue
                    FmiDefinitions.VariableType.BOOLEAN -> it.start.boolValue
                    else -> null
                }
                println("Value: ${value}")

            }

            val outputs = fmu.modelVariables.valuesList.filter { it.causality == FmiDefinitions.Causality.OUTPUT }

            val dt = 1.0/100
            for (i in 1..10) {
                println(fmu.step(dt))
                outputs.forEach({
                    val value: Any? = when (it.type) {
                        FmiDefinitions.VariableType.INTEGER -> it.start.intValue
                        FmiDefinitions.VariableType.REAL -> it.start.realValue
                        FmiDefinitions.VariableType.STRING -> it.start.strValue
                        FmiDefinitions.VariableType.BOOLEAN -> it.start.boolValue
                        else -> null
                    }
                    println("t= ${fmu.currentTime}, ${it.varName} = $value")
                })
            }

        }

    }




}