
clc, clear;

host = "localhost";
port = 54345;
fmuGuid = "{06c2700b-b39c-4895-9151-304ddde28443}";

modelDescription = request(host, port, "getModelDescription", {fmuGuid});
"ModelName=" + modelDescription.modelName

slaveId = request(host, port, "createInstanceFromCS", {fmuGuid});
request(host, port, "setupExperiment", {slaveId});
request(host, port, "enterInitializationMode", {slaveId})
request(host, port, "exitInitializationMode", {slaveId})

t = 0;
dt = 1.0/100;

while t <= 1.0
    doStep = request(host, port, "doStep", {slaveId, dt});
    t = doStep.simulationTime;
end

request(host, port, "terminate", {slaveId})

