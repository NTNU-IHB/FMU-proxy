package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmuproxy.thrift.internal.InternalFmuService
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.protocol.TProtocol
import org.apache.thrift.transport.TFramedTransport
import org.apache.thrift.transport.TSocket

class FmuClient private constructor(
    protocol: TProtocol
): InternalFmuService.Client(protocol) {

    companion object {

        fun create(port: Int): FmuClient {
            val transport = TFramedTransport.Factory().getTransport(TSocket("localhost", port))
            val protocol = TBinaryProtocol(transport)
            transport.open()
            return FmuClient(protocol)
        }

    }

}
