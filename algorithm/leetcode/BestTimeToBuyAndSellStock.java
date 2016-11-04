public class BestTimeToBuyAndSellStock {
    
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int current = 0;
        int prev = 0;
        for(int i = 1; i < prices.length; i++) {
            int n = prices[i];
            current = (n - min > prev) ? (n - min) : prev;
            if(n < min) min = n;
            prev = current;
        }
        return current;
    }

    public static void main(String[] args) {
        int[] input = new int[]{7, 1, 5, 3, 6, 4};

        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        System.out.println(solution.maxProfit(input));
    }
}