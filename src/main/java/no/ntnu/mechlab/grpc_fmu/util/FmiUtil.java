/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.mechlab.grpc_fmu.util;

/**
 *
 * @author laht
 */
public final class FmiUtil {
    
    private FmiUtil() {
        
    }

    public static String convertName1(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1).replace(".", "_");
    }

    public static String convertName2(String str) {

        String[] split = str.replaceAll("_", ".").split("\\.");
        StringBuilder sb = new StringBuilder();

        for (String s : split) {
            sb.append(s.substring(0, 1).toUpperCase()).append(s.substring(1));
        }
        return sb.toString();

    }

    public static boolean isArray(String name) {
        return name.contains("[");
    }

}
