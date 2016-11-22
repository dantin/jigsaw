public class NthDigit {

    public int findNthDigit(int n) {
        int len = 1;
        int count = 9;
        int start = 1;
        while(n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }

        start += (n-1)/len;
        String s = Integer.toString(start);

        return Character.getNumericValue(s.charAt((n-1)%len));
    }

    public static void main(String[] args) {
        int n = 2147483647;

        NthDigit solution = new NthDigit();
        System.out.println("Input:  " + n);
        System.out.println("Output: " + solution.findNthDigit(n));
    }
}