/*
 * The MIT License
 *
 * Copyright 2017-2018 Norwegian University of Technology
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING  FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package no.mechatronics.sfi.grpc_fmu;

import java.util.Scanner;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import no.mechatronics.sfi.grpc_fmu.heartbeating.FmuHeartbeat;
import no.mechatronics.sfi.grpc_fmu.misc.SocketAddress;

class Main {

    public static void main(String args[]) throws IOException, InterruptedException {

        SocketAddress remoteAddress = InputParser.parse(args);
        SocketAddress localAddress = new SocketAddress(getHostAddress(), getAvailablePort());

        final {{fmuName}}Server server = new {{fmuName}}Server();
        server.start(localAddress.getPort());

        RemoteFmu remoteFmu = new RemoteFmu(server.getGuid(), localAddress, server.getModelDescriptionXml());
        FmuHeartbeat beat = new FmuHeartbeat(remoteAddress, remoteFmu);
        beat.start();

        new Thread(() -> {

            System.out.println("Press any key to stop the application..");
            Scanner sc = new Scanner(System.in);
            if (sc.hasNext()) {
                System.out.println("Key pressed, stopping application..");
                server.stop();
                beat.stop();
            }

        }).start();

        server.blockUntilShutdown();

    }

    private static String getHostAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ex) {
            return "127.0.0.1";
        }
    }

    private static int getAvailablePort() throws IOException {

        try (ServerSocket ss = new ServerSocket(0)) {
            return ss.getLocalPort();
        }

    }

}