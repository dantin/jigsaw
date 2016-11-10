public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        int value = x;
        int palindrome = 0;

        while(value > 0) {
            palindrome *= 10;
            palindrome += value % 10;
            value /= 10;
        }

        return x == palindrome;
    }

    public static void main(String[] args) {
        int num = 1223;

        PalindromeNumber solution = new PalindromeNumber();
        System.out.printf("%d %s palindrome\n", num, solution.isPalindrome(num) ? "is" : "is NOT");
    }
}