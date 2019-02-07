cd ../java/FMU-proxy/
call gradlew :fmu-proxy:run --args="-grpc 9080 -thrift/tcp 9090 -thrift/http 9091 ../../../test/fmus/2.0/cs/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"
PAUSE
