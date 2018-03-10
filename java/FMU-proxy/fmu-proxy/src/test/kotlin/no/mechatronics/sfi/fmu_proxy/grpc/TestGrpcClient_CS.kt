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

package no.mechatronics.sfi.fmu_proxy.grpc

import no.mechatronics.sfi.fmi4j.fmu.FmuFile
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
import no.mechatronics.sfi.fmu_proxy.grpc.services.GenericFmuServiceImpl
import org.junit.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.net.ServerSocket
import java.time.Duration
import java.time.Instant


class TestGrpcClient_CS {

    companion object {

        private val LOG: Logger = LoggerFactory.getLogger(TestGrpcClient_CS::class.java)

        private lateinit var server: GrpcFmuServer
        private lateinit var client: GenericFmuClient
        private lateinit var modelDescription: SimpleModelDescription


        @JvmStatic
        @BeforeClass
        fun setup() {

            val url = TestGrpcClient_CS::class.java.classLoader
                    .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
            Assert.assertNotNull(url)

            val fmuFile = FmuFile(url)
            modelDescription = fmuFile.modelDescription

            val port = ServerSocket(0).use { it.localPort }

            server = GrpcFmuServer(GenericFmuServiceImpl(fmuFile))
            server.start(port)

            client = GenericFmuClient("localhost", port)

//            fmuFile.asCoSimulationFmu().newInstance().use { fmu ->
//                fmu.init()
//                val dt = 1.0/100
//                val start = Instant.now()
//                while (fmu.currentTime < 10) {
//                    fmu.doStep(dt)
//                }
//                val end = Instant.now()
//                LOG.info("Duration: ${Duration.between(start, end).toMillis()}ms")
//            }

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
        Assert.assertEquals(modelDescription.modelName, client.modelName)
    }

    @Test
    fun testGuid() {
        Assert.assertEquals(modelDescription.guid, client.guid)
    }

    @Test
    fun testInstance() {

        client.createInstance().use { fmu ->

            Assert.assertTrue(fmu.init())
            var start = Instant.now()
            val dt = 1.0/100
            while (fmu.currentTime < 10) {
                val step: FmiDefinitions.Status = fmu.step(dt)
                Assert.assertTrue(step.code == FmiDefinitions.StatusCode.OK_STATUS)
            }
            val end = Instant.now()
            LOG.info("Duration: ${Duration.between(start, end).toMillis()}ms")

        }

    }

}
