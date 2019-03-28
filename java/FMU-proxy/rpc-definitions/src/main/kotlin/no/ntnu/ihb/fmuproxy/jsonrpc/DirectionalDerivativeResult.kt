package no.ntnu.ihb.fmuproxy.jsonrpc

import no.ntnu.ihb.fmi4j.common.FmiStatus
import no.ntnu.ihb.fmi4j.modeldescription.RealArray

class DirectionalDerivativeResult (
        val directionalDerivative: RealArray,
        val status: FmiStatus
) {
    override fun toString(): String {
        return "DirectionalDerivativeResult(directionalDerivative=$directionalDerivative, status=$status)"
    }
}