
from client import GenericFmuClient

client = GenericFmuClient("localhost", 8000)

modelName = client.getModelName()
print(modelName)

fmu = client.createInstance()

init = fmu.init()
print(init)
print(fmu.getCurrentTime())

for i in range(0,3):
    fmu.step(1.0/100)
    print(fmu.getCurrentTime())


fmu.terminate()



