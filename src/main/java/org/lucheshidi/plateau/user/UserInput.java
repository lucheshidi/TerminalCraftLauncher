package org.lucheshidi.plateau.user;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.lucheshidi.plateau.input.Commands;

import org.lucheshidi.plateau.util.SystemPlatform;

public class UserInput {
    public static void waitInput() {
        // 初始化
        LineReader reader = LineReaderBuilder.builder().build();
        // 获取系统类型
        String SystemType = SystemPlatform.getPlatformName();
        // 定义基础路径
        String baseDir = null;
        // 判断系统类型并定义 baseDir 的值
        switch (SystemType) {
            case "windows" -> baseDir = "C:\\";
            case "mac", "unknown" -> baseDir = "/";
            case "unix" -> baseDir = "~";
            default -> System.out.println("Unknown system type, please report this to the developer.");
        }

        //重复监听用户输入
        while (true) {
            String input = reader.readLine("tcl@TerminalCraftLauncher:" + baseDir + " # ");

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