public class ReverseVowelsOfAString {

    private static final String VOWELS = "aeiouAEIOU";

    public String reverseVowels(String s) {
        if (s == null) return "";
        int begin = 0;
        int end = s.length() - 1;
        StringBuilder buf = new StringBuilder(s);
        while (begin < end) {
            while (begin < s.length() && VOWELS.indexOf(buf.charAt(begin)) == -1) begin++;
            while (end >= 0 && VOWELS.indexOf(buf.charAt(end)) == -1) end--;
            if (begin > end) break;
            char t = buf.charAt(begin);
            buf.setCharAt(begin, buf.charAt(end));
            buf.setCharAt(end, t);
            begin++;
            end--;
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        String s = "OE";

        ReverseVowelsOfAString solution = new ReverseVowelsOfAString();
        System.out.printf("%s -> %s\n", s, solution.reverseVowels(s));
    }
}