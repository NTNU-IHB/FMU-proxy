

    @Override
    public void write{{varName2}} (FmiDefinitions.{{dataType}}Write req, StreamObserver<FmiDefinitions.Status> responseObserver) {

        FmiSimulation fmu = fmus.get(req.getFmuId());
        statusReply(fmu.write("{{varName1}}").with(req.getValue()), responseObserver);

    }