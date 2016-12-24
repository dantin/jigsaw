public class BulbSwitcher {

    public int bulbSwitch(int n) {
        int ans = 1;
        while (ans * ans <= n) ans++;
        return ans - 1;
    }

    public static void main(String[] args) {
        int n = 3;

        BulbSwitcher solution = new BulbSwitcher();
        System.out.println(solution.bulbSwitch(n));
    }
}