import time
from definitions.ttypes import *
from client import RemoteFmu

if __name__ == '__main__':

    client = RemoteFmu("localhost", 9090)

    step_size = 1E-2
    stop = 10

    instance = client.create_instance()

    variable_name = 'Temperature_Room'
    reader = instance.get_reader(variable_name)

    status = instance.init()

    if status == Status.OK_STATUS:

        start = time.time()

        while instance.simulation_time < (stop-step_size):
            status = instance.step(step_size)
            if status != 0:
                print("Error: t={}, FMU returned status {}".format(instance.simulation_time, status))
                break
            print("t={}, {}={}".format(instance.simulation_time, variable_name, reader.read_real().value[0]))

        end = time.time()

        print("Elapsed={}s".format(end - start))

    status = instance.terminate()
    print("FMU '{}' terminated with status: {}".format(client.model_description.modelName, Status._VALUES_TO_NAMES[status]))