package no.mechatronics.sfi.grpc_fmu

import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Options
import java.io.File

class Main {

    companion object {

        const val FMU_FILE = "fmu"
        const val OUTPUT_FOLDER = "out"

        @JvmStatic
        fun main(args: Array<String>) {

            if (args.isEmpty()) {
                error("no args.. exiting!")
            }


            val options = Options().apply {

                addOption(FMU_FILE, true, "Path to the fmu")
                addOption(OUTPUT_FOLDER, true, "Specify where to copy the generated .jar")

            }

            val parser = DefaultParser()
            val cmd = parser.parse(options, args)

            cmd.apply {
                getOptionValue(FMU_FILE)?.let { path ->
                    val file = File(path.replace("\\", "/"))
                    if (file.exists() && file.name.endsWith(".fmu", true)) {
                        GrpcFmu.generate(file)
                    } else {
                        error("Not a valid file: ${file.absolutePath}")
                    }
                }
            }

        }

    }

}


