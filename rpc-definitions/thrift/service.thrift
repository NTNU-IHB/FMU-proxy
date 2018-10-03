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

namespace cpp fmuproxy.thrift
namespace java no.mechatronics.sfi.fmuproxy.thrift

typedef string FmuId
typedef string InstanceId
typedef i64 ValueReference
typedef i64 FmuState
typedef list<ValueReference> ValueReferences
typedef list<i32> IntArray
typedef list<double> RealArray
typedef list<string> StringArray
typedef list<bool> BooleanArray

exception NoSuchFmuException {
    1: string message
}

exception NoSuchInstanceException {
    1: string message
}

exception NoSuchVariableException {
    1: string message
}

exception UnsupportedOperationException {
    1: string message
}

struct GetFmuStateResult {
    1: FmuState state
    2: definitions.Status status;
}

struct SerializeFmuStateResult {
    1: binary state
    2: definitions.Status status
}

struct DeSerializeFmuStateResult {
    1: FmuState state
    2: definitions.Status status
}

service FmuService {


    definitions.ModelDescription getModelDescription(1: FmuId fmu_id) throws (1: NoSuchFmuException ex)
    definitions.CoSimulationModelDescription getCoSimulationModelDescription(1: InstanceId instance_id) throws (1: NoSuchInstanceException ex)

    bool canCreateInstanceFromCS(1: FmuId fmu_id) throws (1: NoSuchFmuException ex)
    bool canCreateInstanceFromME(1: FmuId fmu_id) throws (1: NoSuchFmuException ex)

    InstanceId createInstanceFromCS(1: FmuId fmu_id) throws (1: UnsupportedOperationException ex1, 2: NoSuchFmuException ex2)
    InstanceId createInstanceFromME(1: FmuId fmu_id, 2: definitions.Solver solver) throws (1: UnsupportedOperationException ex1, 2: NoSuchFmuException ex2)

    definitions.Status init(1: InstanceId instance_id, 2: double start, 3: double stop) throws (1: NoSuchInstanceException ex)
    definitions.StepResult step(1: InstanceId instance_id, 2: double step_size) throws (1: NoSuchInstanceException ex)
    definitions.Status reset(1: InstanceId instance_id) throws (1: NoSuchInstanceException ex)
    definitions.Status terminate(1: InstanceId instance_id) throws (1: NoSuchInstanceException ex)

    definitions.IntegerRead readInteger(1: InstanceId instance_id, 2: ValueReferences vr) throws (1: NoSuchInstanceException ex1, 2: NoSuchVariableException ex2)
    definitions.RealRead readReal(1: InstanceId instance_id, 2: ValueReferences vr) throws (1: NoSuchInstanceException ex1, 2: NoSuchVariableException ex2)
    definitions.StringRead readString(1: InstanceId instance_id, 2: ValueReferences vr) throws (1: NoSuchInstanceException ex1, 2: NoSuchVariableException ex2)
    definitions.BooleanRead readBoolean(1: InstanceId instance_id, 2: ValueReferences vr) throws (1: NoSuchInstanceException ex1, 2: NoSuchVariableException ex2)

    definitions.Status writeInteger(1: InstanceId instance_id, 2: ValueReferences vr, 3: IntArray value) throws (1: NoSuchInstanceException ex1, 2: NoSuchVariableException ex2)
    definitions.Status writeReal(1: InstanceId instance_id, 2: ValueReferences vr, 3: RealArray value) throws (1: NoSuchInstanceException ex1, 2: NoSuchVariableException ex2)
    definitions.Status writeString(1: InstanceId instance_id, 2: ValueReferences vr, 3: StringArray value) throws (1: NoSuchInstanceException ex1, 2: NoSuchVariableException ex2)
    definitions.Status writeBoolean(1: InstanceId instance_id, 2: ValueReferences vr, 3: BooleanArray value) throws (1: NoSuchInstanceException ex1, 2: NoSuchVariableException ex2)

    GetFmuStateResult getFMUstate(1: InstanceId instance_id) throws (1: NoSuchInstanceException ex1, 2: UnsupportedOperationException ex2)
    definitions.Status setFMUstate(1: InstanceId instance_id, 2: FmuState state) throws (1: NoSuchInstanceException ex1, 2: UnsupportedOperationException ex2)
    definitions.Status freeFMUstate(1: InstanceId instance_id, 2: FmuState state) throws (1: NoSuchInstanceException ex1, 2: UnsupportedOperationException ex2)

    SerializeFmuStateResult serializeFMUstate(1: InstanceId instance_id, 2: FmuState state) throws (1: NoSuchInstanceException ex1, 2: UnsupportedOperationException ex2)
    DeSerializeFmuStateResult deSerializeFMUstate(1: InstanceId instance_id, 2: binary state) throws (1: NoSuchInstanceException ex1, 2: UnsupportedOperationException ex2)

}
