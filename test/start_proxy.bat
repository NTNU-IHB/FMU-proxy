cd ../java/FMU-proxy/
call gradlew :fmu-proxy:run --args="--fmu ../../../test/ControlledTemperature.fmu -grpc 8000 -thrift 8001 -jsonrpc/ws 8002"
PAUSE
