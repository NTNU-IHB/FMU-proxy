package no.mechatronics.sfi.grpc_fmu

import java.io.File


fun main(args: Array<String>) {

    if (args.isEmpty()) {
        error("no args")

    } else {

        if (args.size == 1) {

            val s = args[0]
            if (s == "debug") {
                GrpcFmu.generate(GrpcFmu.javaClass.classLoader.getResource("PumpControlledWinch/PumpControlledWinch.fmu"))
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

