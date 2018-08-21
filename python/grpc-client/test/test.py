
import time
from client import RemoteFmu

if __name__ == '__main__':

    client = RemoteFmu("{06c2700b-b39c-4895-9151-304ddde28443}","localhost", 9080)

    stop = 10
    step_size = 1.0 / 100

    instance = client.create_instance()

    variable_name = 'Temperature_Room'
    reader = instance.get_reader(variable_name)

    status = instance.init()

    if status == 0:

        start = time.time()

        while instance.simulation_time < (stop-step_size):
            status = instance.step(step_size)
            if status != 0:
                print("Error: t={}, FMU returned status {}".format(instance.current_time, status))
            else:
                print("t={}, {}={}".format(instance.simulation_time, variable_name, reader.read_real().values[0]))

        end = time.time()

        print("Elapsed={}s".format(end-start))

    status = instance.terminate()
    print("Terminated with success: {}".format(status))

