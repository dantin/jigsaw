public class PowerOfFour {

    public boolean isPowerOfFour(int num) {
        return num >= 0 && ((num & (num - 1)) == 0) && ((num & 0x5555555555555555L) == num);
    }

    public static void main(String[] args) {
        int num = 16;
        PowerOfFour solution = new PowerOfFour();
        System.out.printf("%d %s power of 4\n", num, solution.isPowerOfFour(num) ? "is" : "is NOT");
    }
}