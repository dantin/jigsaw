import java.util.Arrays;
import java.util.Comparator;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        int[][] freq = new int[256][2];
        for(char c : s.toCharArray()) {
            freq[c][0] = c;
            freq[c][1]++;
        }

        Arrays.sort(freq, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < 256; i++) {
            if(freq[i][1] > 0) {
                for(int j = 0; j < freq[i][1]; j++) {
                    ans.append((char)freq[i][0]);
                }
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "Aabb";

        System.out.printf("Input: %s\n", s);

        SortCharactersByFrequency solution = new SortCharactersByFrequency();
        System.out.printf("Output: %s\n", solution.frequencySort(s));
    }
}