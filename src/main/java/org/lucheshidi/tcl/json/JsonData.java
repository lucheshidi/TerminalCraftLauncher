package org.lucheshidi.tcl.json;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.lucheshidi.tcl.json.classes.Config;
import org.lucheshidi.tcl.json.classes.CustomConfig;
import org.lucheshidi.tcl.json.classes.Dirs;
import org.lucheshidi.tcl.json.classes.GameConfig;

public class JsonData {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // 定义Json的Java对象
    static Dirs dirs = new Dirs("NULL", "java");
    static GameConfig gameConfig = new GameConfig(false, "");
    static CustomConfig launcherConfig = new CustomConfig(false, "");
    static Config config = new Config(dirs, gameConfig, launcherConfig);

    @Contract(pure = true)
    public static @NotNull String get(String name) {
        if (name == "minecraftDir") {
            return dirs.getMinecraftDir();
        }
        if (name == "javaDir") {
            return dirs.getJavaDir();
        }
        if (name == "isOpenVersionIsolation") {
            return String.valueOf(gameConfig.getIsOpenVersionIsolation());
        }
        if (name == "javaLaunchArguments") {
            return gameConfig.getJavaLaunchArguments();
        }
        if (name == "enableCustomPrompt") {
            return String.valueOf(launcherConfig.getEnableCustomPrompt());
        }
        if (name == "CustomPrompt") {
            return launcherConfig.getCustomPrompt();
        }

        // 将 Config 对象序列化为 JSON 字符串
        String jsonString = gson.toJson(config);
        // 使用 JsonData.set 存储
        JsonData.set("config", jsonString);
        return "";
    }

    @Contract(pure = true)
    public static @NotNull String set(String name, String value) {
        if (name == "minecraftDir") {
            dirs.setMinecraftDir(value);
            return "success";
        }
        if (name == "javaDir") {
            dirs.setJavaDir(value);
            return "success";
        }
        if (name == "isOpenVersionIsolation") {
            gameConfig.setIsOpenVersionIsolation(Boolean.parseBoolean(value));
            return "success";
        }
        if (name == "javaLaunchArguments") {
            gameConfig.setJavaLaunchArguments(value);
            return "success";
        }
        if (name == "enableCustomPrompt") {
            launcherConfig.setEnableCustomPrompt(Boolean.parseBoolean(value));
            return "success";
        }
        if (name == "CustomPrompt") {
            launcherConfig.setCustomPrompt(value);
            return "success";
        }


        return "";
    }
}