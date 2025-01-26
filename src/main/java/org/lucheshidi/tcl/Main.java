package org.lucheshidi.tcl;

import org.lucheshidi.tcl.json.CreateConfigJson;
import org.lucheshidi.tcl.user.UserInput;

public class Main {
    // 程序对应信息
    public static final String programPath = System.getProperty("user.dir");
    public static final String programName = "TerminalCraftLauncher";
    public static final String programId = "terminal-craft-launcher";
    // 用户信息
    public static final String userHomeDir = System.getProperty("user.home");
    public static final String userName = System.getProperty("user.name");
    // 颜色
    public static final String Red = "\033[31m";
    public static final String Green = "\033[32m";
    public static final String Yellow = "\033[33m";
    public static final String Blue = "\033[34m";
    public static final String Purple = "\033[35m";
    public static final String Reset = "\033[0m";
    // main();
    public static void main(String[] args) {
        System.out.println("Welcome to Terminal Craft Launcher!");
        System.out.println("Plateau Craft Launcher is init ...");
        // INIT
        CreateConfigJson.createJson();
        UserInput.waitInput();
    }
}