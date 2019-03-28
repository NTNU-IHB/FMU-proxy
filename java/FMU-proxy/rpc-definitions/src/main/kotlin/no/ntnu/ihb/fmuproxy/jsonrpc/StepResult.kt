package no.ntnu.ihb.fmuproxy.jsonrpc

import no.ntnu.ihb.fmi4j.common.FmiStatus

class StepResult(
        val simulationTime: Double,
        val status: FmiStatus
) {
    fun asPair() = simulationTime to status

    override fun toString(): String {
        return "StepResult(simulationTime=$simulationTime, status=$status)"
    }
}