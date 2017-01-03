public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int maxLength = 0;
        int[] hashTable = new int[256];
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = -1;
        }

        for (int fast = 0; fast < s.length(); fast++) {
            int ord = (int)s.charAt(fast);
            if (hashTable[ord] != -1) {
                while (slow <= hashTable[ord]) {
                    hashTable[(int)s.charAt(slow)] = -1;
                    slow++;
                }

            }
            maxLength = Math.max(fast - slow + 1, maxLength);
            hashTable[ord] = fast;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "c";
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solution.lengthOfLongestSubstring(str));
    }
}