package no.mechatronics.sfi.grpc_fmu.templates


object ClientInfoTemplate {

    fun generate(packageName: String): String {

        return """

package ${packageName};

import java.util.Scanner;
import com.google.gson.GsonBuilder;

public final class ClientInfo {

    private String guid;

    private final int port;
    private final String hostAddress;

    private final String modelDescriptionXml;
    private final String protoDefinition;

    public ClientInfo(String hostAddress, int port, String guid, String modelDescriptionXml) {
        this.port = port;
        this.guid = guid;
        this.hostAddress = hostAddress;
        this.modelDescriptionXml = modelDescriptionXml;

        this.protoDefinition = new Scanner(getClass().getClassLoader()
                .getResourceAsStream("protoDefinition.proto"), "UTF-8").useDelimiter("\\A").next();

    }

    public String getGuid() {
        return guid;
    }

    public String toJson() {

        return new GsonBuilder()
            .create()
            .toJson(this);

    }

}

            """

    }

}