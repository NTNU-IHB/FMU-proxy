package no.ntnu.ihb.fmuproxy.jsonrpc

import no.ntnu.ihb.fmi4j.FmiStatus
import no.ntnu.ihb.fmi4j.modeldescription.RealArray

class DirectionalDerivativeResult (
        val directionalDerivative: RealArray,
        val status: FmiStatus
) {
    override fun toString(): String {
        return "DirectionalDerivativeResult(directionalDerivative=$directionalDerivative, status=$status)"
    }
}
