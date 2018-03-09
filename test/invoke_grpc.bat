cd ../java/FMU-proxy/
call gradlew :servergen:installDist 
cd ../../test 
call fmu-proxy -fmu HydraulicCylinderSimple.fmu
PAUSE