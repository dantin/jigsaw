import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int i = 1; i <= rowIndex; i++) {
            for(int j = row.size() - 2; j >= 0; j--) {
                row.set(j + 1, row.get(j) + row.get(j+ 1));
            }
            row.add(1);
        }
        return row;
    }

    public static void main(String[] args) {
        int row = 2;
        PascalsTriangleII solution = new PascalsTriangleII();
        System.out.println(solution.getRow(row));
    }
}