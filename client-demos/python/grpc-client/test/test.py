
import time
from client import RemoteFmu

if __name__ == '__main__':

    client = RemoteFmu("{06c2700b-b39c-4895-9151-304ddde28443}","localhost", 9080)

    stop = 0.1
    step_size = 1E-4

    slave = client.create_instance()

    variable_name = 'Temperature_Room'
    reader = slave.get_reader(variable_name)

    slave.setup_experiment()
    slave.enter_initialization_mode()
    slave.exit_initialization_mode()

    start = time.time()

    while slave.simulation_time < (stop - step_size):
        status = slave.step(step_size)
        if status != 0:
            print("Error: t={}, FMU returned status {}".format(slave.current_time, status))
        else:
            print("t={}, {}={}".format(slave.simulation_time, variable_name, reader.read_real().values[0]))

    end = time.time()

    print("Elapsed={}s".format(end-start))

    status = slave.terminate()
    print("Terminated with success: {}".format(status == 0))
    slave.freeInstance()
