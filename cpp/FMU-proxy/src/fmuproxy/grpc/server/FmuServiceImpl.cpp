//
// Created by laht on 21.07.18.
//

#include <fmuproxy/grpc/server/FmuServiceImpl.hpp>

#include <grpcpp/impl/codegen/status.h>
#include <grpcpp/impl/codegen/server_context.h>
#include <google/protobuf/empty.pb.h>

using namespace fmuproxy::grpc;

fmuproxy::server::grpc::FmuServiceImpl::FmuServiceImpl(fmuproxy::fmi::Fmu &fmu) : fmu(fmu) {}

::grpc::Status fmuproxy::server::grpc::FmuServiceImpl::GetModelDescriptionXml(::grpc::ServerContext *context,
                                                                              const ::google::protobuf::Empty *request,
                                                                              ::fmuproxy::grpc::Str *response) {
    response->set_value(fmu.get_model_description_xml());
    return ::grpc::Status::OK;
}
