cd ..
./gradlew :fmu-proxy-server:run --args="-tcp 9090 -http 9091 test/fmus/2.0/cs/20sim/4.6.4.8004/ControlledTemperature/ControlledTemperature.fmu"
