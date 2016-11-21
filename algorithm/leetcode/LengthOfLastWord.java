public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;
        if(s == null) return length;
        s = s.trim();
        if(s.length() == 0) return length;

        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == ' ') break;
            length++;
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "a ";

        LengthOfLastWord solution = new LengthOfLastWord();
        System.out.println("String: " + s);
        System.out.println("Length Of Last Word: " + solution.lengthOfLastWord(s));
    }
}