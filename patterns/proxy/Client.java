public class Client {
    public static void main(String[] args) {
        Searcher searcher = (Searcher)XMLUtil.getBean();
        String result = searcher.doSearch("杨过", "玉女心经");
    }
}