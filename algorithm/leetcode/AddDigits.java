public class AddDigits {

    public int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
            if (sum >= 10) {
                num += sum / 10;
                sum %= 10;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        AddDigits solution = new AddDigits();
        System.out.println(solution.addDigits(19));
    }
}