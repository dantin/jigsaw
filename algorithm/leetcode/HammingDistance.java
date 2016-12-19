public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int d = 0;
        int xor = x ^ y;
        while(xor != 0) {
            d += xor & 1;
            xor /= 2;
        }

        return d;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;

        System.out.printf("x = %d, y = %d\n", x, y);
        HammingDistance solution = new HammingDistance();
        System.out.println(solution.hammingDistance(x, y));
    }
}