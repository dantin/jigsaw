public class ReverseString {

    public String reverseString(String s) {
        StringBuilder buffer = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            buffer.append(s.charAt(i));
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();
        System.out.println(solution.reverseString("hello"));
    }
}