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

#include <map>
#include "../common/FmuService.h"
#include "../../fmi/Fmu.hpp"

namespace fmuproxy::thrift::server {

    class FmuServiceHandler : virtual public FmuServiceIf {

    private:
        fmi::Fmu& fmu;
        std::map<InstanceId, std::unique_ptr<fmi::FmuInstance>> instances;

    public:
        explicit FmuServiceHandler(fmi::Fmu &fmu);
        
        void getModelDescriptionXml(std::string &_return) override;

        void getModelDescription(ModelDescription &_return) override;

        InstanceId createInstanceFromCS() override;

        InstanceId createInstanceFromME(const Solver &solver) override;
        
        double getSimulationTime(InstanceId instance_id) override;

        bool isTerminated(InstanceId instance_id) override;

        Status::type init(InstanceId instance_id, double start, double stop) override;

        void step(StepResult &_return, InstanceId instance_id, double step_size) override;

        Status::type terminate(InstanceId instance_id) override;

        Status::type reset(InstanceId instance_id) override;
        
        void readInteger(IntegerRead &_return, InstanceId instance_id, const ValueReferences &vr) override;
        
        void readReal(RealRead &_return, InstanceId instance_id, const ValueReferences &vr) override;
        
        void readString(StringRead &_return, InstanceId instance_id, const ValueReferences &vr) override;
        
        void readBoolean(BooleanRead &_return, InstanceId instance_id, const ValueReferences &vr) override;
        
        Status::type writeInteger(InstanceId instance_id, const ValueReferences &vr, const IntArray &value) override;
        
        Status::type writeReal(InstanceId instance_id, const ValueReferences &vr, const RealArray &value) override;

        Status::type writeString(InstanceId instance_id, const ValueReferences &vr, const StringArray &value) override;
        
        Status::type writeBoolean(InstanceId instance_id, const ValueReferences &vr, const BooleanArray &value) override;

    };

}

#endif //FMU_PROXY_FMUSERVICEHANDLER_H
