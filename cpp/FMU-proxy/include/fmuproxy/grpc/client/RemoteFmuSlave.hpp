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

#include <fmi4cpp/fmi2/fmi2.hpp>

#include "../common/service.grpc.pb.h"

namespace fmuproxy::grpc::client {

class RemoteFmuSlave : public fmi4cpp::FmuSlave<fmi4cpp::fmi2::CoSimulationModelDescription> {

    private:
        
        const std::string instanceId_;
        fmuproxy::grpc::FmuService::Stub &stub_;
        std::shared_ptr<fmi4cpp::fmi2::CoSimulationModelDescription> csModelDescription_;

        fmuproxy::grpc::Status lastStatus_;

        bool updateStatusAndReturnTrueOnOK(fmuproxy::grpc::Status status);

    public:
        RemoteFmuSlave(const std::string &instance_id, fmuproxy::grpc::FmuService::Stub &stub,
                       fmi4cpp::fmi2::ModelDescriptionBase &modelDescription);

        fmi4cpp::Status getLastStatus() const override;

        std::shared_ptr<fmi4cpp::fmi2::CoSimulationModelDescription> getModelDescription() const override;

        bool setupExperiment(double startTime = 0, double stopTime = 0, double tolerance = 0) override;

        bool enterInitializationMode() override;

        bool exitInitializationMode() override;

        bool doStep(double stepSize) override;

        bool cancelStep() override;

        bool reset() override;

        bool terminate() override;

        bool readInteger(fmi2ValueReference vr, fmi2Integer &ref) override;

        bool readInteger(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Integer> &ref) override;

        bool readReal(fmi2ValueReference vr, fmi2Real &ref) override;

        bool readReal(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Real> &ref) override;

        bool readString(fmi2ValueReference vr, fmi2String &ref) override;

        bool readString(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2String> &ref) override;

        bool readBoolean(fmi2ValueReference vr, fmi2Boolean &ref) override;

        bool readBoolean(const std::vector<fmi2ValueReference> &vr, std::vector<fmi2Boolean> &ref) override;

        bool writeInteger(fmi2ValueReference vr, fmi2Integer value) override;

        bool writeInteger(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Integer> &values) override;

        bool writeReal(fmi2ValueReference vr, fmi2Real value) override;

        bool writeReal(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Real> &values) override;

        bool writeString(fmi2ValueReference vr, fmi2String value) override;

        bool writeString(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2String> &values) override;

        bool writeBoolean(fmi2ValueReference vr, fmi2Boolean value) override;

        bool writeBoolean(const std::vector<fmi2ValueReference> &vr, const std::vector<fmi2Boolean> &values) override;


        bool getFMUstate(fmi2FMUstate &state) override;

        bool setFMUstate(fmi2FMUstate state) override;

        bool freeFMUstate(fmi2FMUstate &state) override;

        bool serializeFMUstate(const fmi2FMUstate &state, std::vector<fmi2Byte> &serializedState) override;

        bool deSerializeFMUstate(fmi2FMUstate &state, const std::vector<fmi2Byte> &serializedState) override;

        bool getDirectionalDerivative(const std::vector<fmi2ValueReference> &vUnkownRef,
                                      const std::vector<fmi2ValueReference> &vKnownRef,
                                      const std::vector<fmi2Real> &dvKnownRef,
                                      std::vector<fmi2Real> &dvUnknownRef) override;

    };

}

#endif //FMU_PROXY_REMOTEFMUINSTANCE_HPP
