public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder buf = new StringBuilder();

        while (n > 0) {
            char c = (char)('A' + (n - 1) % 26);
            buf.append(c);
            n = (n - 1) / 26;
        };

        return buf.reverse().toString();
    }

    public static void main(String[] args) {
        int n = 26;
        ExcelSheetColumnTitle solution = new ExcelSheetColumnTitle();
        System.out.printf("%d --> %s\n", n, solution.convertToTitle(n));
    }
}