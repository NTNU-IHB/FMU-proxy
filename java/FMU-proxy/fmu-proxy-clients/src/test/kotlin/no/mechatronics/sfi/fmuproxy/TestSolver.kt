package no.mechatronics.sfi.fmuproxy

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.junit.Assert
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TestSolver {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(TestSolver::class.java)
    }

    @Test
    fun test() {

        val stepSize = 1E-2

        val settings = mapOf("stepSize" to stepSize)

        val solver = mapOf(
                "name" to "Euler",
                "settings" to Gson().toJson(settings)
        )

        GsonBuilder().setPrettyPrinting().create().apply {

            val json = toJson(solver)
            LOG.info(json)
            val solver = fromJson(json, Solver::class.java).also { LOG.info("$solver") }
            Assert.assertEquals(stepSize, solver.getProperty("stepSize", Double::class.java)!!, 0.0)

        }

    }

}