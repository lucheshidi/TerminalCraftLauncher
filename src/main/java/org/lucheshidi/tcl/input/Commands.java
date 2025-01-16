package org.lucheshidi.tcl.input;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.lucheshidi.tcl.Main.userHomeDir;
import static org.lucheshidi.tcl.user.UserInput.baseDir;
import static org.lucheshidi.tcl.user.UserInput.realBaseDir;

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
            case "license":
                handleLicenseCommand(options);
                break;
            case "exit":
                handleExitCommand(options);
                break;
            case "cd":
                handleCdCommand(options);
                break;
            default:
                System.out.println("unknown command，use the available commands: launch、install、delete or help.");
                break;
        }
    }

    private static void handleLaunchCommand(@NotNull Map<String, String> options) {
        String version = options.get("version");
        if (version == null) {
            System.out.println("Need version, use `launch <version>` set version name.");
        } else {
            System.out.println("launching version：" + version);
        }
    }

    private static void handleInstallCommand(@NotNull Map<String, String> options) {
        String version = options.get("version");
        String customName = options.get("name"); // 捕获自定义名字
        if (version == null) {
            System.out.println("Need version, use `install <version>` set version name.");
            return;
        }

        System.out.println("trying to install version: " + version);

        // 检查模块选项的兼容性
        if (!checkCompatibility(options)) {
            System.out.println("Test not compatibility mods, install over.");
            return;
        }

        // 模块安装逻辑
        if (options.containsKey("install-fabric")) {
            System.out.println("install Fabric...");
        }
        if (options.containsKey("install-fabric-api")) {
            System.out.println("install Fabric API...");
        }
        if (options.containsKey("install-forge")) {
            System.out.println("install Forge...");
        }
        if (options.containsKey("install-neoforge")) {
            System.out.println("install NeoForge...");
        }
        if (options.containsKey("install-optifine")) {
            System.out.println("install OptiFine...");
        }

        if (customName != null) {
            System.out.println("set version name to: " + customName);
        }

        System.out.println("install version successful: " + version);
    }

    private static void handleDeleteCommand(@NotNull Map<String, String> options) {
        String version = options.get("version");
        if (version == null) {
            System.out.println("Need version, use `delete <version>` set version name.");
        } else {
            System.out.println("delete version：" + version);
        }
    }

    private static void handleHelpCommand(@NotNull Map<String, String> options) {
        // 检查是否有 -v 或 --verbose 参数
        if (options.containsKey("verbose")) {
            System.out.println("help Command - verbose mode");
            System.out.println("  launch <version>                 launch a version");
            System.out.println("  install <version> [options]          install a version");
            System.out.println("      --name <name>, -n <name>     set a name for the version");
            System.out.println("      --install-fabric,      -if   install Fabric");
            System.out.println("      --install-fabric-api,  -ifa  install Fabric API");
            System.out.println("      --install-forge,       -ifo  install Forge");
            System.out.println("      --install-neoforge,    -ino  install NeoForge");
            System.out.println("      --install-optifine,    -io   install OptiFine");
            System.out.println("  delete <version>           delete a version");
            System.out.println("  license --ens              show the essential part of GPLv3");
            System.out.println("  license --dis              show the disclaimer part of GPLv3");
            System.out.println("  help [-v | --verbose]      show help, -v show verbose help");
        }
        else {
            System.out.println("help Command");
            System.out.println("  launch       launch a version");
            System.out.println("  install      install a version");
            System.out.println("  delete       delete a version");
            System.out.println("  help         show this help");
            System.out.println("use `help -v` for verbose help.");
        }
    }

    /**
     * GPLv3的相应部分
     *
     * @param options 用户传入的选项
     */
    private static void handleLicenseCommand(@NotNull Map<String, String> options) {
        // 检查选项中是否有 "ens" 或 "dis"
        if (options.containsKey("ens")) {
            printLicenseEssentialPart();
        } else if (options.containsKey("dis")) {
            printLicenseDisclaimer();
        } else {
            System.out.println("Invalid license option. Use 'license --ens' or 'license --dis'.");
        }
    }

    private static void printLicenseEssentialPart() {
        System.out.println("""
                GNU GENERAL PUBLIC LICENSE
                Version 3, 29 June 2007

                Everyone is permitted to copy and distribute verbatim copies
                of this license document, but changing it is not allowed.

                [Essential part of GPLv3]
                This program is free software: you can redistribute it and/or modify
                it under the terms of the GNU General Public License as published by
                the Free Software Foundation, either version 3 of the License, or
                (at your option) any later version.
                """);
    }

    private static void printLicenseDisclaimer() {
        System.out.println("""
                [Disclaimer part of GPLv3]
                This program is distributed in the hope that it will be useful,
                but WITHOUT ANY WARRANTY; without even the implied warranty of
                MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
                GNU General Public License for more details.

                You should have received a copy of the GNU General Public License
                along with this program. If not, see <https://www.gnu.org/licenses/>.
                """);
    }

    private static void handleExitCommand(@NotNull Map<String, String> options) {
        System.out.println("Exiting TCL ...");
        System.exit(0);
    }

    private static void handleCdCommand(@NotNull Map<String, String> options) {
        // 获取 "dir" 参数值
        String dirPath = options.get("dir");

        // 如果 "dir" 参数值为空，则提示并返回
        if (dirPath == null || dirPath.isEmpty()) {
            baseDir = "~";
            realBaseDir = userHomeDir;
        }

        File dir = new File(dirPath);

        // 如果路径是有效目录
        if (dir.isDirectory() && dir.exists()) {
            baseDir = dir.toString();
            realBaseDir = dir.toString();
            // 如果是用户主目录，则显示为 "~"
            if (realBaseDir.equals(userHomeDir)) {
                baseDir = "~";
            }
        }
        // 路径无效时输出相应错误消息
        else {
            if (!dir.exists()) {
                System.out.println("fatal: No such directory: " + dir);
            } else {
                System.out.println("fatal: not a directory: " + dir);
            }
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
    @Contract("_ -> new")
    private static @NotNull ParsedCommand parseInput(@NotNull String input) {
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
                }
                else {
                    // 处理普通 --option
                    String optionName = token.substring(2).toLowerCase();
                    options.put(optionName, "true");
                }
            }
            else if (token.startsWith("-")) {
                // 处理短参数，例如 -v, -n customName
                String optionName = token.substring(1).toLowerCase();
                if (i + 1 < tokens.length && !tokens[i + 1].startsWith("-")) {
                    options.put(optionName, tokens[++i]); // 捕获短参数的值
                }
                else {
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