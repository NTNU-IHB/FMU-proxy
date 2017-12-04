package no.mechatronics.sfi.grpc_fmu

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import org.apache.commons.io.FileUtils
import org.jtwig.JtwigTemplate
import org.jtwig.JtwigModel
import java.io.File
import java.nio.charset.Charset
import org.apache.commons.io.FilenameUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ProtoGen {

    private val LOG: Logger = LoggerFactory.getLogger(ProtoGen::class.java)

    fun generateProtoString(modelDescription: ModelDescription): String {

        val sb = StringBuilder()
        modelDescription.modelVariables.forEach({

            val isArray = isArray(it.name)
            if (!isArray) {

                JtwigTemplate.classpathTemplate("templates/proto/read.twig").apply {
                    sb.append(render(JtwigModel.newModel()
                            .with("varName", convertName1(it.name))
                            .with("typeName", it.typeName)))
                }


                JtwigTemplate.classpathTemplate("templates/proto/write.twig").apply {
                    sb.append(render(JtwigModel.newModel()
                            .with("varName", convertName1(it.name))
                            .with("typeName", it.typeName)))
                }

            }

        })

        return JtwigTemplate.classpathTemplate("templates/proto/body.twig").let {
            it.render(JtwigModel.newModel()
                    .with("packageName", GrpcFmu.PACKAGE_NAME)
                    .with("fmuName", modelDescription.modelName)
                    .with("services", sb.toString()))
        }

    }

    fun generateProtoFile(modelDescription: ModelDescription, outputFolder: String): File {

        val generalProtoFile = File(outputFolder + modelDescription.modelName + ".proto")
        FileUtils.writeStringToFile(generalProtoFile, generateProtoString(modelDescription), Charset.forName("UTF-8"))
        return generalProtoFile

    }

    fun compileProto(protoFile: File, protoSrc: String, javaOut: String) {

        LOG.info("Compiling proto..")

        val baseName = FilenameUtils.getBaseName(protoFile.absolutePath)

        File(javaOut).apply {
            if (!exists()) {
                mkdirs()
            }
        }

        val cmd = arrayOf("protoc", "--java_out=\"$javaOut\"", "--grpc-java_out=\"$javaOut\"", "--proto_path=\".\"", "\"$protoSrc$baseName.proto\"")
        ProcessBuilder()
                .command(*cmd)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                .start()
                .waitFor()

        LOG.info("Compiling done!")

    }

}


