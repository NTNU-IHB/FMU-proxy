
## Building

See below for notes on building the project for both Windows and Unix.


Download and install [vcpkg](https://github.com/Microsoft/vcpkg) package system.

Create an environmental variable that points to the installation root named VCPKG_ROOT or pass it in as a option to Cmake (-DCPKG_ROOT=...)

CMake 2.11.x+ is required to build the project.

Installing the required dependecies is as easy as:

```
./vcpkg install boost
./vcpkg install curl
./vcpkg install thrift
./vcpkg install grpc
```

.. except **FMI Library** which requires some manual labour:

**Windows:**

Download the binaries from [here](https://jmodelica.org/) and extract into a suitable location. 
Create a environmental variable named **FMILIB_HOME** pointing to it's content.

NOTE: The _fmilib_shared.dll_ must also be added to the **PATH** system variable. 

**Unix:**

Download the sources from [here]( https://jmodelica.org/) and follow the instructions.
If the library does not get added to the path, you can create an environment variable as for Windows.



