import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int p = 0;
        int count = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i] >= g[p]) {
                count++;
                p++;
                if(p >= g.length) break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] greedy = new int[]{1, 2, 3};
        int[] cookies = new int[]{1, 1};

        System.out.println(Arrays.toString(greedy));
        System.out.println(Arrays.toString(cookies));
        AssignCookies solution = new AssignCookies();
        System.out.println(solution.findContentChildren(greedy, cookies));
    }
}