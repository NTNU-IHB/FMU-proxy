#!/usr/bin/env bash

mkdir -p gen

./thrift -r -out gen --gen cpp:no_skeleton ../../rpc-definitions/thrift/service.thrift

sed -i 's/"service_types.h"/<fmuproxy\/thrift\/common\/service_types.h>/' gen/service_types.cpp
sed -i 's/"fmu_service.h"/<fmuproxy\/thrift\/common\/fmu_service.h>/' gen/fmu_service.cpp

sed -i 's/}} \/\/ namespace/typedef fmu_serviceIf fmu_service_if;\ntypedef fmu_serviceClient fmu_service_client;\ntypedef fmu_serviceProcessor fmu_service_processor;\n}} \/\/ namespace/' gen/fmu_service.h

mv gen/service_types.h include/fmuproxy/thrift/common/
mv gen/fmu_service.h include/fmuproxy/thrift/common/

mv gen/service_types.cpp src/fmuproxy/thrift/common/
mv gen/fmu_service.cpp src/fmuproxy/thrift/common/

rm -r gen