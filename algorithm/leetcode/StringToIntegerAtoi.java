public class StringToIntegerAtoi {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int i = 0;
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) i++;

        boolean flag = false;
        long sum = 0;
        if (str.charAt(i) == '-') {
            flag = true;
            i++;
        } else if (str.charAt(i) == '+') {
            flag = false;
            i++;
        } else if (!Character.isDigit(str.charAt(i)))
            return 0;

        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            sum *= 10;
            sum += str.charAt(i++) - '0';
            if (sum > Integer.MAX_VALUE) break;
            if (sum < Integer.MIN_VALUE) break;
        }

        sum = flag ? -1 * sum : sum;

        if (sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)sum;
    }

    public static void main(String[] args) {
        String s = "2147483648";
        StringToIntegerAtoi solution = new StringToIntegerAtoi();
        System.out.printf("\"%s\" -> %d\n", s, solution.myAtoi(s));
    }
}