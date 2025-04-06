package org.lucheshidi.tcl.user;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.lucheshidi.tcl.input.Commands;
import org.lucheshidi.tcl.util.SystemPlatform;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.lucheshidi.tcl.Main.userHomeDir;
import static org.lucheshidi.tcl.Main.userName;

public class UserInput {
    // 定义基础路径
    public static String baseDir = null;
    public static String realBaseDir = null;
    public static String prompt = null;
    public static void waitInput() {
        // 设置日志为 ERROR，强制隐藏警告信息
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        
        // 初始化
        LineReader lineReader = LineReaderBuilder.builder().build();
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
            // 使用 LineReader 监听输入
            String input = null;
            if (prompt == null) {
                input = lineReader.readLine("tcl@TerminalCraftLauncher [" + baseDir + "] >> ");
            }
            else {
                String[] promptParts = prompt.split("%Dir");
                input = lineReader.readLine(promptParts[0] + baseDir + promptParts[1]);
            }
            // 清空控制台
            if (input != null && input.equals("\f")) {
                clearConsole();
            }
            // 执行命令
            else {
                if (input != null) {
                    Commands.executeCommand(input.trim());
                }
            }
        }
    }

    //清屏
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}