/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology
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

#ifndef FMU_PROXY_FMUSERVICEHANDLER_H
#define FMU_PROXY_FMUSERVICEHANDLER_H

#include <iostream>
#include "../thrift-gen/FmuService.h"
#include "../../fmi/FmuWrapper.hpp"

using namespace fmuproxy::thrift;

namespace fmuproxy::thrift::server {

    class FmuServiceHandler : virtual public FmuServiceIf {

    private:
        fmi::FmuWrapper& fmu;
        std::map<FmuId, std::unique_ptr<fmi::FmuInstance>> fmus;

    public:
        FmuServiceHandler(fmi::FmuWrapper &fmu);

        void getModelDescriptionXml(std::string &_return) override;

        void getModelDescription(ModelDescription &_return) override;

        FmuId createInstanceFromCS() override;

        FmuId createInstanceFromME(const Solver &solver) override;

        bool canGetAndSetFMUstate(const FmuId fmu_id) override;

        double getCurrentTime(const FmuId fmu_id) override;

        bool isTerminated(const FmuId fmu_id) override;

        Status::type init(const FmuId fmu_id, const double start, const double stop) override;

        void step(StepResult &_return, const FmuId fmu_id, const double step_size) override;

        Status::type terminate(const FmuId fmu_id) override;

        Status::type reset(const FmuId fmu_id) override;

        void readInteger(IntegerRead &_return, const FmuId fmu_id, const ValueReference vr) override;

        void bulkReadInteger(BulkIntegerRead &_return, const FmuId fmu_id, const ValueReferences &vr) override;

        void readReal(RealRead &_return, const FmuId fmu_id, const ValueReference vr) override;

        void bulkReadReal(BulkRealRead &_return, const FmuId fmu_id, const ValueReferences &vr) override;

        void readString(StringRead &_return, const FmuId fmu_id, const ValueReference vr) override;

        void bulkReadString(BulkStringRead &_return, const FmuId fmu_id, const ValueReferences &vr) override;

        void readBoolean(BooleanRead &_return, const FmuId fmu_id, const ValueReference vr) override;

        void bulkReadBoolean(BulkBooleanRead &_return, const FmuId fmu_id, const ValueReferences &vr) override;

        Status::type writeInteger(const FmuId fmu_id, const ValueReference vr, const int32_t value) override;

        Status::type bulkWriteInteger(const FmuId fmu_id, const ValueReferences &vr, const IntArray &value) override;

        Status::type writeReal(const FmuId fmu_id, const ValueReference vr, const double value) override;

        Status::type bulkWriteReal(const FmuId fmu_id, const ValueReferences &vr, const RealArray &value) override;

        Status::type writeString(const FmuId fmu_id, const ValueReference vr, const std::string &value) override;

        Status::type bulkWriteString(const FmuId fmu_id, const ValueReferences &vr, const StringArray &value) override;

        Status::type writeBoolean(const FmuId fmu_id, const ValueReference vr, const bool value) override;

        Status::type bulkWriteBoolean(const FmuId fmu_id, const ValueReferences &vr, const BooleanArray &value) override;

    };

}

#endif //FMU_PROXY_FMUSERVICEHANDLER_H
