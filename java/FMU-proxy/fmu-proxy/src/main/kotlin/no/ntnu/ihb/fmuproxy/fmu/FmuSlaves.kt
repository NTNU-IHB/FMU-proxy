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

package no.ntnu.ihb.fmuproxy.fmu

import no.ntnu.ihb.fmi4j.SlaveInstance
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

/**
 * @author Lars Ivar Hatledal
 */
object FmuSlaves {

    private val LOG: Logger = LoggerFactory.getLogger(FmuSlaves::class.java)

    private val slaves = Collections.synchronizedMap(mutableMapOf<String, SlaveInstance>())

    fun put(slave: SlaveInstance): String {
        return UUID.randomUUID().toString().also {
            synchronized(slaves) {
                slaves[it] = slave
            }
        }
    }

    fun remove(instanceId: String): SlaveInstance? {
        synchronized(slaves) {
            return slaves.remove(instanceId).also {
                if (it == null) {
                    LOG.warn("No slave with id: $instanceId")
                }
            }
        }
    }

    operator fun get(instanceId: String): SlaveInstance? {
        synchronized(slaves) {
            return slaves[instanceId].also {
                if (it == null) {
                    LOG.warn("No slave with id: $instanceId")
                }
            }
        }
    }
    
    fun terminateAll() {
        synchronized(slaves) {
            slaves.values.forEach {
                if (!it.isTerminated) {
                    it.terminate()
                }
            }
            slaves.clear()
        }
    }

}