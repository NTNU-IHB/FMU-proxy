#!/usr/bin/env bash
thrift -r --gen py ../../rpc-definitions/thrift/service.thrift
mv gen-py/definitions definitions
mv gen-py/service service
rm -r gen-py