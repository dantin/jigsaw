public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] charFreq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            charFreq[s.charAt(i) - 'a'] += 1;
        }
        for(int i = 0; i < t.length(); i++) {
            charFreq[t.charAt(i) - 'a'] -= 1;
        }
        
        for(int x : charFreq) {
            if(x != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        System.out.println(solution.isAnagram("anagram", "nagaram"));
    }
}