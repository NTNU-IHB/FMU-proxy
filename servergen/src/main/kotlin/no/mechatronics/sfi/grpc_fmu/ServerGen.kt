package no.mechatronics.sfi.grpc_fmu

import no.mechatronics.sfi.fmi4j.modeldescription.ModelDescription
import org.apache.commons.io.FileUtils
import org.jtwig.JtwigModel
import org.jtwig.JtwigTemplate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.nio.charset.Charset

object ServerGen {

    private val LOG: Logger = LoggerFactory.getLogger(ServerGen::class.java)

    private fun className(modelDescription: ModelDescription) : String =  "${modelDescription.modelName}Server"

    fun generateServerCode(modelDescription: ModelDescription) : String {

        val sb = StringBuilder()
        modelDescription.modelVariables.forEach({

            if (!isArray(it.name)) {
                JtwigTemplate.classpathTemplate("templates/grpc/read.twig").apply {
                    sb.append(render(JtwigModel.newModel()
                            .with("varName1", it.name)
                            .with("varName2", convertName2(it.name))
                            .with("primitive1", toRPCType2(it.typeName))
                            .with("primitive2", it.typeName)
                            .with("returnType", toRPCType1(it.typeName)))).append("\n")
                }

                JtwigTemplate.classpathTemplate("templates/grpc/write.twig").apply {
                    sb.append(render(JtwigModel.newModel()
                            .with("varName1", it.name)
                            .with("varName2", convertName2(it.name))
                            .with("dataType", toRPCType1(it.typeName)))).append("\n")
                }

            }

        })

        return JtwigTemplate.classpathTemplate("templates/grpc/body.twig").let {
            it.render(JtwigModel.newModel()
                    .with("packageName", GrpcFmu.PACKAGE_NAME)
                    .with("fmuName", modelDescription.modelName)
                    .with("dynamicMethods", sb.toString()))
        }

    }

    fun generateServerCodeFile(modelDescription: ModelDescription, outputFolder: String) : File {

        LOG.info("Generating server code for source FMU '{}'", modelDescription.modelName)
        val folder = outputFolder + GrpcFmu.PACKAGE_NAME.replace(".", "\\")
        val file = File("$folder${File.separator}${modelDescription.modelName}Server.java")
        FileUtils.writeStringToFile(file, generateServerCode(modelDescription), Charset.forName("UTF-8"))
        return file
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

    throw RuntimeException()

}
