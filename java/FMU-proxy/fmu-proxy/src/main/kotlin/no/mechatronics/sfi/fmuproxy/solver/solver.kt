package no.mechatronics.sfi.fmuproxy.solver

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.apache.commons.math3.ode.FirstOrderIntegrator
import org.apache.commons.math3.ode.nonstiff.ClassicalRungeKuttaIntegrator
import org.apache.commons.math3.ode.nonstiff.EulerIntegrator

private const val STEP_SIZE = "step_size"

private val gson: Gson by lazy {
   GsonBuilder().create()
}

fun parseIntegrator(name: String, json: String): FirstOrderIntegrator? {
    return when(name.toLowerCase()) {
        "euler" -> eulerFromJson(json)
        "rk4" -> rk4FromJson(json)
        else -> null
    }
}

private fun eulerFromJson(json: String): EulerIntegrator? {

    @Suppress("UNCHECKED_CAST")
    val settings = Gson().fromJson(json, Map::class.java) as Map<String, *>

    if (STEP_SIZE !in settings) {
        return null
    }

    val stepSize = settings[STEP_SIZE] as Double
    return EulerIntegrator(stepSize)

}

private fun rk4FromJson(json: String): ClassicalRungeKuttaIntegrator? {

    @Suppress("UNCHECKED_CAST")
    val settings = gson.fromJson(json, Map::class.java) as Map<String, *>

    if (STEP_SIZE !in settings) {
        return null
    }

    val stepSize = settings[STEP_SIZE] as Double
    return ClassicalRungeKuttaIntegrator(stepSize)

}