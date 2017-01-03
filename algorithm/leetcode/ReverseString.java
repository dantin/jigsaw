public class ReverseString {

    public String reverseString2(String s) {
        StringBuilder buffer = new StringBuilder(s);
        return buffer.reverse().toString();
    }

    public String reverseString(String s) {
        char[] buffer = s.toCharArray();
        int i = 0, j = buffer.length - 1;
        while (i < j) {
            char tmp = buffer[i];
            buffer[i++] = buffer[j];
            buffer[j--] = tmp;
        }

        return new String(buffer);
    }

    public String reverseString1(String s) {
        StringBuilder buffer = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            buffer.append(s.charAt(i));
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        System.out.println(solution.reverseString("hello"));
    }
}