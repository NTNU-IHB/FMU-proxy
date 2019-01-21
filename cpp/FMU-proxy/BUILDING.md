
## Building

See below for notes on building the project for both Windows and Unix.


Download and install the [vcpkg package system from GitHub](https://github.com/Microsoft/vcpkg).

Then tell CMake about your vcpkg installation by passing <br> ```-DCMAKE_TOOLCHAIN_FILE=C:\vcpkg\scripts\buildsystems\vcpkg.cmake``` to it. 

Using vcpkg, installing the required dependencies is as easy as:

```
./vcpkg install curl thrift grpc boost-program-options
```

```fmi4cpp``` is bundled as a git sub-module, so you'll need to ensure that you are also keeping the FMI4cpp sub-folder up-to-date.

If you also want to build the tests, add:

```
./vcpkg install boost-test
```

That's it!
