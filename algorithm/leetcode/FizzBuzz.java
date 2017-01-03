import java.util.LinkedList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (i % 3 != 0 && i % 5 != 0) {
                sb.append(i);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        FizzBuzz solution = new FizzBuzz();
        solution.fizzBuzz(15).forEach(System.out::println);
    }
}