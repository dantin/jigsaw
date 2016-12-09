import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 4, 7};

        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();
        System.out.println(Arrays.toString(prices));
        System.out.println("Max profit: " + solution.maxProfit(prices));
    }
}