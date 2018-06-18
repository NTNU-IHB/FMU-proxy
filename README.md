## FMU-proxy

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/SFI-Mechatronics/FMU-proxy/issues)


The main goal of the Functional Mock-up Interface (FMI) standard is to allow simulation models to be shared across tools. To accomplish this, FMI relies on a combination of XML-files and compiled C-code packaged in a zip archive. This archive is called an Functional Mock-up Unit (FMU) and uses the extension .fmu. In theory, an FMU can support multiple platforms, however this is not always the case and depends on the type of binaries the exporting tool was able to provide. Furthermore, a library providing FMI support may not be available in a particular language or platform, and/or it may not support the whole standard. Another issue is related to the protection of Intellectual Property (IP). While an FMU is free to only provide the C-code in its binary form, other resources shipped with the FMU may be unprotected.   

In order to overcome these challenges, this paper presents an open-source framework for working with functional mock-up units across languages and platforms. By wrapping a single FMU inside a server program supporting multiple language independent Remote Procedure Calls (RPCs) and protocols over several network transports. Currently, Apache Thrift (TCP/IP), Apache Avro (TCP/IP), gRPC (HTTP/2) and JSON-RPC (HTTP, WebSockets, TPC/IP, ZMQ) are supported. Together, they allow FMUs to be invoked from virtually any language on any platform.
As users don't have direct access to the FMU or the resources within it, IP is effectively protected. 


### Generating the JVM server from an FMU

```
Usage: fmu-proxy-gen [-h] -fmu=<fmuPath> [-out=<out>]
      -fmu, --fmuPath=<fmuPath>
                              Path to the fmu.
  -h, --help                  Prints this message and quits.
      -out, --output=<out>    Specify where to copy the generated .jar (optional)
```

This will create a self-executable JAR named "myfmu.jar"

```
Usage: fmu-proxy [-h] [-avro=<avroPort>] [-grpc=<grpcPort>]
                 [-jsonrpc/http=<jsonHttpPort>] [-jsonrpc/tcp=<jsonTcpPort>]
                 [-jsonrpc/ws=<jsonWsPort>] [-jsonrpc/zmq=<jsonZmqPort>]
                 [-r=<remote>] [-thrift=<thriftPort>]
  -h, --help                  Print this message and quits.
  -r, --remote=<remote>       Specify an address for the remote tracking server (optional).
      -avro=<avroPort>        Manually specify the Avro port (optional).
      -grpc=<grpcPort>        Manually specify the gRPC port (optional).
      -thrift=<thriftPort>    Manually specify the Thrift port (optional).
      -jsonrpc/http=<jsonHttpPort> Manually specify the JSON-RPC HTTP port(optional).
      -jsonrpc/tcp=<jsonTcpPort> Manually specify the JSON-RPC TCP/IP port (optional).
      -jsonrpc/ws=<jsonWsPort> Manually specify the JSON-RPC WS port (optional).
      -jsonrpc/zmq=<jsonZmqPort> Manually specify the JSON-RPC ZMQ port (optional).
```

You can now connect to the FMU in a language of your choosing using one of the schemas available from the web server or located [here](rpc-definitions). When using JSON-RPC, no schema is required. 

## Software architecture

![Software architecture](http://folk.ntnu.no/laht/files/figures/fmu-proxy.PNG)


