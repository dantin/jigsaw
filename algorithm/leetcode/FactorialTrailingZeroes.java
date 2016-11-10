public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n / 5;
            // five *= 5;
            n /= 5;
        }
        return sum;
    }

    public static void main(String[] args) {
        int num = 1808548329;

        FactorialTrailingZeroes solution = new FactorialTrailingZeroes();
        System.out.printf("%d!'s trailing zeros: %d\n", num, solution.trailingZeroes(num));
    }
}