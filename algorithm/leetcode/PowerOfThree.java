public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        return 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        PowerOfThree solution = new PowerOfThree();
        System.out.println(solution.isPowerOfThree(1162261467));
    }
}