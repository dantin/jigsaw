public class ConvertANumberToHexadecimal {

    final static char[] digits = {
        '0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9', 'a', 'b',
        'c', 'd', 'e', 'f'
    };

    public String toHex(int num) {
        StringBuilder buf = new StringBuilder();
        int radix = 1 << 4;
        int mask = radix - 1;
        do {
            buf.append(digits[num & mask]);
            num >>>= 4;
        } while(num != 0);
        
        return buf.reverse().toString();
    }

    public static void main(String[] args) {
        ConvertANumberToHexadecimal solution = new ConvertANumberToHexadecimal();
        System.out.println(solution.toHex(26));
        System.out.println(solution.toHex(-1));
    }
}