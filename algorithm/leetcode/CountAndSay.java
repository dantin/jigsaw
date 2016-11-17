public class CountAndSay {

    public String countAndSay(int n) {
        StringBuilder buf = new StringBuilder("1");

        for(int k = 1; k < n; k++) {
            StringBuilder s = new StringBuilder();
            char[] chars = buf.toString().toCharArray();
            char prev = chars[0];
            int count = 1;
            for(int i = 1; i < chars.length; i++) {            
                if(prev == chars[i]) {
                    count++;
                } else {
                    s.append(count);
                    s.append(prev);
                    count = 1;
                    prev = chars[i];
                }
            }
            s.append(count);
            s.append(prev);
            buf = s;
        }
        
        return buf.toString();
    }

    public static void main(String[] args) {
        int n = 5;

        CountAndSay solution = new CountAndSay();
        System.out.printf("[%d]: %s\n", n, solution.countAndSay(n));

    }
}