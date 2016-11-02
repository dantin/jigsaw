import java.util.LinkedList;
import java.util.List;

public class BinaryWatch {

    public List<String> readBinaryWatch(int num) {
        List<String> times = new LinkedList<>();
        for(int h = 0; h < 12; h++) {
            for(int m = 0; m < 60; m++) {
                StringBuilder bits = new StringBuilder();
                bits.append(Integer.toBinaryString(h)).append(Integer.toBinaryString(m));
                int size = 0;
                for(int i = 0; i < bits.length(); i++) {
                    if(bits.charAt(i) == '1') {
                        size ++;
                    }
                }
                if(size == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }

    public static void main(String[] args) {
        BinaryWatch solution = new BinaryWatch();
        solution.readBinaryWatch(1).forEach(System.out::println);
    }
}