import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class WriteJsonExample {
    public static void main(String[] args) {
        // 假设我们有一个Java对象
        Config config = new Config("exampleValue", 42, true);

        // 使用Gson序列化对象为JSON字符串
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(config);

        // 写入JSON到文件
        try (FileWriter writer = new FileWriter("config.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Config {
    String name;
    int value;
    boolean active;

    public Config(String name, int value, boolean active) {
        this.name = name;
        this.value = value;
        this.active = active;
    }

    // Getters和Setters可以根据需要添加
}