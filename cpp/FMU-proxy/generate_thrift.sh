#!/usr/bin/env bash

mkdir -p gen

thrift -r -out gen --gen cpp ../../rpc-definitions/thrift/service.thrift

sed -i 's/"service_types.h"/<fmuproxy\/thrift\/common\/service_types.h>/' gen/service_types.cpp
sed -i 's/"FmuService.h"/<fmuproxy\/thrift\/common\/FmuService.h>/' gen/FmuService.cpp

mv gen/service_types.h include/fmuproxy/thrift/common/
mv gen/FmuService.h include/fmuproxy/thrift/common/

mv gen/service_types.cpp src/fmuproxy/thrift/common/
mv gen/FmuService.cpp src/fmuproxy/thrift/common/

rm -r gen