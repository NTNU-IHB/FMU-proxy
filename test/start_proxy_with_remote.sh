cd ../java/FMU-proxy/
./gradlew :fmu-proxy:run --args="--fmu ../../../test/ControlledTemperature.fmu -grpc 8080 -thrift 9090 --remote 127.0.0.1:8080"
