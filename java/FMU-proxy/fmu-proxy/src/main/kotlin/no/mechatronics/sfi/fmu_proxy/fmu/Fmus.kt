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

package no.mechatronics.sfi.fmu_proxy.fmu

import no.mechatronics.sfi.fmi4j.fmu.FmiSimulation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicInteger

/**
 * @author Lars Ivar Hatledal
 */
object Fmus {

    private val LOG: Logger = LoggerFactory.getLogger(Fmus::class.java)

    private val idGen = AtomicInteger(0)
    private val fmus = mutableMapOf<Int, FmiSimulation>()

    init {
        Runtime.getRuntime().addShutdownHook(Thread {
            terminateAll()
        })
    }

    fun put(fmu: FmiSimulation): Int {
        return idGen.incrementAndGet().also {
            fmus[it] = fmu
        }
    }

    fun remove(id: Int): FmiSimulation? {
        return fmus.remove(id).also {
            if (it == null) {
                LOG.warn("No fmu with id: $id")
            }
        }
    }

    fun get(id: Int): FmiSimulation? {
        return fmus[id].also {
            if (it == null) {
                LOG.warn("No fmu with id: $id")
            }
        }
    }


    fun terminateAll() {
        fmus.values.forEach {
            if (!it.isTerminated) {
                it.terminate()
            }
        }
    }



}