
import time
from client import GenericFmuClient

client = GenericFmuClient("localhost", 8000)

modelName = client.get_model_name()
print("ModelName={}".format(modelName))

fmu = client.create_instance()

variables = fmu.model_variables
for key in variables:
    v = variables[key]
    if v.causality == 2:
        print(v)

if fmu.init():

    dt = 1.0/100
    start = time.time()
    while fmu.get_current_time() < 10:
        status = fmu.step(dt)
        print("Step status={}".format(status))
        print("CurrentTime={}".format(fmu.get_current_time()))
    end = time.time()

    print("Elapsed={}".format(end-start))

reader = fmu.get_reader("PistonDisplacement")
print("PistonDisplacement={}".format(reader.read_real()))

print("Terminated with success: {}".format(fmu.terminate()))



