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

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.grpc_fmu.codegen.ProtoGen
import no.mechatronics.sfi.grpc_fmu.codegen.ServerGen
import no.mechatronics.sfi.grpc_fmu.utils.extractModelDescriptionXml
import org.apache.commons.io.FileUtils
import org.slf4j.LoggerFactory
import java.nio.charset.Charset
import org.apache.commons.io.IOUtils
import org.slf4j.Logger
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL
import java.nio.file.Files
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

const val PACKAGE_NAME = "no.mechatronics.sfi.grpc_fmu"
const val KOTLIN_SRC_OUTPUT_FOLDER = "src/main/kotlin/"
const val PROTO_SRC_OUTPUT_FOLDER = "src/main/proto/"
/**
 *
 * @author Lars Ivar Hatledal
 */
class GrpcFmu(
        private val inputStream: InputStream,
        private val modelDescriptionXml: String
) {

   companion object {
       private val LOG: Logger = LoggerFactory.getLogger(GrpcFmu::class.java)
   }

    constructor(file: File): this(FileInputStream(file), extractModelDescriptionXml(FileInputStream(file)))
    constructor(url: URL): this(url.openStream(), extractModelDescriptionXml(url.openStream()))

    fun generate(outDir: File = File(".")) {

        val modelDescription = ModelDescriptionParser.parse(modelDescriptionXml)
        //val tempDir = Files.createTempDirectory("grpc_fmu").toFile()

        val baseFile = File(modelDescription.modelName).apply {
            if (!exists() && mkdir()) {
                LOG.debug("Created folder $absolutePath")
            }
        }

        try {
            "build.gradle".also { name ->
                File(baseFile, name).also { file ->
                    FileOutputStream(file).use { fos ->
                        IOUtils.copy(javaClass.classLoader.getResourceAsStream(name), fos)
                        LOG.debug("Copied $name to $file")
                    }
                }
            }

            File(baseFile, "settings.gradle").also { file ->
                file.createNewFile()
            }

            copyZippedContent(baseFile)

            val resourcesFile = File(baseFile,"src/main/resources/").apply {
                if (!exists()) {
                    Files.createDirectories(this.toPath())
                }
            }

            File(resourcesFile, "modelDescription.xml").also { file ->
                FileUtils.writeStringToFile(file, modelDescriptionXml, Charset.forName("UTF-8"))
            }

            "log4j.properties".also { name ->
                File(resourcesFile, name).also { file ->
                    FileOutputStream(file).use { fos ->
                        IOUtils.copy(javaClass.classLoader.getResourceAsStream(name), fos)
                        LOG.debug("Copied $name to $file")
                    }
                }
            }

            File(resourcesFile, "${modelDescription.modelName}.fmu").also { file ->
                FileOutputStream(file).use { fos ->
                    IOUtils.copy(inputStream, fos)
                }
            }

            ProtoGen.generateProtoCode(modelDescription).apply {

                val packageName = PACKAGE_NAME.replace(".", "/")
                val protoOut = File(baseFile, "${PROTO_SRC_OUTPUT_FOLDER}/$packageName")
                create(protoOut)

            }

            ServerGen.generateServerCode(modelDescription, baseFile)
            ProcessBuilder()
                    .directory(baseFile)
                    .command("${baseFile.absolutePath}/gradlew.bat", "fatJar")
                    .redirectError(ProcessBuilder.Redirect.INHERIT)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .start()
                    .waitFor().also {status ->

                if (status == 0) {
                    File(baseFile, "build/libs/${modelDescription.modelName}.jar").apply {
                        if (exists()) {
                            FileUtils.copyFileToDirectory(this, outDir)
                            LOG.info("Executable '{}' is located in directory '{}'", this.name, outDir.absolutePath)
                        }
                    }
                } else {
                    LOG.error("Process returned with status: {}", status)
                }
            }
        } finally {
            if (baseFile.deleteRecursively()) {
                LOG.debug("Deleted temp folder $baseFile")
            } else {
                LOG.warn("Failed to delete folder $baseFile")
            }
        }

    }

    private fun copyZippedContent(baseFile: File) {
        javaClass.classLoader.getResourceAsStream("gradlew.zip").also { zipStream ->
            ZipInputStream(zipStream).use { zis ->
                var nextEntry: ZipEntry? = zis.nextEntry
                while (nextEntry != null) {
                    if (!nextEntry.isDirectory) {
                        File(baseFile, nextEntry.name).also { file ->
                            if (!file.exists()) {
                                if (!file.parentFile.exists()) {
                                    file.parentFile.mkdirs()
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
    }


}
