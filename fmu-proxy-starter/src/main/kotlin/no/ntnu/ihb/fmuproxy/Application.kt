package no.ntnu.ihb.fmuproxy

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
fun Application.module() {
    routing {
        get("/") {
            /*FmuProxy.main(arrayOf(
                    "-thrift/tcp", "9090"
            ))*/
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
    }
}
