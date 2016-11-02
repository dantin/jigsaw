public class NimGame {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        NimGame solution = new NimGame();
        System.out.println(solution.canWinNim(4));
    }
}