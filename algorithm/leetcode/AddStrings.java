public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder buf = new StringBuilder();
        int sum = 0;
        int radix = 0;
        int i = num1.length();
        int j = num2.length();
        while(i > 0 || j > 0) {
            System.out.printf("%d, %d\n", i, j);
            int a = 0;
            int b = 0;
            if(i > 0) a = num1.charAt(--i) - '0';
            if(j > 0) b = num2.charAt(--j) - '0';
            sum = a + b + radix;
            buf.append(sum % 10);
            radix = sum / 10;
        }

        while(radix > 0) {
            buf.append(radix % 10);
            radix /= 10;
        }

        return buf.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "999";
        AddStrings solution = new AddStrings();
        System.out.printf("%s + %s = %s", num1, num2, solution.addStrings(num1, num2));
    }
}