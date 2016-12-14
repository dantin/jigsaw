import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(
        new Comparator<Integer>() {
            @Override
            public int compare(Integer i0, Integer i1) {
                return i1 - i0;
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (heap.size() < k) {
                    heap.offer(matrix[i][j]);
                } else {
                    if (matrix[i][j] < heap.peek()) {
                        heap.poll();
                        heap.offer(matrix[i][j]);
                    }
                }
            }
        }

        return heap.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;

        System.out.println("matrix");
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.printf("k = %d\n", k);

        KthSmallestElementInASortedMatrix solution = new KthSmallestElementInASortedMatrix();
        System.out.printf("return %d\n", solution.kthSmallest(matrix, k));
    }
}