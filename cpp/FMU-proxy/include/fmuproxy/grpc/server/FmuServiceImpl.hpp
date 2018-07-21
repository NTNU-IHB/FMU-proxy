//
// Created by laht on 21.07.18.
//

#ifndef FMU_PROXY_FMUSERVICEIMPL_HPP
#define FMU_PROXY_FMUSERVICEIMPL_HPP

#include "../common/definitions.pb.h"
#include "../common/service.grpc.pb.h"

#include "../../fmi/Fmu.hpp"

namespace fmuproxy {
    namespace server {
        namespace grpc {

            class FmuServiceImpl : public fmuproxy::grpc::FmuService::Service {

            private:
                fmuproxy::fmi::Fmu &fmu;

            public:

                FmuServiceImpl(fmuproxy::fmi::Fmu &fmu);

                FmuServiceImpl(fmi::Fmu &fmu);

                ::grpc::Status
                GetModelDescriptionXml(::grpc::ServerContext *context, const ::google::protobuf::Empty *request,
                                       ::fmuproxy::grpc::Str *response) override;

            };

        }
    }
}


#endif //FMU_PROXY_FMUSERVICEIMPL_HPP
