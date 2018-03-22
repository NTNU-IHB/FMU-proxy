/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology (NTNU)
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

include "definitions.thrift"

namespace java no.mechatronics.sfi.fmu_proxy.thrift

typedef i32 FmuId
typedef i32 ValueReference

service FmuService {

    bool supportsCosimulation()
    bool supportsModelExchange()

    string getModelDescriptionXml()
    definitions.ModelDescription getModelDescription()

    FmuId createInstanceFromCS() throws (1: definitions.UnsupportedOperationException ex)
    FmuId createInstanceFromME(1: definitions.Integrator integrator) throws (1: definitions.UnsupportedOperationException ex)

    bool canGetAndSetFMUstate(1: FmuId fmu_id) throws (1: definitions.NoSuchFmuException ex)

    double getCurrentTime(1: FmuId fmu_id) throws (1: definitions.NoSuchFmuException ex)
    bool isTerminated(1: FmuId fmu_id) throws (1: definitions.NoSuchFmuException ex)

    definitions.StatusCode init(1: FmuId fmu_id, 2: double start, 3: double stop) throws (1: definitions.NoSuchFmuException ex)
    definitions.StatusCode step(1: FmuId fmu_id, 2: double step_size) throws (1: definitions.NoSuchFmuException ex)
    definitions.StatusCode terminate(1: FmuId fmu_id) throws (1: definitions.NoSuchFmuException ex)
    definitions.StatusCode reset(1: FmuId fmu_id) throws (1: definitions.NoSuchFmuException ex)

    definitions.IntRead readInt(1: FmuId fmu_id, 2: ValueReference vr) throws (1: definitions.NoSuchFmuException ex1, 2: definitions.NoSuchVariableException ex2)
    definitions.RealRead readReal(1: FmuId fmu_id, 2: ValueReference vr) throws (1: definitions.NoSuchFmuException ex1, 2: definitions.NoSuchVariableException ex2)
    definitions.StringRead readString(1: FmuId fmu_id, 2: ValueReference vr) throws (1: definitions.NoSuchFmuException ex1, 2: definitions.NoSuchVariableException ex2)
    definitions.BoolRead readBoolen(1: FmuId fmu_id, 2: ValueReference vr) throws (1: definitions.NoSuchFmuException ex1, 2: definitions.NoSuchVariableException ex2)

    definitions.StatusCode writeInt(1: FmuId fmu_id, 2: ValueReference vr, 3: i32 value) throws (1: definitions.NoSuchFmuException ex1, 2: definitions.NoSuchVariableException ex2)
    definitions.StatusCode writeReal(1: FmuId fmu_id, 2: ValueReference vr, 3: double value) throws (1: definitions.NoSuchFmuException ex1, 2: definitions.NoSuchVariableException ex2)
    definitions.StatusCode writeString(1: FmuId fmu_id, 2: ValueReference vr, 3: string value) throws (1: definitions.NoSuchFmuException ex1, 2: definitions.NoSuchVariableException ex2)
    definitions.StatusCode writeBoolen(1: FmuId fmu_id, 2: ValueReference vr, 3: bool value) throws (1: definitions.NoSuchFmuException ex1, 2: definitions.NoSuchVariableException ex2)

}