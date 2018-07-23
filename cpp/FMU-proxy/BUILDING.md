
### Windows

Download and install [vcpkg](https://github.com/Microsoft/vcpkg)

Create an environmental variable that points to the installation root named VCPKG_ROOT or pass it in as a option to Cmake (-DCPKG_ROOT=...)

**Boost:**
```
./vcpkg install boost
```
**Curl:**
```
./vcpkg install curl
``` 
**Thrift:**
```
./vcpkg install thrift
```
**gRPC:**
```
./vcpkg install grpc
```

**FMI Library**

Download the binaries from [here](https://jmodelica.org/) and extract into a suitable location. 
Create a environmental variable named FMILIB_HOME pointing to it's content.

NOTE: The _fmilib_shared.dll_ must also be added to the **PATH** system variable. 


### UNIX


**Boost:**
```
sudo apt-get install libboost-all-dev
```
**Curl:**
```
sudo apt-get install libcurl4-openssl-dev
```
**gRPC:**

Download the sources [GitHub](https://github.com/grpc/grpc) and follow the instructions there. 

Finalize the build by a ```sudo make install```. 

Do the same for the /thirdparty/protobuf folder. If the version is < 3.6 you will need to checkout a newer branch before you build.

**Thrift:**

Download the sources from [here](https://thrift.apache.org/download) and unpack.
From the root do:
```
./configure --with-java=false --with-python=false
make
sudo make install
``` 

**FMI Library**

Download the sources from [here]( https://jmodelica.org/) and follow the instructions.
If the library does not get added to the path, you can create an environment variable as for Windows.

