public class NumberOfSegmentsInAString {

    public int countSegments(String s) {
        if(s == null) return 0;
        int segments = 0;
        boolean in = false;
        for(char c : s.toCharArray()) {
            if(!Character.isSpaceChar(c)) {
                if(!in) segments++;
                in = true;
            } else {
                in = false;
            }
        }
        return segments;
    }

    public static void main(String[] args) {
        String s = "Hello, my name is John";

        System.out.println(s);

        NumberOfSegmentsInAString solution = new NumberOfSegmentsInAString();
        System.out.println(solution.countSegments(s));
    }
}