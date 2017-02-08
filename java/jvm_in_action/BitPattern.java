public class BitPattern {
    public String bitPattern(int n) {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            if (i != 0 && i % 8 == 0) {
                buf.append(' ');
            }
            int t = (n & 0x80_00_00_00 >>> i) >>> (31 - i);
            buf.append(t);
        }
        return buf.toString();
    }
    public static void main(String[] args) {
        int a = -10;
        BitPattern solution = new BitPattern();
        System.out.println(solution.bitPattern(a));
        System.out.println(Integer.toBinaryString(a));
    }
}