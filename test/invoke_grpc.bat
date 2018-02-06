cd ../java/gRPC-FMU/
call gradlew :servergen:installDist 
cd ../../test 
call grpc-fmu -fmu HydraulicCylinderSimple.fmu
PAUSE