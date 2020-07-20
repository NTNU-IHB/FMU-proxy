package no.ntnu.ihb.fmuproxy.util

import java.io.IOException
import java.io.OutputStream
import javax.swing.JTextArea
import javax.swing.SwingUtilities

class JTextAreaOutputStream(
    private val destination: JTextArea
) : OutputStream() {

    @Throws(IOException::class)
    override fun write(buffer: ByteArray, offset: Int, length: Int) {
        val text = String(buffer, offset, length)
        SwingUtilities.invokeLater { destination.append(text) }
    }

    @Throws(IOException::class)
    override fun write(b: Int) {
        write(byteArrayOf(b.toByte()), 0, 1)
    }

}
