public class UglyNumber {

    public boolean isUgly(int num) {
        if(num <= 0) return false;
        boolean isOps = false;
        while(num != 0) {
            isOps = false;
            if(num % 2 == 0) {num /= 2; isOps = true;}
            if(num % 3 == 0) {num /= 3; isOps = true;}
            if(num % 5 == 0) {num /= 5; isOps = true;}
            if(num == 1) return true;
            if(!isOps) break;
        }
        return false;
    }

    public static void main(String[] args) {
        int num = 6;
        UglyNumber solution = new UglyNumber();
        System.out.printf("%d %s ugly number\n", num, solution.isUgly(num) ? "is" : "is NOT");
    }
}