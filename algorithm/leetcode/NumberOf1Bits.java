public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n & 1;
            n >>>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberOf1Bits solution = new NumberOf1Bits();
        System.out.println(solution.hammingWeight(11));
    }
}