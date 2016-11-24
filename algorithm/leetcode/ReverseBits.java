public class ReverseBits {

    public int reverseBits(int n) {
        int count = 0;
        int sum = 0;
        while(n > 0) {
            count++;
            sum *= 2;
            sum += n % 2;
            n /= 2;
        }
        sum <<= 32-count;
        return sum;
    }

    public static void main(String[] args) {
        int input = 1;

        ReverseBits solution = new ReverseBits();
        System.out.println("Input:  " + input);
        System.out.println("Output: " + solution.reverseBits(input));
    }
}