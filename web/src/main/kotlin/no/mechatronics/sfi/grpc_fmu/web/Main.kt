package no.mechatronics.sfi.grpc_fmu.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener


class Main: ServletContextListener  {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(Main::class.java)
    }

    override fun contextInitialized(sce: ServletContextEvent?) {
        Heartbeat.start()
        LOG.info("Heartbeat started")
    }

    override fun contextDestroyed(sce: ServletContextEvent?) {
        Heartbeat.stopBlocking()
        LOG.info("Heartbeat stopped")
    }

}