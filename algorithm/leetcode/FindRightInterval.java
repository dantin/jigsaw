import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class FindRightInterval {

    public int[] findRightInterval(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return null;

        int[] ans = new int[intervals.length];
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        for(int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> target = map.ceilingEntry(intervals[i].end);
            ans[i] = (target == null) ? -1 : target.getValue();
        }
        return ans;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{new Interval(3, 4), new Interval(2, 3), new Interval(1, 2)};

        FindRightInterval solution = new FindRightInterval();
        System.out.println(Arrays.toString(solution.findRightInterval(intervals)));
    }
}

class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}