public class ArrangingCoins {

    public int arrangeCoins(int n) {
        int i = 0;
        while(true) {
            System.out.printf("remaining: %d, i: %d\n", n, i);
            n -= i;
            if(n <= i) {
                break;
            }
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        ArrangingCoins solution = new ArrangingCoins();
        System.out.println(solution.arrangeCoins(5));
    }
}