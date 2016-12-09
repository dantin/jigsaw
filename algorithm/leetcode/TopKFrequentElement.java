import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElement {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            if (freq.containsKey(num)) {
                int cnt = freq.get(num);
                freq.put(num, cnt + 1);
            } else {
                freq.put(num, 1);
            }
        }

        Queue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.freq - o2.freq;
            }
        });

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            if (count < k) {
                heap.offer(pair);
            } else if (pair.freq > heap.peek().freq) {
                heap.poll();
                heap.offer(pair);
            }
            count++;
        }

        List<Integer> top = new ArrayList<>();
        for (Pair node : heap) {
            top.add(node.value);
        }
        Collections.reverse(top);
        return top;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 2, 2, 4};
        int k = 2;

        TopKFrequentElement solution = new TopKFrequentElement();
        System.out.println(Arrays.toString(nums));
        System.out.println("k = " + k);
        System.out.println(solution.topKFrequent(nums, k));
    }
}

class Pair {
    int value;
    int freq;
    Pair(int value, int freq) {
        this.value = value;
        this.freq = freq;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("<num = ")
        .append(value)
        .append(", freq = ")
        .append(freq)
        .append(">");
        return buf.toString();
    }
}