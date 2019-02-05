
## Building

See below for notes on building the project for both Windows and Unix.


Download and install the [vcpkg package system from GitHub](https://github.com/Microsoft/vcpkg).

Then tell CMake about your vcpkg installation by passing <br> ```-DCMAKE_TOOLCHAIN_FILE=<path/to/vcpkg>\scripts\buildsystems\vcpkg.cmake``` to it. 

Using vcpkg, installing the required dependencies is as easy as:

```
./vcpkg install curl thrift grpc boost-program-options boost-ublas boost-odeint
```

On windows you might want to specify the target architecture (defaults to x86) by appending

```bash
--triplet [x86-windows|x64-windows]
```

_Note: `thrift` or `grpc` may be enabled/disabled using the following CMake commands:_
```
-DFMUPROXY_WITH_THRIFT={ON|OFF} #default ON
-DFMUPROXY_WITH_GRPC={ON|OFF} #default ON
```


```fmi4cpp``` is bundled as a git sub-module, so you'll need to ensure that you are also keeping the FMI4cpp sub-folder up-to-date.

If you also want to build the tests, add:

```
./vcpkg install boost-test
```

That's it!

_Note: on linux you are free to use the native package handler if you prefer_ 


