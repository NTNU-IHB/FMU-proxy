
## Building

See below for notes on building the project for both Windows and Unix.


Download and install the [vcpkg package system from GitHub](https://github.com/Microsoft/vcpkg).

Then tell CMake about your vcpkg installation by passing <br> ```-DCMAKE_TOOLCHAIN_FILE=C:\vcpkg\scripts\buildsystems\vcpkg.cmake``` to it. 

Using vcpkg, installing the required dependencies is as easy as:

```
./vcpkg install fmi4cpp curl thrift grpc boost-program-options
```

If you also want to build the tests, add:

```
./vcpkg install boost-test
```

That's it!




