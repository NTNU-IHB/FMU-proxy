package no.mechatronics.sfi.grpc_fmu

object GrpcFmu {

    val PACKAGE_NAME = "no.ntnu.grpc_fmu.generated"
    val JAVA_SRC_OUTPUT_FOLDER = "generated/java"
    val PROTO_SRC_OUTPUT_FOLDER = "generated/proto"

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
