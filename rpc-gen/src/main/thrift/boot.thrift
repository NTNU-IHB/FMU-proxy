namespace cpp fmuproxy.thrift
namespace java no.ntnu.ihb.fmuproxy.thrift

service BootService {

    i32 loadFromLocalFile(1: string fileName)
    i32 loadFromBinaryData(1: string name, 2: string instanceName, 3: binary data)

}
