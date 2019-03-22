
## Building

See below for notes on building the project for both Windows and Unix.


#### Using vcpkg

Download and install the [vcpkg package system from GitHub](https://github.com/Microsoft/vcpkg).

Then tell CMake about your vcpkg installation by passing <br> ```-DCMAKE_TOOLCHAIN_FILE=<path/to/vcpkg>\scripts\buildsystems\vcpkg.cmake``` to it. 

Using vcpkg, installing the required dependencies is as easy as:

```
./vcpkg install curl thrift grpc nlohmann-json libzip[core] boost-program-options boost-ublas boost-odeint
```

On windows you might want to specify the target architecture (defaults to x86) by appending

```bash
--triplet [x86-windows|x64-windows]
```

_Note:_
* You don't need to install thrift if you build with `-DFMU_PROXY_WITH_THRIFT=OFF`
* You don't need to install grpc if you build with `-DFMU_PROXY_WITH_GRPC=OFF`


#### Using conan

First, install [conan](https://conan.io/).

Then in order for conan to find `thrift` and `grpc`, you need to add a couple of remotes:

```bash
conan remote add helmesjo "https://api.bintray.com/conan/helmesjo/public-conan"
conan remote add inexorgame "https://api.bintray.com/conan/inexorgame/inexor-conan"
```

Finally, run `conan install`
```bash
conan install . -s build_type=Debug --install-folder=cmake-build-debug -o thrift=False -o grpc=True --build=missing
conan install . -s build_type=Release --install-folder=cmake-build-release -o thrift=True -o grpc=True --build=missing
```

On Linux you should add `-s compiler.libcxx=libstdc++11` to the command.



_Note:_
*  The `thrift` option can be set to `False` if you plan to build with `-DFMU_PROXY_WITH_THRIFT=OFF`
*  The `grpc` option can be set to `False` if you plan to build with `-DFMU_PROXY_WITH_GRPC=OFF`

When using conan, set `FMU_PROXY_USING_CONAN=ON`.

### FMI4cpp

```fmi4cpp``` is bundled as a git sub-module, so you'll need to ensure that you are also keeping the FMI4cpp sub-folder up-to-date.
To initialize the sub-module you can run:
```bash
git submodule update --init --recursive
```
To update it, run:
```bash
git submodule update --recursive
```
### Running tests

If you also want to build the tests, add:

```
./vcpkg install boost-test
```
