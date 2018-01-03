/*
 * The MIT License
 *
 * * Copyright 2017-2018 Norwegian University of Technology
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

package no.mechatronics.sfi.grpc_fmu.templates

object ProtoTemplate {

    fun generateWrite(varName: String, typeName: String): String {

        return "rpc Write_${varName} (${typeName}Write) returns (Status) {};"

    }

    fun generateRead(varName: String, typeName: String): String {

        return "rpc Read${varName} (ModelReference) returns (${typeName}) {};"

    }

    fun generateBody(packageName: String, fmuName: String, instanceServices: String): String {

        return """

    syntax = "proto3";

    package ${packageName};

    option java_outer_classname = "${fmuName}Proto";

    service ${fmuName}Service {

        rpc CreateInstance (Empty) returns (ModelReference);

        rpc GetModelName (Empty) returns (Str) {};
        rpc GetModelVariableNames (Empty) returns (StrList) {};
        rpc GetModelVariables (Empty) returns (ScalarVariables) {};

        //instance methods
        rpc GetCurrentTime (ModelReference) returns (Real) {};
        rpc IsTerminated (ModelReference) returns (Bool) {};

        rpc Init (InitRequest) returns (Bool) {};
        rpc Step (StepRequest) returns (Status) {};
        rpc Terminate (TerminateRequest) returns (Empty) {};

        rpc Read (VarRead) returns (Var) {};
        rpc Write (VarWrite) returns (Status) {};

        ${instanceServices}

    }

    message Empty {

    }

    message ModelReference {
        uint32 fmu_id = 1;
    }

    enum Causality {
        INPUT = 0;
        OUTPUT = 1;
        PARAMETER = 2;
        CALCULATED_PARAMETER = 3;
        LOCAL = 4;
        INDEPENDENT = 5;
    }

    enum Variability {
        CONSTANT =  0;
        FIXED = 1;
        CONTINUOUS = 2;
        DISCRETE = 3;
        TUNABLE = 4;
    }

    enum Initial {
        EXACT = 0;
        APPROX = 1;
        CALCULATED = 2;
    }

    message ScalarVariables {
        repeated ScalarVariable values = 1;
    }

    message ScalarVariable {
        string name = 1;
        string description = 2;
        Initial initial = 3;
        Causality causality = 4;
        Variability variability = 5;
        oneof start {
            int32 intValue = 10;
            double realValue = 11;
            string strValue = 12;
            bool boolValue = 13;
        }
    }

    message Status {
        int32 code = 1;
        string value = 2;
    }

    message InitRequest {
        uint32 fmu_id = 1;
        uint32 start = 2;
    }

    message StepRequest {
        uint32 fmu_id = 1;
        double dt = 2;
    }

    message TerminateRequest {
        uint32 fmu_id = 1;
    }

    message Int {
        int32 value = 1;
    }

    message IntWrite {
        uint32 fmu_id = 1;
        string varName = 2;
        int32 value = 3;
    }

    message IntList {
        repeated int32 values = 1;
    }

    message Real {
        double value = 1;
    }

    message RealWrite {
        uint32 fmu_id = 1;
        string varName = 2;
        double value = 3;
    }

    message RealList {
        repeated double values = 1;
    }

    message Str {
        string value = 1;
    }

    message StrWrite {
        uint32 fmu_id = 1;
        string varName = 2;
        string value = 3;
    }

    message StrList {
        repeated string values = 1;
    }

    message Bool {
        bool value = 1;
    }

    message BoolWrite {
        uint32 fmu_id = 1;
        string varName = 2;
        bool value = 3;
    }

    message BoolList {
        repeated bool values = 1;
    }

    message Var {
        oneof value {
            int32 intValue = 1;
            double realValue = 2;
            string strValue = 3;
            bool boolValue = 4;
        }
    }

    message VarRead {
        uint32 fmu_id = 1;
        string varName = 2;
    }

    message VarWrite {
        uint32 fmu_id = 1;
        string varName = 2;
        oneof value {
            int32 intValue = 5;
            double realValue = 6;
            string strValue = 7;
            bool boolValue = 8;
        }
    }


            """

    }


}