import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        int size = people.length;
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(new int[] {people[i][0], people[i][1], 0});
        }
        int[][] ans = new int[size][];
        for (int i = 0; i < size; i++) {
            Collections.sort(list, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[1] == b[1]) return a[0] - b[0];
                    return a[1] - b[1];
                }
            });
            int[] head = list.removeFirst();
            ans[i] = new int[] {head[0], head[1] + head[2]};
            for (int[] p : list) {
                if (p[0] <= head[0]) {
                    p[1] -= 1;
                    p[2] += 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] people = new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};

        System.out.print("Input: ");
        print(people);

        QueueReconstructionByHeight solution = new QueueReconstructionByHeight();
        int[][] reconstructedQueue = solution.reconstructQueue(people);
        System.out.print("Output: ");
        print(reconstructedQueue);
    }

    private static void print(int[][] array) {
        System.out.print("[");
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) System.out.print(", ");
                System.out.print(Arrays.toString(array[i]));
            }
        }
        System.out.println("]");
    }
}