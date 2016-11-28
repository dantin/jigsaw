public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        // if(n == 1) return 1;
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(mid);
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        FirstBadVersion solution = new FirstBadVersion();
        System.out.println(solution.firstBadVersion(2126753390));
    }

}

class VersionControl {

    public boolean isBadVersion(int n) {
        return n == 1702766719;
    }
}