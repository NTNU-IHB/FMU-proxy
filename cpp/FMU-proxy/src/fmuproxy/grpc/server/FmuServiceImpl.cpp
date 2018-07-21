//
// Created by laht on 21.07.18.
//

#include <fmuproxy/grpc/server/FmuServiceImpl.hpp>


using namespace fmuproxy::grpc::server;

FmuServiceImpl::FmuServiceImpl(fmuproxy::fmi::Fmu &fmu) : fmu(fmu) {}

::grpc::Status FmuServiceImpl::GetModelDescriptionXml(::grpc::ServerContext *context,
                                                                              const ::google::protobuf::Empty *request,
                                                                              ::fmuproxy::grpc::Str *response) {
    response->set_value(fmu.get_model_description_xml());
    return ::grpc::Status::OK;
}
