package no.ntnu.grpc_fmu

import no.ntnu.fmi4j.Fmu
import no.ntnu.fmi4j.modeldescription.ModelDescription
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
                val readTemplate = JtwigTemplate.classpathTemplate("templates/serverread.twig")
                sb.append(readTemplate.render(JtwigModel.newModel()
                        .with("varName1", it.name)
                        .with("varName2", convertName2(it.name))
                        .with("primitive1", toRPCType2(it.typeName))
                        .with("primitive2", it.typeName)
                        .with("returnType", toRPCType1(it.typeName)))).append("\n")

                val writeTemplate = JtwigTemplate.classpathTemplate("templates/serverwrite.twig")
                sb.append(writeTemplate.render(JtwigModel.newModel()
                        .with("varName1", it.name)
                        .with("varName2", convertName2(it.name))
                        .with("dataType", toRPCType1(it.typeName)))).append("\n")
            }

        })

        val protoTemplate = JtwigTemplate.classpathTemplate("templates/server.twig")
        val model = JtwigModel.newModel()
                .with("packageName", GrpcFmu.PACKAGE_NAME)
                .with("fmuName", modelDescription.modelName)
                .with("dynamicMethods", sb.toString())

        return protoTemplate.render(model)

    }

    fun generateServerCodeFile(modelDescription: ModelDescription) : File {

        LOG.info("Generating server code for source FMU '{}'", modelDescription.modelName)
        val folder = GrpcFmu.JAVA_SRC_OUTPUT_FOLDER + File.separator + GrpcFmu.PACKAGE_NAME.replace(".", "\\")
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

//fun toRPCType3(typeName: String): String {
//
//    when (typeName) {
//        "Integer" -> return "Integer"
//        "Real" -> return "Real"
//        "String" -> return "String"
//        "Boolean" -> return "bool"
//    }
//
//    throw RuntimeException()
//
//}

