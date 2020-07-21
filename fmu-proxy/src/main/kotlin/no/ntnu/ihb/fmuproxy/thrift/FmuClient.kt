package no.ntnu.ihb.fmuproxy.thrift

import no.ntnu.ihb.fmuproxy.thrift.internal.InternalFmuService
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.protocol.TProtocol
import org.apache.thrift.transport.TFramedTransport
import org.apache.thrift.transport.TSocket
import org.apache.thrift.transport.TTransport
import java.io.Closeable

class FmuClient private constructor(
    private val transport: TTransport,
    protocol: TProtocol
): InternalFmuService.Client(protocol), Closeable {

    init {
        transport.open()
    }

    override fun close() {
        if (transport.isOpen) {
            shutdown()
            transport.close()
        }
    }

    companion object {

        fun create(port: Int): FmuClient {
            val transport = TFramedTransport.Factory().getTransport(TSocket("localhost", port))
            val protocol = TBinaryProtocol(transport)
            return FmuClient(transport, protocol)
        }

    }

}
