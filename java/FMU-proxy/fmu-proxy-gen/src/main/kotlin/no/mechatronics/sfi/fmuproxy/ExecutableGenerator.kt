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

package no.mechatronics.sfi.fmuproxy

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescriptionParser
import no.mechatronics.sfi.fmuproxy.codegen.ProtoGen
import no.mechatronics.sfi.fmuproxy.codegen.ServerGen
import no.mechatronics.sfi.fmuproxy.utils.copyZippedContent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.nio.file.Files


const val PACKAGE_NAME = "no.mechatronics.sfi.fmuproxy"
const val KOTLIN_SRC_OUTPUT_FOLDER = "src/main/kotlin/"
const val PROTO_SRC_OUTPUT_FOLDER = "src/main/proto/"

/**
 *
 * @author Lars Ivar Hatledal
 */
class ExecutableGenerator(
        private val inputStream: InputStream,
        private val modelDescriptionXml: String
) {

    constructor(file: File): this(FileInputStream(file), ModelDescriptionParser.extractModelDescriptionXml(FileInputStream(file)))

    @JvmOverloads
    fun generate(outDir: File? = null) {

        @Suppress("NAME_SHADOWING")
        val outDir: File = outDir ?: File(defaultOut)

        val modelDescription = ModelDescriptionParser.parse(modelDescriptionXml)
        //val tempDir = Files.createTempDirectory("fmuproxy").toFile()

        val baseFile = File(modelDescription.modelName).apply {
            if (!exists() && mkdir()) {
                LOG.debug("Created folder $absolutePath")
            }
        }

        try {

            "build.gradle".also { name ->
                File(baseFile, name).also { file ->
                    FileOutputStream(file).use { fos ->
                        javaClass.classLoader.getResourceAsStream(name).use { resource ->
                            resource.copyTo(fos)
                        }
                        LOG.debug("Copied $name to $file")
                    }
                }
            }

            File(baseFile, "settings.gradle").also { file ->
                file.createNewFile()
            }

            copyZippedContent(baseFile, javaClass.classLoader.getResourceAsStream("gradlew.zip"))

            val resourcesFile = File(baseFile,"src/main/resources/").apply {
                if (!exists()) {
                    Files.createDirectories(this.toPath())
                }
            }

            File(resourcesFile, "modelDescription.xml").also { file ->
                file.writeText(modelDescriptionXml)
            }

            "log4j.properties".also { name ->
                File(resourcesFile, name).also { file ->
                    FileOutputStream(file).use { fos ->
                        javaClass.classLoader.getResourceAsStream(name).use { resource ->
                            resource.copyTo(fos)
                        }
                        LOG.debug("Copied $name to $file")
                    }
                }
            }

            File(resourcesFile, "${modelDescription.modelName}.fmu").also { file ->
                FileOutputStream(file).use { fos ->
                    inputStream.use { it.copyTo(fos) }
                }
            }

            ProtoGen.generateProtoCode(modelDescription, baseFile)
            ServerGen.generateServerCode(modelDescription, baseFile)

            ProcessBuilder()
                    .directory(baseFile)
                    .command("${baseFile.absolutePath}/gradlew.bat", "shadowJar")
                    .redirectError(ProcessBuilder.Redirect.INHERIT)
                    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                    .start()
                    .waitFor().also {status ->

                if (status == 0) {
                    val fileName = "${modelDescription.modelName}.jar"
                    File(baseFile, "build/libs/$fileName").apply {
                        if (exists()) {
                            val target = File(outDir, fileName)
                            copyTo(target, overwrite = true)
                            LOG.info("Executable '$name' is located here: '$target'")
                        }
                    }
                } else {
                    LOG.error("Process returned with status: $status")
                }
            }
        } finally {
            if (baseFile.deleteRecursively()) {
                LOG.debug("Deleted temp folder: $baseFile")
            } else {
                LOG.warn("Failed to delete folder: $baseFile")
            }
        }

    }

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(ExecutableGenerator::class.java)

        private const val defaultOut = "."

    }

}
