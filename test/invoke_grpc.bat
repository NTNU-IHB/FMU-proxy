cd ../java/gRPC-FMU/
call gradlew :servergen:installDist 
cd ../../test 
call rmu -fmu HydraulicCylinderSimple.fmu
PAUSE