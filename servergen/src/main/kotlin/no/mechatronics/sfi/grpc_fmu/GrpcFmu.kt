package no.mechatronics.sfi.grpc_fmu

import com.google.common.io.Files
import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import org.apache.commons.io.FileUtils
import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate
import org.slf4j.LoggerFactory
import java.io.File
import java.nio.charset.Charset
import org.apache.commons.io.IOUtils
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream


fun main(args: Array<String>) {

    if (args.isEmpty()) {
        error("no args")

    } else {

        if (args.size == 1) {

            val s = args[0]
            if (s == "debug") {
                GrpcFmu.generate(GrpcFmu.javaClass.classLoader.getResource("fmus/cs/PumpControlledWinch/PumpControlledWinch.fmu"))
            } else if (s.endsWith(".fmu", true)) {
                with(File(s)) {
                    if (exists()) {
                        GrpcFmu.generate(this)
                    } else {
                        error("No such file: '$absolutePath'")
                    }
                }
            }
        }

    }

}

object GrpcFmu {

    private val LOG = LoggerFactory.getLogger(GrpcFmu::class.java)

    const val PACKAGE_NAME = "no.mechatronics.sfi.grpc_fmu"
    const val JAVA_SRC_OUTPUT_FOLDER = "src/main/java/"
    const val PROTO_SRC_OUTPUT_FOLDER = "src/main/proto/"


    fun generate(file: File) {
        generate(FileInputStream(file), ModelDescription.parseModelDescription(file))
    }
    fun generate(url: URL) {
        generate(url.openStream(), ModelDescription.parseModelDescription(url))
    }

    private fun generate(inputStream: InputStream, modelDescription: ModelDescription) {

        val baseFile = File(modelDescription.modelName).apply {
            if (!exists()) {
                if (mkdir()) {
                    LOG.info("Created folder {}", absolutePath)
                }
            }
        }

        File(baseFile, "src/main/resources/${modelDescription.modelName}.fmu").let { file ->
            if (!file.exists()) {
                Files.createParentDirs(file)
            }
            FileOutputStream(file).use { fis ->
                IOUtils.copy(inputStream, fis)
            }
        }
        JtwigTemplate.classpathTemplate("templates/gradlebuild.twig").apply {
            val render = render(JtwigModel.newModel()
                    .with("mainClass", "$PACKAGE_NAME.${modelDescription.modelName}Server"))
            File(baseFile,"build.gradle").also {
                FileUtils.write(it, render, Charset.forName("UTF-8"))
            }
        }
        val zipStream = GrpcFmu.javaClass.classLoader.getResourceAsStream("myzip.zip")
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

        val protoFile = ProtoGen.generateProtoFile(modelDescription, "${baseFile.name}/$PROTO_SRC_OUTPUT_FOLDER")
        ProtoGen.compileProto(protoFile, "${baseFile.name}/src/main/proto/", "${baseFile.name}/$JAVA_SRC_OUTPUT_FOLDER")
        ServerGen.generateServerCodeFile(modelDescription, "${baseFile.name}/$JAVA_SRC_OUTPUT_FOLDER")
        File(File(baseFile, "src/main/resources"), protoFile.name).let { file ->
            FileUtils.copyFile(protoFile, file)
        }
        protoFile.parentFile.deleteRecursively()

        try {
            ProcessBuilder()
                    .directory(baseFile)
                    .command("gradlew.bat", "fatJar")
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
            if (baseFile.exists()) {
                if(baseFile.deleteRecursively()) {
                    LOG.info("Deleted folder {}", baseFile.absolutePath)
                }
            }
        }
    }



}


fun isArray(name: String) : Boolean {
    return "[" in name && "]" in name
}

fun convertName1(str: String): String {
    return str.substring(0, 1).toUpperCase() + str.substring(1).replace(".", "_")
}

fun convertName2(str: String): String {

    val split = str.replace("_".toRegex(), ".").split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    val sb = StringBuilder()

    for (s in split) {
        sb.append(s.substring(0, 1).toUpperCase()).append(s.substring(1))
    }
    return sb.toString()

}
