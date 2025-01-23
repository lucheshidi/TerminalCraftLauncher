import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class ReadJsonExample {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // 从文件读取JSON
        try (FileReader reader = new FileReader("config.json")) {
            Config config = gson.fromJson(reader, Config.class);

            // 打印读取到的配置内容
            System.out.println("Name: " + config.name);
            System.out.println("Value: " + config.value);
            System.out.println("Active: " + config.active);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Config类可以复用上面的定义
}