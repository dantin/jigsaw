import java.util.Arrays;

public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        /**
         *题目可以转化为计算矩形相交部分的面积
         * S(M) = (C - A) * (D - B)
         * S(N) = (G - E) * (H - F)
         * S(M ∩ N) = max(min(C, G) - max(A, E), 0) * max(min(D, H) - max(B, F), 0)
         */
        /*
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        int a = Math.min(C, G) - Math.max(A, E);
        int b = Math.min(D, H) - Math.max(B, F);

        System.out.println(-1500000000-1500000000);
        System.out.println(-1500000000L-1500000000L);
        System.out.printf("a: " + a + ", b: " + b);
        int intersection = Math.max(a, 0) * Math.max(b, 0);
        return area1 + area2 - intersection;
        */
        int dup = 0;
        if(C < E || G < A || D < F || H < B){
            dup = 0;
        } else {
            int[] x = {A, C, E, G};
            int[] y = {B, D, F, H};
            Arrays.sort(x);
            Arrays.sort(y);
            dup = (x[2] - x[1]) * (y[2] - y[1]);
        }
        return (C - A) * (D - B) + (G - E)*(H - F) - dup;
    }

    public static void main(String[] args) {
        int A = -1500000001;
        int B = 0;
        int C = -1500000000;
        int D = 1;
        int E = 1500000000;
        int F = 0;
        int G = 1500000001;
        int H = 1;

        RectangleArea solution = new RectangleArea();
        System.out.printf("Rectangle I: bottom left (%d, %d), top right (%d, %d)\n", A, B, C, D);
        System.out.printf("Rectangle II: bottom left (%d, %d), top right (%d, %d)\n", E, F, G, H);
        System.out.printf("Total Area: %d\n", solution.computeArea(A, B, C, D, E, F, G, H));
    }
}