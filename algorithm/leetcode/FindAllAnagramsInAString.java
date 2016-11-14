import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> locations = new ArrayList<>();

        int[] hash = new int[256];
        for(char c : p.toCharArray()) {
            hash[c]++;
        }

        int left = 0, right = 0, count = p.length();
        while(right < s.length()) {
            if(hash[s.charAt(right++)]-- >= 1) count--;
            if(count == 0) locations.add(left);
            if(right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }

        return locations;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> locations = new ArrayList<>();

        int[] characters = new int[128];
        for (int i = 0; i < p.length(); i++) {
            characters[p.charAt(i)]++;
        }

        System.out.println(Arrays.toString(characters));

        int[] window = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            window[c]++;
            if (i >= p.length()) {
                char oc = s.charAt(i - p.length());
                window[oc]--;
            }
            if (Arrays.equals(characters, window)) {
                locations.add(i + 1 - p.length());
            }
        }

        return locations;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> locations = new ArrayList<>();

        int[] characters = new int[26];
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            characters[c - 'a']++;
        }

        System.out.println(Arrays.toString(characters));
        for (int i = 0; i < s.length(); i++) {
            int[] current = new int[26];
            System.arraycopy(characters, 0, current, 0, 26);
            System.out.println(Arrays.toString(current));

            System.out.println("index: " + i);
            for (int j = i + p.length() - 1; j < s.length() && j >= i; j--) {
                char c = s.charAt(j);
                System.out.print(c + " ");
                if (characters[c - 'a'] > 0) {
                    if (current[c - 'a'] > 0) current[c - 'a']--;
                } else {
                    break;
                }
            }

            int remaining = 0;
            for (int k = 0; k < current.length; k++) {
                remaining += current[k];
            }
            if (remaining == 0) locations.add(i);
            System.out.println();
        }
        return locations;
    }

    public static void main(String[] args) {
        String s = "abacbabc";
        String p = "abc";

        FindAllAnagramsInAString solution = new FindAllAnagramsInAString();
        System.out.println("input string: " + s);
        System.out.println("pattern: " + p);
        System.out.println(solution.findAnagrams(s, p));

    }

}