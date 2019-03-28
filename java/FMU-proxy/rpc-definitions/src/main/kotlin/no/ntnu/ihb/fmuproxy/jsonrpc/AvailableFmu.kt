package no.ntnu.ihb.fmuproxy.jsonrpc

import no.ntnu.ihb.fmi4j.modeldescription.DefaultExperiment


class AvailableFmu (
        val fmuId: String,
        val defaultExperiment: DefaultExperiment?
)