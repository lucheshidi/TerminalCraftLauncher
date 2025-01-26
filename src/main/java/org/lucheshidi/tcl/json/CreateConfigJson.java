package org.lucheshidi.tcl.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.lucheshidi.tcl.Main.*;

public class CreateConfigJson {
    public static void createJson() {
        File file = new File(programPath + "/tcl/tcl.json");
        if (!file.exists()) {
            // 创建嵌套类的实例
            Dirs dirs = new Dirs("NULL", "java");
            GameConfig gameConfig = new GameConfig(false, "");
            Config config = new Config(dirs, gameConfig);
    
            // 使用Gson序列化为JSON字符串
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(config);
    
            // 写入到JSON文件
            try (FileWriter writer = new FileWriter(programPath + "/tcl/tcl.json")) {
                writer.write(json);
            } 
            catch (IOException e) {
                e.printStackTrace();
                File folder = new File(programPath + "/tcl");
                folder.mkdirs();
                createJson();
            }
        }
    }
}
