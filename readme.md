## gRPC-FMU

The main goal of the Functional Mock-up Interface (FMI) is to allow simulation models to be shared across tools. 
To accomplish this, FMI relies on a combination of XML-files and compiled C-code packaged in a zip archive. 
This archive is called an Functional Mock-up Unit (FMU) and uses the extension .fmu. 
In theory, an FMU can run on multiple platforms, however, this is not always the case and depends on the 
type of binaries the exporting tool is able to provide. Furthermore, ready made libraries providing 
FMI support may not be available in some languages, and those who are may not support the whole standard. 
Another issue is related to protection of Intellectual Property (IP). 
While an FMU may choose to only provide the C-code in its binary form, resources shipped with 
the FMU may be unprotected.   

In order to overcome these challenges, this paper presents an open-source framework 
for working with functional mock-up units across languages and platforms. 
By analyzing the XML-file located within an FMU, the framework is able to generate 
a Google Protocol Buffer schema (.proto) that defines general FMI functions as well as 
instance specific functions, such as getter and setters for each defined variable. 
From the .proto file, a cross-platform executable is generated. This executable launches 
a gRPC server on some available network port, allowing multiple servers to be hosted 
on a single computer. This port, along with the network address and basic information about the FMU, 
is then transmitted to a web service specified upon launch. The web service acts as a single point 
of entry and provides users with general information about the available FMUs, 
as well as information necessary to connect to one over gRPC. 
As users don't have direct access to the FMU or the resources within it, IP is effectively protected. 