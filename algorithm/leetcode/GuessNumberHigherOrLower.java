public class GuessNumberHigherOrLower {

    private static final int SCOPE =  2126753390;
    private static final int TARGET = 1702766719;

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low <= high) {
            int mid = (low + high) >>> 1;
            switch(guess(mid)) {
                case -1:
                    high = mid - 1;
                    break;
                case 1:
                    low = mid + 1;
                    break;
                default:
                    return mid;
            }
        }
        return low;
    }

    private int guess(int num) {
        if(num < TARGET) return 1;
        else if(num > TARGET) return -1;
        else return 0;
    }

    public static void main(String[] args) {
        GuessNumberHigherOrLower solution = new GuessNumberHigherOrLower();
        System.out.println(solution.guessNumber(SCOPE));
    }
}