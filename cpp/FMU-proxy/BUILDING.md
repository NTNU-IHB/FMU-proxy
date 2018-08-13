
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
./vcpkg install fmilib curl thrift grpc boost-atomic boost-system boost-filesystem boost-program-options
```
If thrift gives you an error regarding flex or bison on linux, see this [issue](https://github.com/Microsoft/vcpkg/issues/4042)

If you also want to build the tests, add:

```./vcpkg install boost-test
```

That's it!




