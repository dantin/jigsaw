public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum *= 26;
            sum += s.charAt(i) - 'A' + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber solution = new ExcelSheetColumnNumber();
        System.out.println(solution.titleToNumber("AB"));
    }
}