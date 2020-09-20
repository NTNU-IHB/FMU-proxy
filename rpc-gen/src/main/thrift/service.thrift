namespace cpp fmuproxy.thrift
namespace java no.ntnu.ihb.fmuproxy.thrift

include "defs.thrift"

exception NoSuchFileException {
    1: string message
}

service FmuService {

    i32 load_from_url(1: string url)
    i32 load_from_local_file(1: string fileName) throws (1: NoSuchFileException ex)
    i32 load_from_remote_file(1: string name, 2: binary data)

}
