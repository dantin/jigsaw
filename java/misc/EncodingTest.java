public class EncodingTest {
    public static void main(String[] args) {
        String s  = "中国人a";
        try {
            //线程睡眠，阻止线程退出
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}