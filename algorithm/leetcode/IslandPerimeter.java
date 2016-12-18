import java.util.Arrays;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sum += 4;
                    if (i > 0 && grid[i - 1][j] == 1) sum -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) sum -= 2;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };

        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }

        IslandPerimeter solution = new IslandPerimeter();
        System.out.println(solution.islandPerimeter(grid));
    }
}