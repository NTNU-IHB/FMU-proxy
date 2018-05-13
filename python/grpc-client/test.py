
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
    t = fmu.get_current_time()
    while t < 10:
        step = fmu.step(dt)
        t = step.simulation_time
        if step.status != 0:
            print("Error: t={}, FMU returned status {}".format(t, step.status))
            break
    end = time.time()

    print("Elapsed={}s".format(end-start))

    reader = fmu.get_reader("PistonDisplacement")
    print("PistonDisplacement={}".format(reader.read_real().value))

print("Terminated with success: {}".format(fmu.terminate().status == 0))



