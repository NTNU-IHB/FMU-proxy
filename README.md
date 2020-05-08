## FMU-proxy (work in progress)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/NTNU-IHB/FMU-proxy/issues) 

[![Join the chat at https://gitter.im/NTNU-IHB/FMU-proxy](https://badges.gitter.im/NTNU-IHB/FMU-proxy.svg)](https://gitter.im/NTNU-IHB/FMU-proxy?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![](https://jitpack.io/v/NTNU-IHB/FMU-proxy.svg)](https://jitpack.io/#NTNU-IHB/FMU-proxy)


[![CircleCI](https://circleci.com/gh/NTNU-IHB/FMU-proxy.svg?style=svg)](https://circleci.com/gh/NTNU-IHB/FMU-proxy)

The main goal of the Functional Mock-up Interface (FMI) standard is to allow simulation models to be shared across tools. 
To accomplish this, FMI relies on a combination of XML-files and compiled C-code packaged in a zip archive. 
This archive is called an Functional Mock-up Unit (FMU) and uses the extension .fmu. 
In theory, an FMU can support multiple platforms, however this is not always the case and depends on the type of binaries the exporting tool was able to provide. 
Furthermore, a library providing FMI support may not be available in a particular language or platform, and/or it may not support the whole standard. 
Another issue is related to the protection of Intellectual Property (IP). 
While an FMU is free to only provide the C-code in its binary form, other resources shipped with the FMU may be unprotected.   

In order to overcome these challenges, we present an open-source framework for working with functional mock-up units across languages and platforms. 
This is done by wrapping a set of FMUs inside a server program supporting multiple language independent Remote Procedure Calls (RPCs) and protocols over several network transports. 
Currently, Apache Thrift (HTTP, TCP/IP) and gRPC (HTTP/2) are supported. 

Together, they allow FMUs to be invoked from virtually any language on any platform.
As users don't have direct access to the FMU or the resources within it, IP is effectively protected.

***

FMU-proxy is a framework for accessing FMUs compatible with FMI for Co-simulation and Model Exchange 2.0 in a language and platform independent way. This is achieved using well established RPC technologies. Due to the technologies involved, clients and servers for FMU-proxy can be written in almost any language, on any platform! 

[Server](https://github.com/NTNU-IHB/FMU-proxy/wiki/Servers) implementations already exists for C++ and JVM, while [client](https://github.com/NTNU-IHB/FMU-proxy/wiki/Clients) implementations exists for C++, JVM, Python and (browser) JavaScript. And its easy to add additional implementations, as the RPC frameworks will generate most of the code for you! 

FMU-proxy is different from other framework for distributed FMU invocations such as [DACCOSIM](https://sourcesup.renater.fr/daccosim/), [FMI GO!](https://mimmi.math.umu.se/cosimulation/fmigo) and [Coral](https://github.com/viproma/coral) in that it completely separates itself from the master algorithm (logically and physically). FMU-proxy is a completely standalone project which provides access to FMUs over the wire. And just that. 

The idea is that other applications should use FMU-proxy whenever FMUs are required to run distributed, rather than having each application creating their own solution.

***

### Publications

* [Hatledal, Lars Ivar, et al. "FMU-proxy: A Framework for Distributed Access to Functional Mock-up Units." Proceedings of the 13th International Modelica Conference, Regensburg, Germany, March 4–6, 2019. No. 157. Linköping University Electronic Press, 2019.](https://www.ep.liu.se/en/conference-article.aspx?series=ecp&issue=157&Article_No=8)
* [Hatledal, Lars Ivar, et al. "A Language and Platform Independent Co-Simulation Framework Based on the Functional Mock-Up Interface." IEEE Access 7 (2019): 109328-109339.](https://ieeexplore.ieee.org/abstract/document/8788514)

## Implementation


##### Server
This repository comes bundled with **server** implementations written in Kotlin (JVM) and C++. 


##### Client
The available **client** implementations are given in the table below:

|    RPC   	| [JVM](#jvm) 	| [C++](#cpp) 	| [Python](#python) 	| [Javascript](#javascript)
|:--------:	|:---:	|:---:	|:------:	|:------:		|
|   gRPC   	|  x  	|  x  	|    x   	|  			|
|  Thrift/TCP  	|  x  	|  x  	|    x   	|  			|  
|  Thrift/HTTP  |  x  	|   x 	|       	|	x		|


**NOTE:** Thanks to the language independent nature of the RPC technologies and network protocols involved, servers and clients may be implemented in virtually any language with relative ease. 


### <a name="jvm"></a> JVM

The JVM implementation of FMU-proxy is written in Kotlin and uses the gradle build system. 

It features a server implementation that supports Apache Thrift (HTTP/JSON, TCP/IP/binary) and gRPC(HTTP2) RPCs.

For interacting with the FMUs on the JVM, [FMI4j](https://github.com/NTNU-IHB/FMI4j) is used. 

Clients has been implemented for all server end-points. A feature of the implemented clients is that they all implement the same interface. 
The interface is specified by FMI4j, allowing local and remote FMU instances to be used interchangeably in user code. 


#### FMU-proxy executable

```
Usage: fmu-proxy [-h] 
                 [-grpc=<grpcPort>]
                 [-r=<remote>] [-thrift/http=<thriftHttpPort>]
                 [-thrift/tcp=<thriftTcpPort>] FMUs...
      FMUs...             FMU(s) to include.
      -grpc=<grpcPort>    Specify the gRPC port (enables this server).
  -h, --help              Print this message and quits.
      -thrift/http=<thriftHttpPort> Specify the Thrift http port (enables this server).
      -thrift/tcp=<thriftTcpPort> Specify the Thrift tcp port (enables this server).

```

You can now connect to the FMU in a language of your choosing using one of the schemas available from the web server or located [here](rpc-definitions). 

### <a name="cpp"></a> C++

It is no surprise that invoking FMUs on the JVM implies a certain performance overhead. 
That is why a server implementation of FMU-proxy has also been implemented in C++. 

The implementation uses the C++ library [FMI4cpp](https://github.com/NTNU-IHB/FMI4cpp) for interacting with FMUs. 

The implementation supports Thrift and gRPC. Both servers and clients are available. 
The clients share a common interface with the FMI wrapper, making it possible to interchangably use local and remote FMUs in your code.. 

See [BUILDING.md](cpp/FMU-proxy/BUILDING.md) for notes on how to build the project for both Windows and Linux systems.

#### FMU-proxy executable

```
FMU-proxy
Options:
  -h [ --help ]         Print this help message and quits.
  --fmu arg             Path to FMUs.
  --thrift/tcp arg      Specify the Thrift tcp port (enables this server).
  --thrift/http arg     Specify the Thrift http port  (enables this server).
  --grpc arg            Specify gRPC port (enables this server).
```

### <a name="python"></a> Python

This repository comes bundled with simple client implementations in Python for gRPC and Thrift.


### <a name="javascript"></a> JavaScript

A simple Thrift client running in the browser can be found [here](client-demos/browser/thrift/index.html). 


***
