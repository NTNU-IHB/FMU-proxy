package no.mechatronics.sfi.grpc_fmu.utils

import org.apache.commons.io.FileUtils
import java.io.File
import java.nio.charset.Charset

class FileFuture (
        val name: String,
        val text: String
) {

    fun create(dir: File) = create(dir, name)

    fun create(dir: File, name: String) : File {
        if (!dir.exists()) {
            dir.mkdirs()
        }

        return File(dir, name).also {
            FileUtils.writeStringToFile(it, text, Charset.forName("UTF-8"))
        }

    }

}