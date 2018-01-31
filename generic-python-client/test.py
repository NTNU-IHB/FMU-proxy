
from client import GenericFmuClient

client = GenericFmuClient("localhost", 8000)

modelName = client.get_model_name()
print(modelName)

fmu = client.create_instance()

variables = fmu.model_variables
for key in variables:
    v = variables[key]
    if v.causality == 1:
        print(v)

if fmu.init():

    for i in range(0,3):
        fmu.step(1.0/100)
        print(fmu.get_current_time())

fmu.terminate()



