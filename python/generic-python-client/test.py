
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

    for i in range(0,3):
        status = fmu.step(1.0/100)
        print("Step status={}".format(status))
        print("CurrentTime={}".format(fmu.get_current_time()))

reader = fmu.get_reader("PistonDisplacement")
print("PistonDisplacement={}".format(reader.read_real()))

print("Terminated with success: {}".format(fmu.terminate()))



