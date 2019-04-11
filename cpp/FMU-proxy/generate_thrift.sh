#!/usr/bin/env bash

mkdir -p gen

./thrift -r -out gen --gen cpp:no_skeleton ../../rpc-definitions/thrift/service.thrift


mv gen/FmuService.h gen/fmu_service.h
mv gen/FmuService.cpp gen/fmu_service.cpp

sed -i 's/"service_types.h"/<fmuproxy\/thrift\/common\/service_types.h>/' gen/service_types.cpp
sed -i 's/"FmuService.h"/<fmuproxy\/thrift\/common\/fmu_service.h>/' gen/fmu_service.cpp

sed -i 's/}} \/\/ namespace/typedef FmuServiceIf fmu_service_if;\ntypedef FmuServiceClient fmu_service_client;\ntypedef FmuServiceProcessor fmu_service_processor;\n}} \/\/ namespace/' gen/fmu_service.h

mv gen/service_types.h include/fmuproxy/thrift/common/
mv gen/fmu_service.h include/fmuproxy/thrift/common/

mv gen/service_types.cpp src/fmuproxy/thrift/common/
mv gen/fmu_service.cpp src/fmuproxy/thrift/common/

rm -r gen