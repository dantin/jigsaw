public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        n = Math.min(n, 10);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            dp[i] = 9;
            for(int j = 9; j >= 9 - i + 2; j--) {
                dp[i] *= j;
            }
        }

        int ans = 0;
        for(int i = 0; i < dp.length; i++) {
            ans += dp[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2;

        CountNumbersWithUniqueDigits solution = new CountNumbersWithUniqueDigits();
        System.out.println(solution.countNumbersWithUniqueDigits(n));
    }
}