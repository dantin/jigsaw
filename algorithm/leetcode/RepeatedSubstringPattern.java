public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() == 0) return false;

        int total = str.length();
        int i = 1;
        int k = 0;
        while(i <= total / 2) {
            if(total % i == 0) {
                k = total / i;
                String pattern = str.substring(0, i);
                StringBuilder sb = new StringBuilder();

                for(int j = 0; j < k; j++) {
                    sb.append(pattern);
                }
                if(str.equals(sb.toString())) return true;
            }
            i++;
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "babbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabbbabbbbaabb";

        RepeatedSubstringPattern solution = new RepeatedSubstringPattern();
        System.out.println("Input:  " + s);
        System.out.println("Output: " + solution.repeatedSubstringPattern(s));
    }
}