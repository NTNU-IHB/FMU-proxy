package no.mechatronics.sfi.fmu_proxy.thrift

import java.io.Closeable
import org.apache.thrift.transport.TSocket
import org.apache.thrift.transport.TTransport
import org.apache.thrift.protocol.TBinaryProtocol

class ThriftFmuClient(
        val host: String,
        val port: Int
): Closeable {

    private val transport: TTransport
    private val client: ThriftFmuService.Client

    init {
        transport = TSocket(host, port)
        transport.open()

        val protocol = TBinaryProtocol(transport)
        client = ThriftFmuService.Client(protocol)

    }

    val modelName: String
        get() = client.modelName

    val guid: String
        get() = client.guid

    override fun close() {
        transport.close();
    }
}