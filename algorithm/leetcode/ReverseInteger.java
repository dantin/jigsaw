public class ReverseInteger {

    public int reverse(int x) {
        if(x == Integer.MIN_VALUE) return 0;
        
        int num = Math.abs(x);
        int sum = 0;
        while(num != 0) {
            if(sum > (Integer.MAX_VALUE - num % 10)/ 10) return 0;
            sum *= 10;
            sum += num % 10;
            num /= 10;
        }

        return x > 0 ? sum : -sum;
    }

    public static void main(String[] args) {
        int n = 1534236469;

        ReverseInteger solution = new ReverseInteger();
        System.out.printf("x = %d, return %d\n", n, solution.reverse(n));
    }
}