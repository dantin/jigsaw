public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        char[] str = s.toCharArray();
        int i = 0, j = str.length - 1;
        while (i < j) {
            if (!(Character.isLetter(str[i]) || Character.isDigit(str[i]))) {
                i++;
                continue;
            }
            if (!(Character.isLetter(str[j]) || Character.isDigit(str[j]))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(str[i]) == Character.toLowerCase(str[j])) {
                i++;
                j--;
                continue;
            }
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "0P";
        System.out.println(Character.isAlphabetic('0'));

        ValidPalindrome solution = new ValidPalindrome();
        System.out.printf("\"%s\" %s palindrome\n", s, solution.isPalindrome(s) ? "is" : "is NOT");
    }
}