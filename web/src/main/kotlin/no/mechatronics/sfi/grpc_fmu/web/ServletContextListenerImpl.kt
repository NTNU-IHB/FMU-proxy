package no.mechatronics.sfi.grpc_fmu.web

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener

class ServletContextListenerImpl : ServletContextListener  {

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(ServletContextListenerImpl::class.java)
        private val listeners = ArrayList<() -> Unit>()

        fun onDestroy(action: () -> Unit) = listeners.add(action)

    }

    override fun contextInitialized(sce: ServletContextEvent?) {
       LOG.info("contextInitialized")
    }

    override fun contextDestroyed(sce: ServletContextEvent?) {
        listeners.forEach({it.invoke()})
        listeners.clear()
        LOG.info("contextDestroyed")
    }

}