import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EncryptFileReader {
    public String read(String filename) {
        System.out.print("读取文件，获取明文：");

        StringBuilder buffer = new StringBuilder();
        File file = new File(filename);
        try (FileInputStream fis = new FileInputStream(file)) {

            int content;
            while ((content = fis.read()) != -1) {
                buffer.append((char) content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(buffer.toString());

        return buffer.toString();
    }
}