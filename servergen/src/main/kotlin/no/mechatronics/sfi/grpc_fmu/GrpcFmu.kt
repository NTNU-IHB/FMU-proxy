/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology
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

import com.google.common.io.Files
import io.grpc.internal.IoUtils
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.grpc_fmu.codegen.ProtoGen
import no.mechatronics.sfi.grpc_fmu.codegen.ServerGen
import no.mechatronics.sfi.grpc_fmu.utils.exctractModelDescriptionXml
import org.apache.commons.io.FileUtils
import org.slf4j.LoggerFactory
import java.io.File
import java.nio.charset.Charset
import org.apache.commons.io.IOUtils
import org.slf4j.Logger
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


object GrpcFmu {

    private val LOG: Logger = LoggerFactory.getLogger(GrpcFmu::class.java)

    const val PACKAGE_NAME = "no.mechatronics.sfi.grpc_fmu"
    private const val JAVA_SRC_OUTPUT_FOLDER = "src/main/java/"
    private const val PROTO_SRC_OUTPUT_FOLDER = "src/main/proto/"


    fun generate(file: File) = generate(FileInputStream(file), exctractModelDescriptionXml(FileInputStream(file)))

    fun generate(url: URL)= generate(url.openStream(), exctractModelDescriptionXml(url.openStream()))

    private fun generate(inputStream: InputStream, modelDescriptionXml: String) {

        val modelDescription = ModelDescription.parseModelDescription(modelDescriptionXml)

        val baseFile = File(modelDescription.modelName).apply {
            if (!exists()) {
                if (mkdir()) {
                    LOG.info("Created folder {}", absolutePath)
                }
            }
        }

        File(baseFile, "build.gradle").also { file ->
            FileOutputStream(file).use { fos ->
                IoUtils.copy(javaClass.classLoader.getResourceAsStream("build.gradle"), fos)
                LOG.info("Copied build.gradle to {}", file)
            }
        }


        GrpcFmu.javaClass.classLoader.getResourceAsStream("myzip.zip").also { zipStream ->
            ZipInputStream(zipStream).use { zis ->
                var nextEntry: ZipEntry? = zis.nextEntry
                while (nextEntry != null) {

                    if (!nextEntry.isDirectory) {
                        File(baseFile, nextEntry.name).also { file ->

                            if (!file.exists()) {
                                if (!file.parentFile.exists()) {
                                    Files.createParentDirs(file)
                                }

                                FileOutputStream(file).use { fis ->
                                    IOUtils.copy(zis, fis)
                                }
                            }

                        }
                    }
                    nextEntry = zis.nextEntry
                }
            }
        }


        val resourcesFile = File(baseFile,"src/main/resources/").apply {
            if (!exists()) {
                Files.createParentDirs(this)
            }
        }

        File(resourcesFile, "modelDescription.xml").let { file ->
            FileUtils.writeStringToFile(file, modelDescriptionXml, Charset.forName("UTF-8"))
        }

        File(resourcesFile, "${modelDescription.modelName}.fmu").let { file ->
            FileOutputStream(file).use { fis ->
                IOUtils.copy(inputStream, fis)
            }
        }

        ProtoGen.generateProtoCode(modelDescription).apply {
            definitions.create(resourcesFile)
            service.create(resourcesFile)
            compile(baseFile, "${baseFile.name}/$PROTO_SRC_OUTPUT_FOLDER", "${baseFile.name}/$JAVA_SRC_OUTPUT_FOLDER")
        }


        ServerGen.generateServerCode(modelDescription)
                .writeToDirectory(File(baseFile, "$JAVA_SRC_OUTPUT_FOLDER/${GrpcFmu.PACKAGE_NAME.replace(".", "//")}"
        ))


        try {
            ProcessBuilder()
                    .directory(baseFile)
                    .command("${baseFile.absolutePath}/gradlew.bat", "fatJar")
                    .redirectError(ProcessBuilder.Redirect.INHERIT)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .start()
                    .waitFor()

            File(baseFile, "build/libs/${modelDescription.modelName}-all.jar").apply {
                if (exists()) {
                    val dir = File(".")
                    FileUtils.copyFileToDirectory(this, dir)
                    LOG.info("Executable '{}' is located in directory '{}'", this.name, dir.absolutePath)
                }
            }
        } finally {

            fun deleteBaseFile(): Boolean {
                if (baseFile.exists()) {
                    if(baseFile.deleteRecursively()) {
                        LOG.info("Deleted folder {}", baseFile.absolutePath)
                        return true
                    } else {
                        LOG.info("Failed to delete folder {}", baseFile.absolutePath)
                    }
                    return false
                }
                return true
            }

            if (!deleteBaseFile()) {
                Runtime.getRuntime().addShutdownHook(Thread({
                    deleteBaseFile()
                }))
            }

        }

    }

}
