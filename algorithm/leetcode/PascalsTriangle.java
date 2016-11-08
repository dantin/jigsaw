import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lines = new LinkedList<>();
        List<Integer> prev = null;
        for(int i = 0; i < numRows; i++) {
            List<Integer> line = new ArrayList<>(i + 1);
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(prev.get(j - 1) + prev.get(j));
                }
            }
            prev = line;
            lines.add(line);
        }
        return lines;
    }

    public static void main(String[] args) {
        int level = 5;

        PascalsTriangle solution = new PascalsTriangle();
        System.out.println(solution.generate(level));
    }
}