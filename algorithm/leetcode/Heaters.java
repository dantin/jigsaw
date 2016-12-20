import java.util.Arrays;

public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(heaters);
        for(int house : houses) {
            int left = 0, right = heaters.length;
            while(left < right) {
                int mid = (left + right) / 2;
                if(heaters[mid] < house) left = mid + 1;
                else right = mid;
            }
            
            int dist1 = (right == heaters.length) ? Integer.MAX_VALUE : heaters[right] - house;
            int dist2 = (right == 0) ? Integer.MAX_VALUE : house - heaters[right - 1];
            ans = Math.max(ans, Math.min(dist1, dist2));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] houses = new int[]{1, 2, 3};
        int[] heaters = new int[]{2};

        System.out.println(Arrays.toString(houses));
        System.out.println(Arrays.toString(heaters));

        Heaters solution = new Heaters();
        System.out.println(solution.findRadius(houses, heaters));
    }
}