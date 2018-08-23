cd ../java/FMU-proxy/
./gradlew :fmu-proxy:run --args="-grpc 9080 -thrift/tcp 9090 -thrift/http 9091 ../../../test/ControlledTemperature.fmu"
