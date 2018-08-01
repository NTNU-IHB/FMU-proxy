
## Building

See below for notes on building the project for both Windows and Unix.


Download and install the vcpkg package system from [GitHub](https://github.com/Microsoft/vcpkg).

Create an environmental variable that points to the vcpkg installation root named _VCPKG_ROOT_ 
or pass it in as a option to CMake (-DVCPKG_ROOT=...)

CMake 3.11.x+ is required to build the project because of Boost 1.67. 
If this is a problem on your Unix system, you can download the cross-platform C++ IDE [CLion](https://www.jetbrains.com/clion/), 
which bundles CMake 3.12..


Using vcpkg, installing the required dependencies is as easy as:

```
./vcpkg install curl thrift grpc boost-atomic boost-system boost-filesystem boost-program-options
```

.. except **FMI Library** which requires some manual labour:

While we wait for a vcpkg package to be officially added, 
unpack [this](http://folk.ntnu.no/laht/files/vcpkg/fmilib-port.zip) archive into _VCPKG_ROOT_/ports.

This will allow you to also install FMI Library using vcpkg:

```
./vcpkg install fmilib
```

That's it!




