package no.mechatronics.sfi.grpc_fmu.codegen

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import no.mechatronics.sfi.grpc_fmu.GrpcFmu
import no.mechatronics.sfi.grpc_fmu.convertName2
import no.mechatronics.sfi.grpc_fmu.isArray
import no.mechatronics.sfi.grpc_fmu.templates.ServerTemplate
import org.apache.commons.io.FileUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.nio.charset.Charset

object ServerGen {

    private val LOG: Logger = LoggerFactory.getLogger(ServerGen::class.java)

    fun generateServerCode(modelDescription: ModelDescription) : ServerTemplate.ServerCode {

        val sb = StringBuilder()
        modelDescription.modelVariables.forEach({

            if (!isArray(it.name)) {

                sb.append(ServerTemplate.generateRead(
                        varName1 = it.name,
                        varName2 = convertName2(it.name),
                        primitive1 = toRPCType2(it.typeName),
                        primitive2 = it.typeName,
                        returnType = toRPCType1(it.typeName)
                ))

                sb.append(ServerTemplate.generateWrite(
                        varName1 = it.name,
                        varName2 = convertName2(it.name),
                        dataType = toRPCType1(it.typeName)
                ))

            }

        })

        return ServerTemplate.generateClass(
                packageName = GrpcFmu.PACKAGE_NAME,
                fmuName = modelDescription.modelName,
                dynamicMethods = sb.toString())

    }

    fun generateServerCodeFiles(modelDescription: ModelDescription, outputFolder: File)  {

        LOG.info("Generating server code for source FMU '{}'", modelDescription.modelName)

        generateServerCode(modelDescription).apply {
            File(outputFolder, "Main.java").also { file ->
                FileUtils.writeStringToFile(file, main, Charset.forName("UTF-8"))
            }
            File(outputFolder, "HeartBeat.java").also { file ->
                FileUtils.writeStringToFile(file, heartbeat, Charset.forName("UTF-8"))
            }
            File(outputFolder, "ClientInfo.java").also { file ->
                FileUtils.writeStringToFile(file, clientInfo, Charset.forName("UTF-8"))
            }
            File(outputFolder, "${modelDescription.modelName}Server.java").also { file ->
                FileUtils.writeStringToFile(file, server, Charset.forName("UTF-8"))
            }

        }

    }

}

fun toRPCType1(typeName: String): String {

    when (typeName) {
        "Integer" -> return "Int"
        "Real" -> return "Real"
        "String" -> return "Str"
        "Boolean" -> return "Bool"
    }

    throw RuntimeException()

}

fun toRPCType2(typeName: String): String {

    when (typeName) {
        "Integer" -> return "int"
        "Real" -> return "double"
        "String" -> return "String"
        "Boolean" -> return "bool"
    }

    throw RuntimeException(typeName)

}
