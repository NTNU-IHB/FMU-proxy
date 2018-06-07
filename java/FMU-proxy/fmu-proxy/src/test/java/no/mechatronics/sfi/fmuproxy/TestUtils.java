package no.mechatronics.sfi.fmuproxy;

import org.junit.jupiter.api.condition.OS;

public class TestUtils {

    public static String getTEST_FMUs() {
        String env = System.getenv("TEST_FMUs");
        if (env == null) {
            throw new IllegalStateException("TEST_FMUs not found on PATH!");
        }
        return env;
    }

    public static String getOs() {

        String os;
        if (OS.LINUX.isCurrentOs()) {
            os = "linux64";
        } else if (OS.WINDOWS.isCurrentOs()) {
            os = "win64";
        } else if (OS.MAC.isCurrentOs()) {
            os = "darwin64";
        } else {
            throw new IllegalStateException("Unsupported OS");
        }
        return os;

    }

}
