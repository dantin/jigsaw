import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class EncryptFileWriter {

    public void write(String content, String filename) {
        System.out.println("保存密文，写入文件。");

        File file = new File(filename);
        try (FileOutputStream fop = new FileOutputStream(file)) {

            // if file doesn't exists, then create it
            // if (!file.exists()) {
            //     file.createNewFile();
            // }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}