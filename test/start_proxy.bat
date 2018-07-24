cd ../java/FMU-proxy/
call gradlew :fmu-proxy:run --args="--fmu ../../../test/ControlledTemperature.fmu -grpc 9080 -thrift 9090"
PAUSE
