import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class HoldNetMain {
    public static class HoldNetTask implements Runnable {

        public void visitWeb(String strUrl) {
            URL url = null;
            URLConnection urlcon = null;
            InputStream is = null;

            try {
                url = new URL(strUrl);
                urlcon = url.openConnection();
                is = urlcon.getInputStream();
                BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
                StringBuffer bs = new StringBuffer();
                String l = null;
                while ((l = buffer.readLine()) != null) {
                    bs.append(l).append("\r\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        public void run() {
            while (true) {
                visitWeb("http://www.sina.com.cn");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new HoldNetTask()).start();
    }
}