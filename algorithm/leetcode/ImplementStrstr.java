public class ImplementStrstr {

    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) return -1;
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "one two three";
        String needle = "two";

        ImplementStrstr solution = new ImplementStrstr();
        System.out.println("haystack: " + haystack);
        System.out.println("needle: " + needle);
        System.out.println("index: " + solution.strStr(haystack, needle));
    }
}