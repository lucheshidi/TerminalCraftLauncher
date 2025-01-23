package org.lucheshidi.tcl.json;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class JsonData {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // 定义Json的Java对象
    static Dirs dirs = new Dirs("NULL", "java");
    static GameConfig gameConfig = new GameConfig(false, "");
    static Config config = new Config(dirs, gameConfig);

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

        return "";
    }
}