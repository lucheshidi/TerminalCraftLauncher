package org.lucheshidi.tcl.input;

import java.util.HashMap;
import java.util.Map;

public class Commands {
    public static void executeCommand(String input) {
        // 将输入解析为命令与选项
        ParsedCommand parsed = parseInput(input);
        String command = parsed.command;
        Map<String, String> options = parsed.options;

        // 根据命令执行对应逻辑
        switch (command.toLowerCase()) {
            case "launch":
                handleLaunchCommand(options);
                break;
            case "install":
                handleInstallCommand(options);
                break;
            case "delete":
                handleDeleteCommand(options);
                break;
            case "help":
                handleHelpCommand(options);
                break;
            default:
                System.out.println("无效指令，请输入有效命令：launch、install、delete 或 help。");
                break;
        }
    }

    private static void handleLaunchCommand(Map<String, String> options) {
        String version = options.get("version");
        if (version == null) {
            System.out.println("缺少版本号，请使用 `launch <version>` 指定版本号。");
        } else {
            System.out.println("正在启动版本：" + version);
        }
    }

    private static void handleInstallCommand(Map<String, String> options) {
        String version = options.get("version");
        String customName = options.get("name"); // 捕获自定义名字
        if (version == null) {
            System.out.println("缺少版本号，请使用 `install <version>` 指定版本号。");
            return;
        }

        System.out.println("正在尝试安装版本：" + version);

        // 检查模块选项的兼容性
        if (!checkCompatibility(options)) {
            System.out.println("检测到不兼容的模块选项，安装已终止。");
            return;
        }

        // 模块安装逻辑
        if (options.containsKey("install-fabric")) {
            System.out.println("安装 Fabric...");
        }
        if (options.containsKey("install-fabric-api")) {
            System.out.println("安装 Fabric API...");
        }
        if (options.containsKey("install-forge")) {
            System.out.println("安装 Forge...");
        }
        if (options.containsKey("install-neoforge")) {
            System.out.println("安装 NeoForge...");
        }
        if (options.containsKey("install-optifine")) {
            System.out.println("安装 OptiFine...");
        }

        if (customName != null) {
            System.out.println("设置自定义名称为：" + customName);
        }

        System.out.println("版本安装完成：" + version);
    }

    private static void handleDeleteCommand(Map<String, String> options) {
        String version = options.get("version");
        if (version == null) {
            System.out.println("缺少版本号，请使用 `delete <version>` 指定版本号。");
        } else {
            System.out.println("正在删除版本：" + version);
        }
    }

    private static void handleHelpCommand(Map<String, String> options) {
        // 检查是否有 -v 或 --verbose 参数
        if (options.containsKey("verbose")) {
            System.out.println("帮助命令 - 详细模式");
            System.out.println("  launch <version>                 启动指定版本");
            System.out.println("  install <version> [选项]          安装指定版本");
            System.out.println("      --name <name>, -n <name>     设置安装的自定义名称");
            System.out.println("      --install-fabric,      -if   安装 Fabric");
            System.out.println("      --install-fabric-api,  -ifa  安装 Fabric API");
            System.out.println("      --install-forge,       -ifo  安装 Forge");
            System.out.println("      --install-neoforge,    -ino  安装 NeoForge");
            System.out.println("      --install-optifine,    -io   安装 OptiFine");
            System.out.println("  delete <version>           删除指定版本");
            System.out.println("  help [-v | --verbose]      显示帮助信息，-v 显示详细信息");
        }
        else {
            System.out.println("帮助命令");
            System.out.println("  launch       启动版本");
            System.out.println("  install      安装版本");
            System.out.println("  delete       删除版本");
            System.out.println("  help         显示帮助信息");
            System.out.println("使用 `help -v` 查看详细帮助。");
        }
    }

    /**
     * 检测模块间的不兼容性
     *
     * @param options 用户传入的选项
     * @return 如果检测到冲突返回 false，否则返回 true
     */
    private static boolean checkCompatibility(Map<String, String> options) {
        // 定义不兼容的选项对
        String[][] incompatiblePairs = {
                {"install-fabric", "install-forge"},
                {"install-fabric", "install-neoforge"},
                {"install-fabric", "install-optifine"},
                {"install-neoforge", "install-optifine"},
                {"install-forge", "install-neoforge"}
        };

        // 遍历检查不兼容的选项对
        for (String[] pair : incompatiblePairs) {
            if (options.containsKey(pair[0]) && options.containsKey(pair[1])) {
                System.out.println("检测到冲突选项：" + pair[0] + " 和 " + pair[1] + " 不能同时安装。");
                return false; // 存在冲突，返回 false
            }
        }

        return true; // 没有冲突
    }

    /**
     * 解析输入命令和选项
     */
    private static ParsedCommand parseInput(String input) {
        String[] tokens = input.split(" "); // 按空格分割输入
        String command = tokens[0]; // 第一部分是主命令
        Map<String, String> options = new HashMap<>();

        // 遍历选项
        if (tokens.length > 1) {
            options.put("version", tokens[1]); // 第二部分是版本号
        }
        for (int i = 2; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.startsWith("--")) {
                if (token.contains("=")) {
                    // 处理带等号的参数，例如 --name=customName
                    String[] parts = token.substring(2).split("=", 2);
                    options.put(parts[0].toLowerCase(), parts[1]);
                } else {
                    // 处理普通 --option
                    String optionName = token.substring(2).toLowerCase();
                    options.put(optionName, "true");
                }
            } else if (token.startsWith("-")) {
                // 处理短参数，例如 -v, -n customName
                String optionName = token.substring(1).toLowerCase();
                if (i + 1 < tokens.length && !tokens[i + 1].startsWith("-")) {
                    options.put(optionName, tokens[++i]); // 捕获短参数的值
                } else {
                    options.put(optionName, "true"); // 捕获布尔类型短参数
                }
            }
        }

        return new ParsedCommand(command, options);
    }

    /**
     * 辅助数据类，用于存储解析后的命令和选项
     */
    private static class ParsedCommand {
        String command;
        Map<String, String> options;

        ParsedCommand(String command, Map<String, String> options) {
            this.command = command;
            this.options = options;
        }
    }
}