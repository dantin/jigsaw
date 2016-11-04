public class CipherMachine {
    public String encrypt(String plainText) {
        System.out.print("数据加密，将明文转换为密文：");

        StringBuilder sb = new StringBuilder();
        char[] chars = plainText.toCharArray();
        for (char ch : chars) {
            sb.append(ch % 7);
        }

        System.out.println(sb.toString());

        return sb.toString();
    }
}