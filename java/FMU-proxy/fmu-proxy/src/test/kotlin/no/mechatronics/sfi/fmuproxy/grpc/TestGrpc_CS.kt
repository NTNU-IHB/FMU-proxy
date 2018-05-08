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

package no.mechatronics.sfi.fmuproxy.grpc

import no.mechatronics.sfi.fmi4j.common.FmiStatus
import no.mechatronics.sfi.fmi4j.fmu.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.system.measureTimeMillis


class TestGrpc_CS {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(TestGrpc_CS::class.java)

        private lateinit var server: GrpcFmuServer
        private lateinit var client: GrpcFmuClient
        private lateinit var modelDescription: CommonModelDescription


        @JvmStatic
        @BeforeClass
        fun setup() {

            val url = TestGrpc_CS::class.java.classLoader
                    .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
            Assert.assertNotNull(url)

            val fmu = Fmu.from(url)
            modelDescription = fmu.modelDescription

            server = GrpcFmuServer(fmu)
            val port = server.start()

            client = GrpcFmuClient("localhost", port)

        }

        @JvmStatic
        @AfterClass
        fun tearDown() {
            client.close()
            server.stop()
        }

    }

    @Test
    fun testModelName() {
        val modelName = client.modelDescription.modelName.also { LOG.info("modelName=$it") }
        Assert.assertEquals(modelDescription.modelName, modelName)
    }

    @Test
    fun testGuid() {
        val guid = client.modelDescription.guid.also { LOG.info("guid=$it") }
        Assert.assertEquals(modelDescription.guid, guid)
    }

//    @Test
//    fun testWrongId() {
//        try {
//            client.blockingStub.reset(Proto.UInt.newBuilder().setValue(0).build())
//        } catch (ex: StatusRuntimeException) {
//            LOG.info("${ex.message}}")
//        }
//    }

    @Test
    fun testInstance() {

        client.newInstance().use { instance ->

            Assert.assertEquals(FmiStatus.OK, instance.init())

            val controllerMaximum = client.modelDescription.modelVariables
                    .getByName("Controller.maximum").asRealVariable()
            LOG.info("Controller.maximum=$controllerMaximum")

            val dt = 1.0/100
            measureTimeMillis {
                while (instance.currentTime < 10) {
                    val step = instance.step(dt)
                    Assert.assertEquals(FmiStatus.OK, step)
                }
            }.also { LOG.info("Duration: ${it}ms") }


        }

    }

}
