package no.mechatronics.sfi.rmu;

import info.laht.yaj_rpc.RpcMethod;
import info.laht.yaj_rpc.RpcService;
import no.mechatronics.sfi.fmi4j.FmiSimulation;
import no.mechatronics.sfi.fmi4j.common.*;
import no.mechatronics.sfi.fmi4j.fmu.FmuBuilder;
import no.mechatronics.sfi.fmi4j.fmu.FmuFile;
import no.mechatronics.sfi.fmi4j.modeldescription.SimpleModelDescription;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class FmuService implements RpcService {

    private static Logger LOG = LoggerFactory.getLogger(FmuService.class);

    private final FmuFile fmuFile;
    private final FmuBuilder builder;
    private final Map<Integer, FmiSimulation> fmus;
    private final SimpleModelDescription modelDescription;
    private final AtomicInteger idGenerator = new AtomicInteger(0);

    public FmuService(@NotNull FmuFile fmuFile) {
        this.fmuFile = fmuFile;
        this.fmus = new HashMap<>();
        this.builder = new FmuBuilder(fmuFile);
        this.modelDescription = fmuFile.getModelDescription();
    }


    @Override
    public @NotNull String getName() {
        return "FmuService";
    }

    protected @NotNull FmuFile getFmuFile() {
        return fmuFile;
    }

    private FmiSimulation getFmu(int id) {
        FmiSimulation fmu = fmus.get(id);
        if (fmu != null) {
            return fmu;
        }
        throw new IllegalArgumentException("No fmu with id=" + id);
    }

    protected void terminateAll() {
        fmus.values().forEach(fmu -> {
            if (!fmu.isTerminated()) {
                fmu.terminate();
            }
        });
    }

    @RpcMethod
    public int createInstanceFromCS() {
        int id = idGenerator.incrementAndGet();
        fmus.put(id, builder.asCoSimulationFmu().newInstance());
        return id;
    }

    @RpcMethod
    public @NotNull String getGuid() {
        return modelDescription.getGuid();
    }

    @RpcMethod
    public @NotNull String getModelName() {
        return modelDescription.getModelName();
    }

    @RpcMethod
    public @NotNull String getModelDescriptionXml() {
        return fmuFile.getModelDescriptionXml();
    }

    @RpcMethod
    public boolean getModelDescription(int fmuId) {
        return getFmu(fmuId).isTerminated();
    }

    @RpcMethod
    public boolean isTerminated(int fmuId) {
        return getFmu(fmuId).isTerminated();
    }

    @RpcMethod
    public double getCurrentTime(int fmuId) {
        return getFmu(fmuId).getCurrentTime();
    }

    @RpcMethod
    public boolean init(int fmuId) {
        return getFmu(fmuId).init();
    }

    @RpcMethod
    public boolean init(int fmuId, double startTime) {
        return getFmu(fmuId).init(startTime);
    }

    @RpcMethod
    public boolean init(int fmuId, double startTime, double stopTime) {
        return getFmu(fmuId).init(startTime, stopTime);
    }
    @RpcMethod
    public boolean step(int fmuId, double stepSize) {
        return getFmu(fmuId).doStep(stepSize);
    }

    @RpcMethod
    public boolean terminate(int fmuId) {
        return getFmu(fmuId).terminate();
    }

    @RpcMethod
    public boolean reset(int fmuId) { return getFmu(fmuId).reset(); }

    @RpcMethod
    public @NotNull FmuIntegerRead readInteger(int fmuId, String name) {
        return getFmu(fmuId).getVariableAccessor().readInteger(name);
    }

    @RpcMethod
    public @NotNull FmuRealRead readReal(int fmuId, String name) {
        return getFmu(fmuId).getVariableAccessor().readReal(name);
    }

    @RpcMethod
    public @NotNull FmuStringRead readString(int fmuId, String name) {
        return getFmu(fmuId).getVariableAccessor().readString(name);
    }

    @RpcMethod
    public @NotNull FmuBooleanRead readBoolean(int fmuId, String name) {
        return getFmu(fmuId).getVariableAccessor().readBoolean(name);
    }

    @RpcMethod
    public @NotNull FmiStatus writeInteger(int fmuId, String name, int value) {
        return getFmu(fmuId).getVariableAccessor().writeInteger(name, value);
    }

    @RpcMethod
    public @NotNull FmiStatus writeReal(int fmuId, String name, double value) {
        return getFmu(fmuId).getVariableAccessor().writeReal(name, value);
    }

    @RpcMethod
    public @NotNull FmiStatus writeString(int fmuId, String name, String value) {
        return getFmu(fmuId).getVariableAccessor().writeString(name, value);
    }

    @RpcMethod
    public @NotNull FmiStatus writeBoolean(int fmuId, String name, boolean value) {
        return getFmu(fmuId).getVariableAccessor().writeBoolean(name, value);
    }

}
