package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.FmiStatus

data class StepResult(
        val simulationTime: Double,
        val status: FmiStatus
) {

    override fun toString(): String {
        return "StepResult(simulationTime=$simulationTime, status=$status)"
    }

}
