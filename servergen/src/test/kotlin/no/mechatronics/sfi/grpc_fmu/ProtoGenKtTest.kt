package no.mechatronics.sfi.grpc_fmu

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.grpc_fmu.codegen.ProtoGen
import org.apache.commons.io.IOUtils
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files

class ProtoGenKtTest {

    lateinit var modelDescription: ModelDescription
    lateinit var temp: File

    @Before
    fun setUp() {

        val url = ProtoGenKtTest::class.java.classLoader.getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
        assertNotNull(url)
        modelDescription = ModelDescription.parseModelDescription(url)

        temp = Files.createTempDirectory("grpc_fmu").toFile()

    }

    @After
    fun tearDown() {
        temp.deleteRecursively()
    }

    @Test
    fun generateProtoString() {

        println(ProtoGen.generateProtoString(modelDescription))

    }

    @Test
    fun compileProto() {



        fun copyFile(name: String) {

            ProtoGenKtTest::class.java.classLoader.getResourceAsStream(name).use { src ->
                Assert.assertNotNull(src)
                FileOutputStream(File(temp, name)).use { fos ->
                    IOUtils.copy(src, fos)
                }
            }

        }


        copyFile("protoc.exe")
        copyFile("protoc-gen-grpc-java.exe")

        val file = ProtoGen.generateProtoFile(modelDescription, "generated/proto/")
        assertNotNull(file)

        ProtoGen.compileProto(temp, file.second, "generated/proto/","generated/java/")

        //Assert.assertTrue(file.delete())

    }

}