
    @Override
    public void read{{varName2}}( FmiDefinitions.ModelReference req, StreamObserver<FmiDefinitions.{{returnType}}> responseObserver) {

        FmiSimulation fmu = fmus.get(req.getFmuId());
        {{primitive1}} read = fmu.read("{{varName1}}").as{{primitive2}}();
        FmiDefinitions.{{returnType}} reply =  FmiDefinitions.{{returnType}}.newBuilder().setValue(read).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }