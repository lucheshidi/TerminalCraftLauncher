package org.lucheshidi.tcl.json;

import com.google.gson.Gson;

public class JsonDataManager {
    private static final Gson gson = new Gson();

    // 保存 Config 对象到 JsonData
    public static void saveConfig(Config config) {
        // 将 Config 对象序列化为 JSON 字符串
        String jsonString = gson.toJson(config);
        // 使用 JsonData.set 存储
        JsonData.set("config", jsonString);
    }

    // 从 JsonData 中获取 Config 对象
    public static Config loadConfig() {
        // 从 JsonData.get 获取 JSON 字符串
        String jsonString = JsonData.get("config");
        // 将 JSON 字符串反序列化为 Config 对象
        return gson.fromJson(jsonString, Config.class);
    }
}
