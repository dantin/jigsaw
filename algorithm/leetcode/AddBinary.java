public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder buf = new StringBuilder();
        int sum = 0;
        int ia = a.length();
        int ib = b.length();

        while(ia >0 || ib >0 || sum > 0) {
            int n1 = 0;
            int n2 = 0;

            if(ia > 0) n1 = Character.getNumericValue(a.charAt(--ia));
            if(ib > 0) n2 = Character.getNumericValue(b.charAt(--ib));

            sum += n1 + n2;
            buf.append(sum % 2);
            sum /= 2;
        }
        return buf.reverse().toString();
    }
    

    public static void main(String[] args) {
        String a = "11";
        String b = "1";

        AddBinary solution = new AddBinary();
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("s = " + solution.addBinary(a, b));
    }
}