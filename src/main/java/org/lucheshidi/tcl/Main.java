package org.lucheshidi.tcl;

import org.lucheshidi.tcl.user.UserInput;

public class Main {
    // 程序对应信息
    public static final String programPath = System.getProperty("user.dir");
    public static final String programName = "TerminalCraftLauncher";
    public static final String programId = "terminal-craft-launcher";
    // 用户信息
    public static final String userHomeDir = System.getProperty("user.home");
    public static final String userName = System.getProperty("user.name");
    //main();
    public static void main(String[] args) {
        System.out.println("Welcome to Terminal Craft Launcher!");
        System.out.println("Plateau Craft Launcher is init ...");
        // INIT
        UserInput.waitInput();
    }
}