package no.mechatronics.sfi.grpc_fmu.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener
import no.mechatronics.sfi.grpc_fmu.heartbeating.CentralHeartbeat


class Main: ServletContextListener  {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(Main::class.java)
    }

    override fun contextInitialized(sce: ServletContextEvent?) {
        CentralHeartbeat.start()
        LOG.info("FmuHeartbeat started")
    }

    override fun contextDestroyed(sce: ServletContextEvent?) {
        CentralHeartbeat.stopBlocking()
        LOG.info("FmuHeartbeat stopped")
    }

}