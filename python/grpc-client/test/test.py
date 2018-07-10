
import time
from client import RemoteFmu

if __name__ == '__main__':

    client = RemoteFmu("localhost", 9090)

    step_size = 1.0/100
    stop = 10

    instance = client.create_instance()

    variable_name = 'Temperature_Room'
    reader = instance.get_reader(variable_name)

    status = instance.init()

    if status == 0:

        start = time.time()

        while instance.current_time < stop-step_size:
            status = instance.step(step_size)
            if status != 0:
                print("Error: t={}, FMU returned status {}".format(instance.current_time, status))
                break
            print("t={}, {}={}".format(instance.current_time, variable_name, reader.read_real().value))

        end = time.time()

        print("Elapsed={}s".format(end-start))

    status = instance.terminate()
    print("Terminated with success: {}".format(status))



