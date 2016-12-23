import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        // sort by begin, then end
        Arrays.sort(points, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        int count = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            } else {
                count++;
                end = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {
            {10, 16},
            {2, 8},
            {1, 6},
            {7, 12}
        };

        for (int i = 0; i < points.length; i++) {
            System.out.println(Arrays.toString(points[i]));
        }

        MinimumNumberOfArrowsToBurstBalloons solution = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(solution.findMinArrowShots(points));
    }
}