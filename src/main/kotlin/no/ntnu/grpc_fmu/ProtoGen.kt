package no.ntnu.grpc_fmu

import no.ntnu.fmi4j.modeldescription.ModelDescription
import org.apache.commons.exec.CommandLine
import org.apache.commons.io.FileUtils
import org.jtwig.JtwigTemplate
import org.jtwig.JtwigModel
import java.io.File
import java.nio.charset.Charset
import org.apache.commons.io.FilenameUtils
import org.apache.commons.exec.DefaultExecutor
import org.slf4j.Logger
import org.slf4j.LoggerFactory

object ProtoGen {

    private val LOG: Logger = LoggerFactory.getLogger(ProtoGen::class.java)

    fun generateProtoString(modelDescription: ModelDescription) : String {

        val rpcBuilder = StringBuilder()

        modelDescription.modelVariables.forEach({

            val isArray = isArray(it.name)
            if (!isArray) {

                val readTemplate = JtwigTemplate.classpathTemplate("templates/rpcread.twig")
                rpcBuilder.append(readTemplate.render(JtwigModel.newModel()
                        .with("varName", convertName1(it.name))
                        .with("typeName", it.typeName)))

                val writeTemplate = JtwigTemplate.classpathTemplate("templates/rpcwrite.twig")
                rpcBuilder.append(writeTemplate.render(JtwigModel.newModel()
                        .with("varName", convertName1(it.name))
                        .with("typeName", it.typeName)))

            }

        })

        val generalProtoTemplate = JtwigTemplate.classpathTemplate("templates/fmugeneralproto.twig")
        return generalProtoTemplate.render(JtwigModel.newModel()
                .with("packageName", GrpcFmu.PACKAGE_NAME)
                .with("fmuName", modelDescription.modelName)
                .with("services", rpcBuilder.toString()))

    }

    fun generateProtoFile(modelDescription: ModelDescription) : File {

        val generalProtoFile = File(GrpcFmu.PROTO_SRC_OUTPUT_FOLDER + File.separator + modelDescription.modelName + ".proto")
        FileUtils.writeStringToFile(generalProtoFile, generateProtoString(modelDescription), Charset.forName("UTF-8"))
        return generalProtoFile

    }

    fun compileProto(file : File) {

        LOG.info("Compiling proto..")

        val baseName = FilenameUtils.getBaseName(file.getAbsolutePath())
        val workingDir = File("").absoluteFile

        val protoSrc = GrpcFmu.PROTO_SRC_OUTPUT_FOLDER + File.separator
        val out = GrpcFmu.JAVA_SRC_OUTPUT_FOLDER + File.separator
        File(out).apply {
            if (!exists()) {
                mkdirs()
            }
        }

        val cmd = "protoc --java_out=\"$out\" --grpc-java_out=\"$out\" --proto_path=\".\" \"$protoSrc$baseName.proto\""
        val commandLine = CommandLine.parse(cmd)
        val executor = DefaultExecutor()
        executor.workingDirectory = workingDir

        executor.execute(commandLine)

        LOG.info("Compiling done")

    }

}

