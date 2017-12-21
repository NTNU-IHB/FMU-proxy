package no.mechatronics.sfi.grpc_fmu.templates

object MainTemplate {

    fun generate(packageName: String, fmuName: String): String {
        return """

package ${packageName};

import java.util.Scanner;
import java.net.ServerSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

class Main {

    public static void main(String args[]) throws IOException, InterruptedException {

        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected remote hostAddress and port");
        }

        String[] split = args[0].split(":");
        if (split.length != 2) {
            throw new IllegalArgumentException("Expected remote hostAddress and port");
        }

        String remoteHostAddress = split[0];
        int remotePort = Integer.parseInt(split[1]);

        int localPort = getAvailablePort();
        String localHostAddress = getHostAddress();

        final ${fmuName}Server server = new ${fmuName}Server();
        server.start(localPort);

        ClientInfo info = new ClientInfo(localHostAddress, localPort, server.getGuid(), server.getModelDescriptionXml());
        Heartbeat beat = new Heartbeat(remoteHostAddress, remotePort, info);
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
"""
    }

}