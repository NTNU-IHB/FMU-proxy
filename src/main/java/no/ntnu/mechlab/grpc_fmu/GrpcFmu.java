/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.mechlab.grpc_fmu;

import no.ntnu.mechlab.grpc_fmu.util.FmiUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FilenameUtils;
import org.javafmi.modeldescription.ScalarVariable;
import org.javafmi.wrapper.Simulation;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;

/**
 *
 * @author laht
 */
public final class GrpcFmu {

    public static final String PACKAGE_NAME = "no.ntnu.mechlab.grpc_fmu";
    public static final String OUTPUT_FOLDER = "gen";

    static File generateServerCode(Simulation fmu) throws IOException {

        String fmuName = fmu.getModelDescription().getModelName();
        String className = fmuName + "Server";

        StringBuilder sb = new StringBuilder().append("\n");

        for (ScalarVariable var : fmu.getModelDescription().getModelVariables()) {
            String varName = var.getName();
            String typeName = var.getTypeName();
            if (!FmiUtil.isArray(varName)) {

                JtwigTemplate readTemplate = JtwigTemplate.classpathTemplate("templates/serverread.twig");
                sb.append(readTemplate.render(JtwigModel.newModel()
                        .with("varName1", varName)
                        .with("varName2", FmiUtil.convertName2(varName))
                        .with("primitive1", toRPCType2(typeName))
                        .with("primitive2", toRPCType3(typeName))
                        .with("returnType", toRPCType1(typeName)))).append("\n");

                JtwigTemplate writeTemplate = JtwigTemplate.classpathTemplate("templates/serverwrite.twig");
                sb.append(writeTemplate.render(JtwigModel.newModel()
                        .with("varName1", varName)
                        .with("varName2", FmiUtil.convertName2(varName))
                        .with("dataType", toRPCType1(typeName)))).append("\n");

            }

        }

        JtwigTemplate protoTemplate = JtwigTemplate.classpathTemplate("templates/server.twig");
        JtwigModel model = JtwigModel.newModel()
                .with("packageName", GrpcFmu.PACKAGE_NAME)
                .with("className", className)
                .with("fmuName", fmuName)
                .with("dynamicMethods", sb.toString());

        String folder = GrpcFmu.OUTPUT_FOLDER + File.separator + GrpcFmu.PACKAGE_NAME.replace(".", "\\");
        File file = new File(folder + File.separator + className + ".java");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            protoTemplate.render(model, fos);
        }
        return file;

    }

    static ProtoFiles generateProto(Simulation fmu) throws IOException {

        String fmuName = fmu.getModelDescription().getModelName();
        StringBuilder rpcBuilder = new StringBuilder();

        for (ScalarVariable var : fmu.getModelDescription().getModelVariables()) {
            String varName = var.getName();
            String typeName = var.getTypeName();
            if (!FmiUtil.isArray(varName)) {

                JtwigTemplate readTemplate = JtwigTemplate.classpathTemplate("templates/rpcread.twig");
                rpcBuilder.append(readTemplate.render(JtwigModel.newModel()
                        .with("varName", FmiUtil.convertName1(var.getName()))
                        .with("typeName", typeName)));

                JtwigTemplate writeTemplate = JtwigTemplate.classpathTemplate("templates/rpcwrite.twig");
                rpcBuilder.append(writeTemplate.render(JtwigModel.newModel()
                        .with("varName", FmiUtil.convertName1(var.getName()))
                        .with("typeName", typeName)));

            }
        }
        JtwigTemplate generalProtoTemplate = JtwigTemplate.classpathTemplate("templates/fmugeneralproto.twig");
        File generalProtoFile = new File(GrpcFmu.OUTPUT_FOLDER + File.separator + fmuName + ".proto");
        try (FileOutputStream fos = new FileOutputStream(generalProtoFile)) {
            generalProtoTemplate.render(JtwigModel.newModel()
                    .with("packageName", GrpcFmu.PACKAGE_NAME)
                    .with("fmuName", fmuName)
                    .with("services", rpcBuilder.toString()), fos);
        }

//        JtwigTemplate instanceProtoTemplate = JtwigTemplate.classpathTemplate("templates/fmuinstanceproto.twig");
//        File instanceProtoFile = new File(GrpcFmu.OUTPUT_FOLDER + File.separator + fmuName + ".proto");
//        try (FileOutputStream fos = new FileOutputStream(instanceProtoFile)) {
//            instanceProtoTemplate.render(JtwigModel.newModel()
//                    .with("packageName", GrpcFmu.PACKAGE_NAME)
//                    .with("fmuName", fmuName)
//                    .with("services", rpcBuilder.toString()), fos);
//        }
        return new ProtoFiles(generalProtoFile, null);

    }

    static void compileProto(ProtoFiles files) throws IOException {

        File file = files.generalFile;
        String baseName = FilenameUtils.getBaseName(file.getAbsolutePath());

        {
            String line1 = "protoc --java_out=\"" + GrpcFmu.OUTPUT_FOLDER + File.separator
                    + "\" " + "--proto_path=\"." + "\" \"" + GrpcFmu.OUTPUT_FOLDER + File.separator + baseName + ".proto\"";
            CommandLine commandLine = CommandLine.parse(line1);
            DefaultExecutor executor = new DefaultExecutor();
            executor.setWorkingDirectory(new File("").getAbsoluteFile());

            executor.execute(commandLine);
        }

        {
            String line1 = "protoc --grpc-java_out=\"" + GrpcFmu.OUTPUT_FOLDER + File.separator
                    + "\" " + "--proto_path=\"." + "\" \"" + GrpcFmu.OUTPUT_FOLDER + File.separator + baseName + ".proto\"";
            CommandLine commandLine = CommandLine.parse(line1);
            DefaultExecutor executor = new DefaultExecutor();
            executor.setWorkingDirectory(new File("").getAbsoluteFile());

            executor.execute(commandLine);
        }

    }

    static String toRPCType1(String typeName) {

        switch (typeName) {
            case "Integer":
                return "Int";
            case "Real":
                return "Real";
            case "String":
                return "Str";
            case "Boolean":
                return "Bool";
        }

        throw new RuntimeException();

    }

    static String toRPCType2(String typeName) {

        switch (typeName) {
            case "Integer":
                return "int";
            case "Real":
                return "double";
            case "String":
                return "String";
            case "Boolean":
                return "bool";
        }

        throw new RuntimeException();

    }

    static String toRPCType3(String typeName) {

        switch (typeName) {
            case "Integer":
                return "Integer";
            case "Real":
                return "Double";
            case "String":
                return "String";
            case "Boolean":
                return "bool";
        }

        throw new RuntimeException();

    }

    static class ProtoFiles {

        public final File generalFile;
        public final File instanceFile;

        public ProtoFiles(File generalFile, File instanceFile) {
            this.generalFile = generalFile;
            this.instanceFile = instanceFile;
        }

    }

}
