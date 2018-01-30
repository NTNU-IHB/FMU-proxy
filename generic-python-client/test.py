
from client import GenericFmuClient

client = GenericFmuClient("localhost", 8000)

modelName = client.get_model_name()
print(modelName)

fmu = client.create_instance()

variables = fmu.get_model_variables()
for v in variables:
    print(v)

init = fmu.init()
print(init)
print(fmu.get_current_time())

for i in range(0,3):
    fmu.step(1.0/100)
    print(fmu.get_current_time())


fmu.terminate()



