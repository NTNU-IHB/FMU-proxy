//package no.mechatronics.sfi.grpc_fmu
//
//import org.apache.commons.io.IOUtils
//import org.junit.After
//import org.junit.Assert
//import org.junit.Before
//import org.junit.Test
//import org.junit.Assert.*
//import java.io.File
//import java.io.FileOutputStream
//import java.nio.file.Files
//
//import no.mechatronics.sfi.grpc_fmu.codegen.ProtoGen
//import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
//import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription
//
//class ProtoGenKtTest {
//
//    lateinit var modelDescription: SimpleModelDescription
//    lateinit var temp: File
//
//    @Before
//    fun setUp() {
//
//        val url = ProtoGenKtTest::class.java.classLoader
//                .getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu")
//        assertNotNull(url)
//        modelDescription = ModelDescriptionParser.parse(url)
//
//        temp = Files.createTempDirectory("grpc_fmu").toFile()
//
//    }
//
//    @After
//    fun tearDown() {
//        temp.deleteRecursively()
//    }
//
//    @Test
//    fun generateProtoString() {
//        println(ProtoGen.generateProtoCode(modelDescription))
//    }
//
//    @Test
//    fun compileProto() {
//
//        fun copyFileToTemp(name: String) {
//
//            ProtoGenKtTest::class.java.classLoader.getResourceAsStream(name).use { src ->
//                Assert.assertNotNull(src)
//                FileOutputStream(File(temp, name)).use { fos ->
//                    IOUtils.copy(src, fos)
//                }
//            }
//
//        }
//
//
//        copyFileToTemp("protoc-3.5.1-win32.exe")
//        copyFileToTemp("protoc-gen-grpc-java.exe")
//
//        Assert.assertTrue(ProtoGen.generateProtoCode(modelDescription).compile(temp,"generated/src/main/proto/", "generated/src/main/java/"))
//
//    }
//
//}