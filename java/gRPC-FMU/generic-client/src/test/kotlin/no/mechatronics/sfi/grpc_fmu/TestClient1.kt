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

package no.mechatronics.sfi.grpc_fmu

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.grpc_fmu.client.GenericFmuClient
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class TestClient1 {

    lateinit var server: GenericTestServer
    lateinit var modelDescription: SimpleModelDescription

    @Before
    fun setup() {

        val fmuFile = FmuFile(javaClass.classLoader.getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu"))
        modelDescription = fmuFile.modelDescription

        server = GenericTestServer(fmuFile)
        server.start()
    }

    @After
    fun tearDown() {
        server.stop()
    }

    @Test
    fun testClient() {
        GenericFmuClient("127.0.0.1", server.port!!).use {

            Assert.assertEquals(modelDescription.modelName, it.modelName)

            it.createInstance().use { fmu ->

                Assert.assertTrue(fmu.init())

                val dt = 1.0/100
                while (fmu.currentTime < 1) {
                    val step: FmiDefinitions.Status = fmu.step(dt)
                    Assert.assertTrue(step.code == FmiDefinitions.StatusCode.OK)
                }

            }
        }
    }

}
//
///**
// * @author Lars Ivar Hatledal
// */
//fun main(args: Array<String>) {
//
//    GenericFmuClient("127.0.0.1", 8000).use {
//
//        println("Connected to remote FMU '${it.modelName}'")
//
//        it.createInstance().use { fmu ->
//            if (fmu.init()) {
//
//                fmu.modelVariables.forEach {
//
//                    println("name: ${it.name}")
//                    println("Causality: ${it.causality}")
//                    println("Variability: ${it.variability}")
//                    println("Initial: ${it.initial}")
//
//                    when (it.variableType) {
//                        FmiDefinitions.VariableType.INTEGER -> it.start.intValue
//                        FmiDefinitions.VariableType.REAL -> it.start.realValue
//                        FmiDefinitions.VariableType.STRING -> it.start.strValue
//                        FmiDefinitions.VariableType.BOOLEAN -> it.start.boolValue
//                        else -> null
//                    }?.also {  println("Start: $it") }
//
//
//                    when (it.variableType) {
//                        FmiDefinitions.VariableType.INTEGER -> it.start.intValue
//                        FmiDefinitions.VariableType.REAL -> it.start.realValue
//                        FmiDefinitions.VariableType.STRING -> it.start.strValue
//                        FmiDefinitions.VariableType.BOOLEAN -> it.start.boolValue
//                        else -> null
//                    }?.also {  println("Value: $it") }
//
//                }
//
//                val dt = 1.0 / 100
//                val outputs = fmu.modelVariables.filter {
//                    it.causality == FmiDefinitions.Causality.OUTPUT
//                }
//                while (fmu.currentTime < 1) {
//                    fmu.step(dt)
//                    outputs.forEach({
//                        val value: Any? = when (it.variableType) {
//                            FmiDefinitions.VariableType.INTEGER -> fmu.read(it.valueReference).asInt()
//                            FmiDefinitions.VariableType.REAL -> fmu.read(it.valueReference).asReal()
//                            FmiDefinitions.VariableType.STRING -> fmu.read(it.valueReference).asString()
//                            FmiDefinitions.VariableType.BOOLEAN -> fmu.read(it.valueReference).asBoolean()
//                            else -> null
//                        }
//                        println("t= ${fmu.currentTime}, ${it.name} = $value")
//                    })
//                }
//
//            }
//        }
//
//    }
//
//}