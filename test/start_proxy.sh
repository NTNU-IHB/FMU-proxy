cd ../java/FMU-proxy/
./gradlew :fmu-proxy:run --args="--fmu ../../../test/ControlledTemperature.fmu -grpc 9080 -thrift 9090"
