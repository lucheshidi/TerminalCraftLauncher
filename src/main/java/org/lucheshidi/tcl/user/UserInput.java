package org.lucheshidi.tcl.user;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.lucheshidi.tcl.input.Commands;

import org.lucheshidi.tcl.util.SystemPlatform;

import static org.lucheshidi.tcl.Main.userHomeDir;
import static org.lucheshidi.tcl.Main.userName;

public class UserInput {
    // 定义基础路径
    public static String baseDir = null;
    public static String realBaseDir = null;
    public static void waitInput() {
        // 初始化
        LineReader reader = LineReaderBuilder.builder().build();
        // 获取系统类型
        String SystemType = SystemPlatform.getPlatformName();
        // 判断系统类型并定义 baseDir 的值
        switch (SystemType) {
            case "windows" -> {
                baseDir = userHomeDir;
                realBaseDir = "\\??\\C:\\Users\\" + userName;
            }
            case "mac", "unknown" -> {
                baseDir = userHomeDir;
                realBaseDir = userHomeDir;
            }
            case "unix" -> {
                baseDir = "~";
                realBaseDir = userHomeDir;
            }
            default -> System.out.println("Unknown system type, please report this to the developer.");
        }

        //重复监听用户输入
        while (true) {
            String input = reader.readLine("tcl@TerminalCraftLauncher:" + baseDir + " @ ");

            if (input != null && input.equals("\u000C")) { // 检测 Ctrl+L
                clearConsole();
                continue;
            }

            Commands.executeCommand(input.trim());
        }
    }

    //清屏
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}