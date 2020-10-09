package no.ntnu.ihb.fmuproxy

import no.ntnu.ihb.fmuproxy.misc.RemoteAddress
import no.ntnu.ihb.fmuproxy.misc.parseSettings
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class TestParseSettings {

    private val fmuName = "identity.fmu"
    private val remote = RemoteAddress("localhost", 9090)

    private val testStrings by lazy {
        val str1 = """
            fmu=identity.fmu
            remote=${remote.strRepr}
        """.trimIndent()

        val str2 = """
            remote=${remote.strRepr}
            fmu=identity.fmu
        """.trimIndent()

        listOf(str1, str2)
    }

    @Test
    fun testParseSettings() {

        val str1 = """
            fmu=identity.fmu
            remote=${remote.strRepr}
        """.trimIndent()

        parseSettings(str1).also {
            Assertions.assertEquals(fmuName, it.fmuName)
            Assertions.assertEquals(remote, it.remote)
        }

        val str2 = """
            remote=${remote.strRepr}
            fmu=identity.fmu
        """.trimIndent()

        parseSettings(str2).also {
            Assertions.assertEquals(fmuName, it.fmuName)
            Assertions.assertEquals(remote, it.remote)
        }

        val str3 = """
            fmu=identity.fmu
        """.trimIndent()

        parseSettings(str3).also {
            Assertions.assertEquals(fmuName, it.fmuName)
            Assertions.assertNull(it.remote)
        }

    }

}
