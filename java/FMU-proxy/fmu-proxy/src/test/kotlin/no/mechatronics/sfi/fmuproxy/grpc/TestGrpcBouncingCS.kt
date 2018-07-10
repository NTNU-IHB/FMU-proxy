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

import no.mechatronics.sfi.fmi4j.importer.Fmu
import no.mechatronics.sfi.fmi4j.modeldescription.CommonModelDescription
import no.mechatronics.sfi.fmuproxy.TestUtils
import no.mechatronics.sfi.fmuproxy.runInstance
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File

@EnabledOnOs(OS.WINDOWS)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@EnabledIfEnvironmentVariable(named = "TEST_FMUs", matches = ".*")
class TestGrpcBouncingCS {

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(TestGrpcBouncingCS::class.java)
    }

    private val fmu: Fmu
    private val server: GrpcFmuServer
    private val client: GrpcFmuClient
    private val modelDescription: CommonModelDescription

    init {

        fmu = Fmu.from(File(TestUtils.getTEST_FMUs(),
                "FMI_2.0/CoSimulation/win64/FMUSDK/2.0.4/BouncingBall/bouncingBall.fmu"))
        modelDescription = fmu.modelDescription

        server = GrpcFmuServer(fmu)
        val port = server.start()

        client = GrpcFmuClient("localhost", port)

    }

    @AfterAll
    fun tearDown() {
        client.close()
        server.stop()
        fmu.close()
    }

    @Test
    fun testGuid() {
        val guid = client.modelDescription.guid.also { LOG.info("guid=$it") }
        Assertions.assertEquals(modelDescription.guid, guid)
    }
    
    @Test
    fun testModelName() {
        val modelName = client.modelDescription.modelName.also { LOG.info("modelName=$it") }
        Assertions.assertEquals(modelDescription.modelName, modelName)
    }

    @Test
    fun testInstance() {

        client.newInstance().use { instance ->

            val h = client.modelDescription.modelVariables
                    .getByName("h").asRealVariable()

            val dt = 1.0/100
            val stop = 100.0
            runInstance(instance, dt, stop) {
                h.read()
            }.also {
                LOG.info("Duration: ${it}ms")
            }

        }

    }

}
