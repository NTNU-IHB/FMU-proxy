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

#include <map>
#include "../common/definitions.pb.h"
#include "../common/service.grpc.pb.h"

#include "../../fmi/Fmu.hpp"

namespace fmuproxy::grpc::server {

    class FmuServiceImpl : public fmuproxy::grpc::FmuService::Service {

    private:
        fmuproxy::fmi::Fmu &fmu_;
        std::map<int, std::unique_ptr<fmi::FmuSlave>> slaves_;

    public:

        explicit FmuServiceImpl(fmuproxy::fmi::Fmu &fmu);

        ::grpc::Status
        GetModelDescriptionXml(::grpc::ServerContext *context, const ::fmuproxy::grpc::Void *request,
                               ::fmuproxy::grpc::Str *response) override;

        ::grpc::Status
        GetModelDescription(::grpc::ServerContext *context, const ::fmuproxy::grpc::Void *request,
                            ::fmuproxy::grpc::ModelDescription *response) override;

        ::grpc::Status
        CreateInstanceFromCS(::grpc::ServerContext *context, const ::fmuproxy::grpc::Void *request,
                             ::fmuproxy::grpc::UInt *response) override;

        ::grpc::Status
        CreateInstanceFromME(::grpc::ServerContext *context, const ::fmuproxy::grpc::Solver *request,
                             ::fmuproxy::grpc::UInt *response) override;

        ::grpc::Status GetSimulationTime(::grpc::ServerContext *context, const ::fmuproxy::grpc::UInt *request,
                                    ::fmuproxy::grpc::Real *response) override;

        ::grpc::Status IsTerminated(::grpc::ServerContext *context, const ::fmuproxy::grpc::UInt *request,
                                  ::fmuproxy::grpc::Bool *response) override;


        ::grpc::Status Init(::grpc::ServerContext *context, const ::fmuproxy::grpc::InitRequest *request,
                          ::fmuproxy::grpc::StatusResponse *response) override;
        ::grpc::Status Step(::grpc::ServerContext *context, const ::fmuproxy::grpc::StepRequest *request,
                          ::fmuproxy::grpc::StepResult *response) override;

        ::grpc::Status Terminate(::grpc::ServerContext *context, const ::fmuproxy::grpc::UInt *request,
                               ::fmuproxy::grpc::StatusResponse *response) override;

        ::grpc::Status Reset(::grpc::ServerContext *context, const ::fmuproxy::grpc::UInt *request,
                           ::fmuproxy::grpc::StatusResponse *response) override;



        ::grpc::Status ReadInteger(::grpc::ServerContext *context, const ::fmuproxy::grpc::ReadRequest *request,
                                 ::fmuproxy::grpc::IntegerRead *response) override;

        ::grpc::Status ReadReal(::grpc::ServerContext *context, const ::fmuproxy::grpc::ReadRequest *request,
                              ::fmuproxy::grpc::RealRead *response) override;

        ::grpc::Status ReadString(::grpc::ServerContext *context, const ::fmuproxy::grpc::ReadRequest *request,
                                ::fmuproxy::grpc::StringRead *response) override;

        ::grpc::Status ReadBoolean(::grpc::ServerContext *context, const ::fmuproxy::grpc::ReadRequest *request,
                                 ::fmuproxy::grpc::BooleanRead *response) override;


        ::grpc::Status
        WriteInteger(::grpc::ServerContext *context, const ::fmuproxy::grpc::WriteIntegerRequest *request,
                     ::fmuproxy::grpc::StatusResponse *response) override;

        ::grpc::Status
        WriteReal(::grpc::ServerContext *context, const ::fmuproxy::grpc::WriteRealRequest *request,
                  ::fmuproxy::grpc::StatusResponse *response) override;

        ::grpc::Status
        WriteString(::grpc::ServerContext *context, const ::fmuproxy::grpc::WriteStringRequest *request,
                    ::fmuproxy::grpc::StatusResponse *response) override;

        ::grpc::Status
        WriteBoolean(::grpc::ServerContext *context, const ::fmuproxy::grpc::WriteBooleanRequest *request,
                     ::fmuproxy::grpc::StatusResponse *response) override;


    };

    }


#endif //FMU_PROXY_FMUSERVICEIMPL_HPP
