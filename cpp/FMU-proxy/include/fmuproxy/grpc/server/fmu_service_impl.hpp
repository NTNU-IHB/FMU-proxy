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

#ifndef FMU_PROXY_FMUSERVICEIMPL_HPP
#define FMU_PROXY_FMUSERVICEIMPL_HPP

#include "../common/service.grpc.pb.h"
#include "../common/service.pb.h"

#include <fmi4cpp/fmi2/fmi2.hpp>

#include <memory>
#include <unordered_map>

namespace fmuproxy::grpc::server
{

class fmu_service_impl : public fmuproxy::grpc::FmuService::Service
{

private:
    std::unordered_map<std::string, std::shared_ptr<fmi4cpp::fmi2::cs_fmu>> fmus_;
    std::unordered_map<std::string, std::unique_ptr<fmi4cpp::fmu_slave<fmi4cpp::fmi2::cs_model_description>>> slaves_;

public:
    explicit fmu_service_impl(std::unordered_map<std::string, std::shared_ptr<fmi4cpp::fmi2::cs_fmu>>& fmus);

    ::grpc::Status
    GetModelDescription(::grpc::ServerContext* context, const ::fmuproxy::grpc::GetModelDescriptionRequest* request,
        ::fmuproxy::grpc::ModelDescription* response) override;

    ::grpc::Status LoadFromUrl(::grpc::ServerContext* context, const ::fmuproxy::grpc::Url* request,
        ::fmuproxy::grpc::FmuId* response) override;

    ::grpc::Status LoadFromFile(::grpc::ServerContext* context, const ::fmuproxy::grpc::File* request,
        ::fmuproxy::grpc::FmuId* response) override;

    ::grpc::Status CreateInstance(::grpc::ServerContext* context, const ::fmuproxy::grpc::CreateInstanceRequest* request,
        ::fmuproxy::grpc::InstanceId* response) override;

    ::grpc::Status
    SetupExperiment(::grpc::ServerContext* context, const ::fmuproxy::grpc::SetupExperimentRequest* request,
        ::fmuproxy::grpc::StatusResponse* response) override;

    ::grpc::Status EnterInitializationMode(::grpc::ServerContext* context,
        const ::fmuproxy::grpc::EnterInitializationModeRequest* request,
        ::fmuproxy::grpc::StatusResponse* response) override;

    ::grpc::Status ExitInitializationMode(::grpc::ServerContext* context,
        const ::fmuproxy::grpc::ExitInitializationModeRequest* request,
        ::fmuproxy::grpc::StatusResponse* response) override;

    ::grpc::Status Step(::grpc::ServerContext* context, const ::fmuproxy::grpc::StepRequest* request,
        ::fmuproxy::grpc::StepResponse* response) override;

    ::grpc::Status Reset(::grpc::ServerContext* context, const ::fmuproxy::grpc::ResetRequest* request,
        ::fmuproxy::grpc::StatusResponse* response) override;

    ::grpc::Status Terminate(::grpc::ServerContext* context, const ::fmuproxy::grpc::TerminateRequest* request,
        ::fmuproxy::grpc::StatusResponse* response) override;

    ::grpc::Status FreeInstance(::grpc::ServerContext* context, const ::fmuproxy::grpc::FreeRequest* request,
        ::fmuproxy::grpc::Void* response) override;


    ::grpc::Status ReadInteger(::grpc::ServerContext* context, const ::fmuproxy::grpc::ReadRequest* request,
        ::fmuproxy::grpc::IntegerRead* response) override;

    ::grpc::Status ReadReal(::grpc::ServerContext* context, const ::fmuproxy::grpc::ReadRequest* request,
        ::fmuproxy::grpc::RealRead* response) override;

    ::grpc::Status ReadString(::grpc::ServerContext* context, const ::fmuproxy::grpc::ReadRequest* request,
        ::fmuproxy::grpc::StringRead* response) override;

    ::grpc::Status ReadBoolean(::grpc::ServerContext* context, const ::fmuproxy::grpc::ReadRequest* request,
        ::fmuproxy::grpc::BooleanRead* response) override;


    ::grpc::Status
    WriteInteger(::grpc::ServerContext* context, const ::fmuproxy::grpc::WriteIntegerRequest* request,
        ::fmuproxy::grpc::StatusResponse* response) override;

    ::grpc::Status
    WriteReal(::grpc::ServerContext* context, const ::fmuproxy::grpc::WriteRealRequest* request,
        ::fmuproxy::grpc::StatusResponse* response) override;

    ::grpc::Status
    WriteString(::grpc::ServerContext* context, const ::fmuproxy::grpc::WriteStringRequest* request,
        ::fmuproxy::grpc::StatusResponse* response) override;

    ::grpc::Status
    WriteBoolean(::grpc::ServerContext* context, const ::fmuproxy::grpc::WriteBooleanRequest* request,
        ::fmuproxy::grpc::StatusResponse* response) override;

    ::grpc::Status
    GetDirectionalDerivative(::grpc::ServerContext* context,
        const ::fmuproxy::grpc::GetDirectionalDerivativeRequest* request,
        ::fmuproxy::grpc::GetDirectionalDerivativeResponse* response) override;
};

} // namespace fmuproxy::grpc::server

#endif //FMU_PROXY_FMUSERVICEIMPL_HPP
