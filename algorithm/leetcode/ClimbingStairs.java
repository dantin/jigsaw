public class ClimbingStairs {

    public int climbingStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int count = 0;
        int hist = 1;
        int prev = 2;
        for(int i = 3; i <= n; i++) {
            count = hist + prev;
            hist = prev;
            prev = count;
        }
        return count;
    }

    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbingStairs(5));
    }
}