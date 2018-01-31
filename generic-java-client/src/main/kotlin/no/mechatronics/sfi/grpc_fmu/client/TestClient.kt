/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology (NTNU)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package no.mechatronics.sfi.grpc_fmu.client

import no.mechatronics.sfi.grpc_fmu.FmiDefinitions

/**
 * @author Lars Ivar Hatledal
 */
fun main(args: Array<String>) {

    GenericFmuClient("127.0.0.1", 8000).use {

        println("Connected to remote FMU ${it.getModelName()}")

        it.createInstance().use { fmu ->
            if (fmu.init()) {

                fmu.modelVariables.forEach {

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

                val outputs = fmu.modelVariables.filter { it.causality == FmiDefinitions.Causality.OUTPUT }

                val dt = 1.0 / 100
                for (i in 1..10) {
                    fmu.step(dt)
                    outputs.forEach({
                        val value: Any? = when (it.type) {
                            FmiDefinitions.VariableType.INTEGER -> fmu.getReader(it.valueReference).readInt()
                            FmiDefinitions.VariableType.REAL -> fmu.getReader(it.valueReference).readReal()
                            FmiDefinitions.VariableType.STRING -> fmu.getReader(it.valueReference).readString()
                            FmiDefinitions.VariableType.BOOLEAN -> fmu.getReader(it.valueReference).readBoolean()
                            else -> null
                        }
                        println("t= ${fmu.currentTime}, ${it.varName} = $value")
                    })
                }

            }
        }

    }


}