public class Money {

    public int find(int[] money, int total) {
        int row = money.length;
        int col = total + 1;
        int[][] dp = new int[row][col];
        for(int j=0; j<col; j++)
            dp[0][j] = 1; //表示用1块钱凑出任何金额的组合数都为1
        for(int i=1; i<row; i++) {
            dp[i][0] = 1; 
            for(int j=1; j<col; j++) {
                if(j < money[i])  //表示要凑出的金额数小于当前的纸币面额，如dp[100][87] = dp[50][87]
                    dp[i][j] = dp[i-1][j];
                else 
                    dp[i][j] = dp[i-1][j] + dp[i][j-money[i]];
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        Money solution = new Money();
        System.out.println(solution.find(new int[] {1, 2, 5}, 100));
    }
}