cd ../java/FMU-proxy/
./gradlew :fmu-proxy:run --args="-grpc 9080 -thrift/tcp 9090 -thrift/http 9091 --remote 127.0.0.1:8080 ../../../test/ControlledTemperature.fmu"
