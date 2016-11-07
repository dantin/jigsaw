import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        LinkedList<Integer> list = new LinkedList<>();

        int sum = 1;
        int i = digits.length - 1;
        while(i >= 0) {
            sum += digits[i];
            list.addFirst(sum % 10);
            sum /= 10;
            i--;
        }

        while(sum != 0) {
            list.addFirst(sum % 10);
            sum /= 10;
        }


        int[] res = new int[list.size()];
        i = 0;
        for(Integer n : list) {
            res[i++] = n;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9};

        PlusOne solution = new PlusOne();
        int[] answer = solution.plusOne(digits);
        System.out.println(Arrays.toString(answer));
    }
}