import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
        for(int[] i : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int[] j : points) {
                int distance = (i[0] - j[0]) * (i[0] - j[0]) + (i[1] - j[1]) * (i[1] - j[1]);
                if(map.containsKey(distance)) {
                    int count = map.get(distance);
                    map.put(distance, count + 1);
                } else {
                    map.put(distance, 1);
                }
            }
            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int count = entry.getValue();
                sum += count * (count - 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {1, 0}, {2, 0}};

        NumberOfBoomerangs solution = new NumberOfBoomerangs();
        System.out.println(solution.numberOfBoomerangs(points));
    }
}