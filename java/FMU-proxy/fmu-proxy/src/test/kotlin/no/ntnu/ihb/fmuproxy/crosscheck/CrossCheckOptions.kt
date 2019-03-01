package no.ntnu.ihb.fmi4j.crosscheck


data class CrossCheckOptions(
        var startTime: Double = 0.0,
        var stopTime: Double = 10.0,
        var stepSize: Double = 1e-3,
        var relTol: Double = 1e-3,
        var absTol: Double = 1e-3
) {

    companion object {

        fun parse(txt: String): CrossCheckOptions {

            return CrossCheckOptions().apply {

                txt.trim().split("\n").forEach { line ->

                    val split = line.split(",")
                    if (split.isNotEmpty()) {
                        val (fst, snd) = split
                        when (fst) {
                            "StartTime" -> startTime = snd.toDouble()
                            "StopTime" -> stopTime = snd.toDouble()
                            "StepSize" -> stepSize = snd.toDouble()
                            "RelTol" -> relTol = snd.toDouble()
                            "AbsTol" ->  absTol = snd.toDouble()
                        }
                    }

                }

            }

        }

    }
}