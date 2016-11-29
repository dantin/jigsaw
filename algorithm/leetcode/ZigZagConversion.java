public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;

        StringBuilder buf = new StringBuilder();
        if(s.length() == 0) return buf.toString();

        int size = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++) {
            for(int j = i; j < s.length(); j += size) {
                buf.append(s.charAt(j));
                if(i != 0 && i != numRows - 1) {
                    int tmp = j + size - 2 * i;
                    if(tmp < s.length()) {
                        buf.append(s.charAt(tmp));
                    }
                }
            }
        }

        return buf.toString();
    }

    public static void main(String[] args) {
        String s = "ABCDE";
        int rows = 4;

        ZigZagConversion solution = new ZigZagConversion();
        System.out.printf("convert(\"%s\", %d) = %s\n", s, rows, solution.convert(s, rows));
    }
}