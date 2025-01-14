package org.lucheshidi.tcl.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateConfigJson {
    public static void createJson() {
        String path = System.getProperty("user.dir");
        File file = new File(path + "/config.json");
        if (!file.exists()) {
            // 创建嵌套类的实例
            Dirs dirs = new Dirs("NULL", "java");
            GameConfig gameConfig = new GameConfig(false, "");
            Config config = new Config(dirs, gameConfig);
    
            // 使用Gson序列化为JSON字符串
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(config);
    
            // 写入到JSON文件
            try (FileWriter writer = new FileWriter("config.json")) {
                writer.write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
