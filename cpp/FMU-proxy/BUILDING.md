
## Building

See below for notes on building the project for both Windows and Unix.


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
