## FMU-proxy

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/SFI-Mechatronics/FMU-proxy/issues)

The main goal of the Functional Mock-up Interface (FMI) standard is to allow simulation models to be shared across tools. 
To accomplish this, FMI relies on a combination of XML-files and compiled C-code packaged in a zip archive. 
This archive is called an Functional Mock-up Unit (FMU) and uses the extension .fmu. 
In theory, an FMU can support multiple platforms, however this is not always the case and depends on the type of binaries the exporting tool was able to provide. 
Furthermore, a library providing FMI support may not be available in a particular language or platform, and/or it may not support the whole standard. 
Another issue is related to the protection of Intellectual Property (IP). 
While an FMU is free to only provide the C-code in its binary form, other resources shipped with the FMU may be unprotected.   

In order to overcome these challenges, we presents an open-source framework for working with functional mock-up units across languages and platforms. 
This is done by wrapping a single FMU inside a server program supporting multiple language independent Remote Procedure Calls (RPCs) and protocols over several network transports. 
Currently, Apache Thrift (TCP/IP), Apache Avro (TCP/IP), gRPC (HTTP/2) and JSON-RPC (HTTP, WebSockets, TPC/IP, ZMQ) are supported. 
Together, they allow FMUs to be invoked from virtually any language on any platform.
As users don't have direct access to the FMU or the resources within it, IP is effectively protected. 


## Implementation

### JVM

The JVM implementaion of FMU-proxy is written in Kotlin and uses the gradle build system. 

It features a server implementation that supports Apache Thrift, Apache Avro, gRPC and JSON-RPC RPCs.
While the former are only available using one network protocol. The JSON-RPC is available using both HTTP, WebSockets, TCP/IP and ZeroMQ.

For interacting with the FMUs on the JVM, [FMI4j](https://sfi-mechatronics.github.io/FMI4j/) is used. 
The JSON-RPC client and server implementation is found [here].(https://github.com/markaren/YAJ-RPC)

Clients has been implemented for all server end-points. A feature of the implemented clients is that they all implement the same interface. 
The interface is specified by FMI4j, allowing local and remote FMU instances to be used interchangebly in user code. 

[The directory service](#The directory service) is also implemented in Kotlin.  

#### FMU-proxy executable

```
Usage: fmu-proxy [-h] -fmu=<fmuPath> 
                 [-avro=<avroPort>] [-grpc=<grpcPort>]
                 [-jsonrpc/http=<jsonHttpPort>] [-jsonrpc/tcp=<jsonTcpPort>]
                 [-jsonrpc/ws=<jsonWsPort>] [-jsonrpc/zmq=<jsonZmqPort>]
                 [-r=<remote>] [-thrift=<thriftPort>]
  -h, --help                        Print this message and quits.
  -fmu, --fmuPath=<fmuPath>         Path to the fmu.
  -r, --remote=<remote>             Specify an address for the remote tracking server (optional).
      -avro=<avroPort>              Manually specify the Avro port (optional).
      -grpc=<grpcPort>              Manually specify the gRPC port (optional).
      -thrift=<thriftPort>          Manually specify the Thrift port (optional).
      -jsonrpc/http=<jsonHttpPort>  Manually specify the JSON-RPC HTTP port(optional).
      -jsonrpc/tcp=<jsonTcpPort>    Manually specify the JSON-RPC TCP/IP port (optional).
      -jsonrpc/ws=<jsonWsPort>      Manually specify the JSON-RPC WS port (optional).
      -jsonrpc/zmq=<jsonZmqPort>    Manually specify the JSON-RPC ZMQ port (optional).
```

You can now connect to the FMU in a language of your choosing using one of the schemas available from the web server or located [here](rpc-definitions). 
When using JSON-RPC, no schema is required.

### C++

It is no suprise that invoking FMUs on the JVM implies a certain performance overhead. 
That is why a server implementation of FMU-proxy has also been implemented also in C++. 
The drawback is that it only supports Thrift RPC and is only supported on Linux (although it can theoreticlly also run on Windows). 

The implementation uses the C-library [_FMI-Library_](https://jmodelica.org/) for interacting with FMUs. 
An object oriented wrapper is avilable making it easier to work with.

A Thrift client is available. It shares a common interface with the FMI wrapper, making it possible to interchangably use local and remote FMUs in your code. 

### Python

This repository comes with client implementations in Python for gRPC and Thrift.

### Software architecture

![Software architecture](http://folk.ntnu.no/laht/files/figures/fmu-proxy.PNG)

#### The directory service

The directory service is a centralized web service which FMU-proxy servers connects to. 
As there may be many directory services online (each company could have they own), the IP and Port should be provided the FMU-proxy server on startup.
The service has a HTTP API that allows clients to query for available FMUs. 
The response is a JSON array with the necessary information required to connect to the FMUs directly. 

The service also has a web-based GUI, where users can lookup information retreived from the modelDescription.xml found in the available FMUs.

#### Running tests

In order to run the tests, a system variable named __TEST_FMUs__ must be present on your system. This variable should point to the location of the content found [here](https://github.com/markaren/TEST_FMUs).


