#!/usr/bin/env bash
thrift -r --gen py ../../rpc-definitions/thrift/service.thrift

rm -r definitions
rm -r service

mv gen-py/definitions definitions
mv gen-py/service service

rm -r gen-py