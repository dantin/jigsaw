public class FirstUniqueCharacterInAString {

    public int firstUniqueChar(String s) {
        int[] cache = new int[26];
        for(char c = 'a'; c <= 'z'; c++)
            cache[c - 'a'] = 0;
        for(int i = 0; i < s.length(); i++) {
            cache[s.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < s.length(); i++) {
            if(cache[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInAString solution = new FirstUniqueCharacterInAString();
        System.out.println(solution.firstUniqueChar("loveleetcode"));
    }
}