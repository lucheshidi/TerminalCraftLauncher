package org.lucheshidi.tcl.util;

public class SystemPlatform {
    public static String getPlatformName() {
        // 获取系统名称
        String osName = System.getProperty("os.name");
        // 判断
        if (osName.contains("win")) {
            return "windows";
        }
        else if (osName.contains("mac")) {
            return "mac";
        }
        else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            return "unix";
        }
        else {
            return "unknown";
        }
    }
}
