thrift --gen py ../../../rpc-definitions/thrift/service.thrift
rmdir /Q /S service
move gen-py/service service
rmdir /Q /S gen-py
del "constants.py" /Q /S
@echo __all__ = ['ttypes', 'FmuService'] > service/__init__.py
