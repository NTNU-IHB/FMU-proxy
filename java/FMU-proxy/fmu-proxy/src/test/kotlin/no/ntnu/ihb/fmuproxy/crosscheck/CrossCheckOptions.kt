package no.ntnu.ihb.fmuproxy.crosscheck

import no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment


class DefaultExperimentImpl : DefaultExperiment {

    override var startTime: Double = 0.0
    override var stepSize: Double = 1.0/100
    override var stopTime: Double = 1.0
    override var tolerance: Double = 0.0

}

object CrossCheckOptions {

    fun parse(txt: String): DefaultExperiment {

        return DefaultExperimentImpl().apply {
            txt.trim().split("\n").forEach { line ->

                val split = line.split(",")
                if (split.isNotEmpty()) {
                    val (fst, snd) = split
                    when (fst) {
                        "StartTime" -> startTime = snd.toDouble()
                        "StopTime" -> stopTime = snd.toDouble()
                        "StepSize" -> stepSize = snd.toDouble()
                    }
                }

            }
        }

    }

}
