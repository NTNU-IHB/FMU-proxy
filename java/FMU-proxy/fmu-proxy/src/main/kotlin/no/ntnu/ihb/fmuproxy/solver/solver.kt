/*
 * The MIT License
 *
 * Copyright 2017-2018. Norwegian University of Technology
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

package no.ntnu.ihb.fmuproxy.solver

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import no.ntnu.ihb.fmi4j.solvers.Solver
import no.ntnu.ihb.fmi4j.solvers.me.ApacheSolvers

private const val STEP_SIZE = "step_size"

private val gson: Gson by lazy {
   GsonBuilder().create()
}

fun parseSolver(name: String, json: String): Solver? {
    return when(name.toLowerCase()) {
        "euler" -> json.parseStepSize()?.let { ApacheSolvers.euler(it) }
        "rk4" -> json.parseStepSize()?.let { ApacheSolvers.rk4(it) }
        "gill" -> json.parseStepSize()?.let { ApacheSolvers.gill(it) }
        "luther" -> json.parseStepSize()?.let { ApacheSolvers.luther(it) }
        else -> null
    }
}

private fun String.parseStepSize(): Double? {
    @Suppress("UNCHECKED_CAST")
    val settings = gson.fromJson(this, Map::class.java) as Map<String, *>

    if (STEP_SIZE !in settings) {
        return null
    }

    return settings[STEP_SIZE] as Double
}
