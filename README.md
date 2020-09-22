## FMU-proxy (work in progress)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat)](https://github.com/NTNU-IHB/FMU-proxy/issues) 

[![Join the chat at https://gitter.im/NTNU-IHB/FMU-proxy](https://badges.gitter.im/NTNU-IHB/FMU-proxy.svg)](https://gitter.im/NTNU-IHB/FMU-proxy?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![CI](https://github.com/NTNU-IHB/FMU-proxy/workflows/Build/badge.svg)](https://github.com/NTNU-IHB/FMU-proxy/actions)

The main goal of the Functional Mock-up Interface (FMI) standard is to allow simulation models to be shared across tools. 
To accomplish this, FMI relies on a combination of XML-files and compiled C-code packaged in a zip archive. 
This archive is called a Functional Mock-up Unit (FMU) and uses the extension .fmu. 
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

FMU-proxy is a framework for accessing FMUs compatible with FMI for Co-simulation and Model Exchange 2.0 in a language and platform independent way. 
This is achieved using well established RPC technologies. 
Due to the technologies involved, clients and servers for FMU-proxy can be written in almost any language, on any platform! 

A server implementation has been realized on the JVM, while client implementations exists for C++, JVM, Python and (browser) JavaScript. 
It's easy to add additional implementations, as the RPC frameworks will generate most of the code for you! 

FMU-proxy is different from other frameworks for distributed FMU invocations such as 
[DACCOSIM](https://sourcesup.renater.fr/daccosim/), 
[FMI GO!](https://mimmi.math.umu.se/cosimulation/fmigo) and 
[Coral](https://github.com/viproma/coral) in that it completely separates itself from the master algorithm (logically and physically). 
FMU-proxy is a completely standalone project which provides access to FMUs over the wire. And just that. 

The idea is that other applications should use FMU-proxy whenever FMUs are required to run distributed, 
rather than having each application creating their own solution.

***

### Publications

* [Hatledal, Lars Ivar, et al. "FMU-proxy: A Framework for Distributed Access to Functional Mock-up Units." Proceedings of the 13th International Modelica Conference, Regensburg, Germany, March 4–6, 2019. No. 157. Linköping University Electronic Press, 2019.](https://www.ep.liu.se/en/conference-article.aspx?series=ecp&issue=157&Article_No=8)
* [Hatledal, Lars Ivar, et al. "A Language and Platform Independent Co-Simulation Framework Based on the Functional Mock-Up Interface." IEEE Access 7 (2019): 109328-109339.](https://ieeexplore.ieee.org/abstract/document/8788514)


***
