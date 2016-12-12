public class IntegerBreak {

    public int integerBreak(int n) {
        if (n < 3) return 1;
        if (n == 3) return 2;
        int k = n / 3;
        int r = n % 3;
        if (r == 0)
            return (int)Math.pow(3, k);
        else if (r == 1)
            return (int)(4 * Math.pow(3, k - 1));
        else
            return (int)(2 * Math.pow(3, k));
    }

    public static void main(String[] args) {
        IntegerBreak solution = new IntegerBreak();
        System.out.println(solution.integerBreak(10));
    }
}