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

#include <vector>
#include <unordered_map>

#include <fmi4cpp/fmi2/fmi2.hpp>

#include "fmuproxy/thrift/common/fmu_service.h"

namespace fmuproxy::thrift::server {

    class fmu_service_handler : virtual public fmu_serviceIf {

    private:
        std::unordered_map<FmuId, std::shared_ptr<fmi4cpp::fmi2::fmu>> &fmus_;
        std::unordered_map<InstanceId, std::unique_ptr<fmi4cpp::fmu_slave<fmi4cpp::fmi2::cs_model_description>>> slaves_;

    public:
        explicit fmu_service_handler(std::unordered_map<FmuId, std::shared_ptr<fmi4cpp::fmi2::fmu>> &fmus);

        void load_from_url(FmuId &_return, const std::string &url) override;

        void load_from_file(FmuId &_return, const std::string &name, const std::string &data) override;

        bool can_create_instance_from_cs(const FmuId &fmuId) override;

        bool can_create_instance_from_me(const FmuId &fmuId) override;

        void get_model_description(ModelDescription &_return, const FmuId &fmu_id) override;

        void create_instance_from_cs(InstanceId &_return, const FmuId &fmu_id) override;

        void create_instance_from_me(InstanceId &_return, const FmuId &fmu_id,
                                  const ::fmuproxy::thrift::Solver &solver) override;


        void get_co_simulation_attributes(::fmuproxy::thrift::CoSimulationAttributes &_return,
                                          const InstanceId &instanceId) override;

        Status::type setup_experiment(const InstanceId &instanceId, double start, double stop,
                                     double tolerance) override;

        Status::type enter_initialization_mode(const InstanceId &instanceId) override;

        Status::type exit_initialization_mode(const InstanceId &instanceId) override;

        void step(::fmuproxy::thrift::StepResult &_return, const InstanceId &instance_id,
                  double step_size) override;

        Status::type reset(const InstanceId &instance_id) override;

        Status::type terminate(const InstanceId &instance_id) override;

        void read_integer(::fmuproxy::thrift::IntegerRead &_return, const InstanceId &instance_id,
                         const ValueReferences &vr) override;

        void read_real(::fmuproxy::thrift::RealRead &_return, const InstanceId &instance_id,
                      const ValueReferences &vr) override;

        void read_string(::fmuproxy::thrift::StringRead &_return, const InstanceId &instance_id,
                        const ValueReferences &vr) override;

        void read_boolean(::fmuproxy::thrift::BooleanRead &_return, const InstanceId &instance_id,
                         const ValueReferences &vr) override;

        Status::type write_integer(const InstanceId &instance_id, const ValueReferences &vr,
                                  const IntArray &value) override;

        Status::type write_real(const InstanceId &instance_id, const ValueReferences &vr,
                               const RealArray &value) override;

        Status::type write_string(const InstanceId &instance_id, const ValueReferences &vr,
                                 const StringArray &values) override;

        Status::type write_boolean(const InstanceId &instance_id, const ValueReferences &vr,
                                  const BooleanArray &value) override;

        void get_directional_derivative(DirectionalDerivativeResult &_return, const InstanceId &slave_id,
                                      const ValueReferences &vUnknownRef, const ValueReferences &vKnownRef,
                                      const std::vector<double> &dvKnownRef) override;

    };

}

#endif //FMU_PROXY_FMUSERVICEHANDLER_H
