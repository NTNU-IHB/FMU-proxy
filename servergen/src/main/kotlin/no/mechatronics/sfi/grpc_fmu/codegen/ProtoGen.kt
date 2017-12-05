package no.mechatronics.sfi.grpc_fmu.codegen

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.grpc_fmu.GrpcFmu
import no.mechatronics.sfi.grpc_fmu.convertName1
import no.mechatronics.sfi.grpc_fmu.isArray
import no.mechatronics.sfi.grpc_fmu.templates.ProtoTemplate
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

                sb.append(ProtoTemplate.generateRead(
                        varName = convertName1(it.name),
                        typeName = it.typeName
                ))

                sb.append(ProtoTemplate.generateWrite(
                        varName = convertName1(it.name),
                        typeName = it.typeName
                ))

            }

        })

        return ProtoTemplate.generateBody(
                packageName = GrpcFmu.PACKAGE_NAME,
                fmuName = modelDescription.modelName,
                instanceServices = sb.toString()
        )

    }

    fun generateProtoFile(modelDescription: ModelDescription, outputFolder: String): File {

        val generalProtoFile = File(outputFolder + modelDescription.modelName + ".proto")
        FileUtils.writeStringToFile(generalProtoFile, generateProtoString(modelDescription), Charset.forName("UTF-8"))
        return generalProtoFile

    }

    fun compileProto(protocDir: File, protoFile: File, protoSrc: String, javaOut: String) {

        LOG.info("Compiling proto..")

        val baseName = FilenameUtils.getBaseName(protoFile.absolutePath)

        File(javaOut).apply {
            if (!exists()) {
                mkdirs()
            }
        }

        val cmd = arrayOf("${protocDir.absolutePath}/protoc.exe/", "--java_out=\"$javaOut\"", "--grpc-java_out=\"$javaOut\"", "--proto_path=\".\"", "\"$protoSrc$baseName.proto\"")
        ProcessBuilder()
                .command(*cmd)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .redirectOutput(ProcessBuilder.Redirect.INHERIT)
                .start()
                .waitFor()

        LOG.info("Compiling done!")

    }

}


