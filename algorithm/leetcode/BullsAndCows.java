public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int[] cache = new int[10];

        int bull = 0;
        int cow = 0;
        char[] sa = secret.toCharArray();
        char[] ga = guess.toCharArray();

        for(int i = 0; i < sa.length; i++) {
            if((sa[i] ^ ga[i]) == 0) bull++;
            cache[sa[i] - '0']++;
        }

        for(char c : ga) {
            if(cache[c - '0']-- > 0) cow++;
        }
        return String.format("%dA%dB", bull, cow - bull);
    }

    public static void main(String[] args) {
        String secret = "1123";
        String guess  = "0111";

        BullsAndCows solution = new BullsAndCows();
        System.out.println("Secret number:  " + secret);
        System.out.println("Friend's guess: " + guess);
        System.out.println("Hint: " + solution.getHint(secret, guess));
    }
}