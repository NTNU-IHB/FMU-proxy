cd ../java/FMU-proxy/
call gradlew :fmu-proxy-gen:installDist 
cd ../../test 
call fmu-proxy-gen -fmu ControlledTemperature.fmu
PAUSE