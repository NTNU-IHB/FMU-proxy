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

#ifndef FMU_PROXY_REMOTEFMUINSTANCE_HPP
#define FMU_PROXY_REMOTEFMUINSTANCE_HPP

#include <fmi4cpp/fmi2/fmi4cpp.hpp>

#include "../common/service.grpc.pb.h"

namespace fmuproxy::grpc::client {

    class RemoteFmuSlave : public fmi4cpp::fmi2::FmuSlave {

    private:
        
        const std::string instanceId_;
        fmuproxy::grpc::FmuService::Stub &stub_;
        std::shared_ptr<fmi4cpp::fmi2::CoSimulationModelDescription> csModelDescription;

    public:
        RemoteFmuSlave(const std::string &instance_id, fmuproxy::grpc::FmuService::Stub &stub,
                       fmi4cpp::fmi2::ModelDescriptionBase &modelDescription);

        std::shared_ptr<fmi4cpp::fmi2::CoSimulationModelDescription> getModelDescription() const override;

        void init(double start = 0, double stop = 0) override;

        fmi2Status reset() override;

        fmi2Status terminate() override;

        fmi2Status getFMUstate(fmi2FMUstate &state) override;

        fmi2Status setFMUstate(fmi2FMUstate state) override;

        fmi2Status freeFMUstate(fmi2FMUstate &state) override;

        fmi2Status serializeFMUstate(const fmi2FMUstate &state, std::vector<fmi2Byte> &serializedState) override;

        fmi2Status deSerializeFMUstate(fmi2FMUstate &state, const std::vector<fmi2Byte> &serializedState) override;

        fmi2Status getDirectionalDerivative(const std::vector<fmi2ValueReference> &vUnkownRef,
                                            const std::vector<fmi2ValueReference> &vKnownRef,
                                            const std::vector<fmi2Real> &dvKnownRef,
                                            std::vector<fmi2Real> &dvUnknownRef) const override;

        fmi2Status doStep(double stepSize) override;

        fmi2Status cancelStep() override;

        fmi2Status readInteger(fmi2ValueReference vr, fmi2Integer &ref) const override;

        fmi2Status readInteger(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Integer> &ref) const override;

        fmi2Status readReal(fmi2ValueReference vr, fmi2Real &ref) const override;

        fmi2Status readReal(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Real> &ref) const override;

        fmi2Status readString(fmi2ValueReference vr, fmi2String &ref) const override;

        fmi2Status readString(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2String> &ref) const override;

        fmi2Status readBoolean(fmi2ValueReference vr, fmi2Boolean &ref) const override;

        fmi2Status readBoolean(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Boolean> &ref) const override;

        fmi2Status writeInteger(fmi2ValueReference vr, fmi2Integer value) override;

        fmi2Status
        writeInteger(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Integer> &values) override;

        fmi2Status writeReal(fmi2ValueReference vr, fmi2Real value) override;

        fmi2Status writeReal(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Real> &values) override;

        fmi2Status writeString(fmi2ValueReference vr, fmi2String value) override;

        fmi2Status
        writeString(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2String> &values) override;

        fmi2Status writeBoolean(fmi2ValueReference vr, fmi2Boolean value) override;

        fmi2Status
        writeBoolean(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Boolean> &values) override;

    };

}

#endif //FMU_PROXY_REMOTEFMUINSTANCE_HPP
