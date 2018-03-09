/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package no.mechatronics.sfi.fmu_proxy

import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.HelpFormatter
import org.apache.commons.cli.Options
import java.io.File

/**
 *
 * @author Lars Ivar Hatledal
 */
class ApplicationStarter {

    companion object {

        private const val HELP = "help"
        private const val FMU_FILE = "fmu"
        private const val OUTPUT_FOLDER = "out"

        @JvmStatic
        fun main(args: Array<String>) {

            val options = Options().apply {

                addOption(HELP, false, "Prints this message")
                addOption(FMU_FILE, true, "Path to the fmu")
                addOption(OUTPUT_FOLDER, true, "Specify where to copy the generated .jar (optional)")

            }

            DefaultParser().parse(options, args).apply {

                if (args.isEmpty() || hasOption(HELP)) {
                    HelpFormatter().printHelp("fmu-proxy", options)
                } else {
                    getOptionValue(FMU_FILE)?.also {

                        File(it.replace("\\", "/")).apply {
                            if (exists() && name.endsWith(".fmu", true)) {

                                var out = File(".")
                                if (hasOption(OUTPUT_FOLDER)) {
                                    val outCandidate = File(getOptionValue(OUTPUT_FOLDER))
                                    if (outCandidate.isDirectory) {
                                        out = outCandidate
                                    }
                                }

                                ExecutableGenerator(this).generate(out)

                            } else {
                                error("Not a valid file: $absolutePath")
                            }
                        }

                    }
                }
            }

        }

    }

}


