
## Building

See below for notes on building the project for both Windows and Unix.


Download and install the vcpkg package system from [GitHub](https://github.com/Microsoft/vcpkg).

Create an environmental variable that points to the vcpkg installation root named _VCPKG_ROOT_ 
or pass it in as a option to CMake (-DVCPKG_ROOT=...)

Using vcpkg, installing the required dependencies is as easy as:

```
./vcpkg install fmi4cpp curl thrift grpc boost-program-options
```
If thrift gives you an error regarding flex or bison on linux, see this [issue](https://github.com/Microsoft/vcpkg/issues/4042)

If you also want to build the tests, add:

```
./vcpkg install boost-test
```

That's it!




