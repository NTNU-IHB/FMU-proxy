package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmi4j.util.extractContentTo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileInputStream
import java.net.URLClassLoader

internal class TestClassLoader {

    @Test
    fun testClassloader() {

        val fmuToProxify = File("../test/fmus/1.0/identity.fmu")
        Assertions.assertTrue(fmuToProxify.exists())

        val proxyFmu = FmuProxifier(fmuToProxify).build()
        Assertions.assertTrue(proxyFmu.exists())

        FileInputStream(proxyFmu).use { fis ->
            fis.extractContentTo(File("build/test"))
        }
        val modelJar = File("build/test/resources/model.jar").toURI().toURL()
        val cls = URLClassLoader(arrayOf(modelJar)).loadClass("no.ntnu.ihb.fmuproxy.FmuWrapper")

        Assertions.assertEquals("FmuWrapper", cls.simpleName)

    }

}
