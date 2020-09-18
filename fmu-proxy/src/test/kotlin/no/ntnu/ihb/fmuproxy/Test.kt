package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmuproxy.thrift.ThriftFmuClient
import org.junit.jupiter.api.Assertions
import java.time.Duration


fun main() {

    Assertions.assertTimeout(Duration.ofSeconds(10)) {

        ThriftFmuClient.socketClient("localhost", 9090).load("ae713a03-634c-5da4-802e-9ea653e11f42")
            .use { client ->

                val md = client.modelDescription
                println(md.modelName)

                client.newInstance().use { instance ->

                    runSlave(instance, 1e-2, 5.0).also {
                        println("Thrift (socket) duration: ${it}ms")
                    }

                }

            }
    }

}


