import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Long> magazineFrequency = magazine.chars().mapToObj(i -> (char)i).collect(
            Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<Character, Long> ransomFrequency = ransomNote.chars().mapToObj(i -> (char)i).collect(
            Collectors.groupingBy(c -> c, Collectors.counting()));
        for(Map.Entry<Character, Long> entry : ransomFrequency.entrySet()) {
            Character key = entry.getKey();
            Long frequency = entry.getValue();

            if(!magazineFrequency.containsKey(key) || magazineFrequency.get(key) < frequency) {
                return false;
            }
        }
        return true;
        
        // frequentChars.forEach((k, v) -> System.out.println(k + ":" + v));

        // return true;
    }

    public static void main(String[] args) {
        RansomNote solution = new RansomNote();
        System.out.println(solution.canConstruct("aa", "aab"));
    }
}