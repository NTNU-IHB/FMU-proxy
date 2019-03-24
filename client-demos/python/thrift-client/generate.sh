#!/usr/bin/env bash
thrift --gen py ../../../rpc-definitions/thrift/service.thrift

rm -r service
mv gen-py/service service
rm -r gen-py

rm service/constants.py
rm service/fmu_service-remote
echo "__all__ = ['ttypes', 'fmu_service']" > service/__init__.py