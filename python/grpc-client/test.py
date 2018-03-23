
import time
import client

client = client.FmuClient("localhost", 8000)

model_name = client.model_description.model_name
print("ModelName={}".format(model_name))

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
        if status.code != 0:
            print(status.message)
            break
    end = time.time()

    print("Elapsed={}s".format(end-start))

    reader = fmu.get_reader("PistonDisplacement")
    print("PistonDisplacement={}".format(reader.read_real().value))

print("Terminated with success: {}".format(fmu.terminate().code == 0))



