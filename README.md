## FMU-proxy (work in progress)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/NTNU-IHB/FMU-proxy/issues) 

[![Join the chat at https://gitter.im/NTNU-IHB/FMU-proxy](https://badges.gitter.im/NTNU-IHB/FMU-proxy.svg)](https://gitter.im/NTNU-IHB/FMU-proxy?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![CI](https://github.com/NTNU-IHB/FMU-proxy/workflows/Build/badge.svg)](https://github.com/NTNU-IHB/FMU-proxy/actions)

The main goal of the Functional Mock-up Interface (FMI) standard is to allow simulation models 
to be shared across tools. To accomplish this, FMI relies on a combination of XML-files and compiled 
C-code packaged in a zip archive. This archive is called a Functional Mock-up Unit (FMU) and uses 
the extension .fmu. In theory, an FMU can support multiple platforms, however this is not always 
the case and depends on the type of binaries the exporting tool was able to provide. 
Furthermore, a library providing FMI support may not be available in a particular language or platform, 
and/or it may not support the whole standard. Another issue is related to the protection of 
Intellectual Property (IP). While an FMU is free to only provide the C-code in its binary form, 
other resources shipped with the FMU may be unprotected.   

In order to overcome these challenges, we present an open-source framework for working with 
FMUs across languages and platforms.

FMU-proxy is different from other frameworks for distributed FMU invocations such as 
[DACCOSIM](https://sourcesup.renater.fr/daccosim/), 
[FMI GO!](https://mimmi.math.umu.se/cosimulation/fmigo) and 
[Coral](https://github.com/viproma/coral) in that it completely separates itself from the master algorithm (logically and physically). 
FMU-proxy is a completely standalone project, which provides access to FMUs over the wire. And just that. 

The idea is that other applications should use FMU-proxy whenever FMUs are required to run distributed, 
rather than having each application creating their own solution.

***

### fmu-proxify

fmu-proxify is a CLI that transforms a co-simulation FMU compatible with either version 
FMI 1.0 or 2.0 into a __proxified__ version of the same FMU.
Internally, the proxy FMU wraps the original FMU in a server program. 
Each new instance of the original FMU runs in a separate process.

This allows you to:
* Import FMI 1.0 models in software that otherwise only supports FMI 2.0.
* Instantiate multiple instances of FMUs that only allows one instance per process.
* The ability to run the FMU on some remote resource
    * Which in turn allows FMUs to run on otherwise unsupported platforms.


```
Usage: fmu-proxify [-h] [-d=<destFile>] -f=<fmuFile> [-r=<remoteAddress>]
  -d, --dest=<destFile>   Where to save the FMU (defaults to current folder).
  -f, --file=<fmuFile>    Path to the FMU to proxify.
  -h, --help              Print this message and quits.
  -r, --remote=<remoteAddress>
                          Optional host to connect to. e.g. 127.0.0.1:9090
```

By default, the generated FMU seemingly behaves like a regular FMU. 
However, internally the FMU is communicating with the original FMU over TCP/IP.
When targeting localhost, this all happens automatically.

#### Running the FMU on another computer

1. The target computer needs to start __fmu-proxy.jar__ <br>
`java -jar fmu-proxy.jar <port>`

2. Generate the FMU with the option `--remote <hostname:port>` <br>
 (or modify proxySettings.txt inside an existing FMU)

3. Load the FMU as usual.

### Environment setup

FMU-proxy relies on Java and thus requires a suitable environment to run.

##### Windows
1. JAVA_HOME should point to a JDK8+ installation.
2. %JAVA_HOME%\jre\bin\server must be added to PATH.

##### Linux
On linux things should just work after installing the JDK.  

### Publications

* [Hatledal, Lars Ivar, et al. "FMU-proxy: A Framework for Distributed Access to Functional Mock-up Units." Proceedings of the 13th International Modelica Conference, Regensburg, Germany, March 4–6, 2019. No. 157. Linköping University Electronic Press, 2019.](https://www.ep.liu.se/en/conference-article.aspx?series=ecp&issue=157&Article_No=8)
* [Hatledal, Lars Ivar, et al. "A Language and Platform Independent Co-Simulation Framework Based on the Functional Mock-Up Interface." IEEE Access 7 (2019): 109328-109339.](https://ieeexplore.ieee.org/abstract/document/8788514)


***
> Want to import FMUs in C++? Check out [FMI4cpp](https://github.com/NTNU-IHB/FMI4cpp) <br>
> Want to develop or import FMUs in Java? Check out [FMI4j](https://github.com/NTNU-IHB/FMI4j) <br>
> Want to develop FMUs in Python? Check out [PythonFMU](https://github.com/NTNU-IHB/PythonFMU) <br>
> Need a complete co-simulation framework with SSP support? Check out [Vico](https://github.com/NTNU-IHB/Vico) <br>
