import java.util.Set;
import java.util.HashSet;

public class HappyNumber {

    public boolean isHappy(int n) {
        int sum = 0;
        int num = n;
        Set<Integer> set = new HashSet<>();

        while(true) {
            sum = 0;
            while(num > 0) {
                sum += (num % 10) * (num % 10);
                num /= 10;
            }
            num = sum;
            if(set.contains(num)) break;
            set.add(num);
            System.out.println(num);
            if(num == 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 2;
        HappyNumber solution = new HappyNumber();
        System.out.printf("%d = %s\n", num, solution.isHappy(num));
    }
}