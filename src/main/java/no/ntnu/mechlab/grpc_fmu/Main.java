/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.mechlab.grpc_fmu;

import java.io.File;
import java.io.IOException;
import org.javafmi.kernel.Files;
import org.javafmi.wrapper.Simulation;

/**
 *
 * @author laht
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String fmuPath = "PumpControlledWinch.fmu";
        Simulation fmu = new Simulation(fmuPath);

        File genFolder = new File("gen");
        if (!genFolder.exists()) {
            Files.createDirectory(genFolder);
        }
        
        try {

            GrpcFmu.ProtoFiles protoFiles = GrpcFmu.generateProto(fmu);
            GrpcFmu.compileProto(protoFiles);
            GrpcFmu.generateServerCode(fmu);

        } finally {
            fmu.terminate();
        }

    }

}
