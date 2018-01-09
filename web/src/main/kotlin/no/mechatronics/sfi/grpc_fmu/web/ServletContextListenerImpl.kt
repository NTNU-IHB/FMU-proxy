package no.mechatronics.sfi.grpc_fmu.web

import no.mechatronics.sfi.grpc_fmu.web.heartbeat.CentralHeartbeat
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener


class ServletContextListenerImpl : ServletContextListener  {

    companion object {
        val LOG: Logger = LoggerFactory.getLogger(ServletContextListenerImpl::class.java)
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