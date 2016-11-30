public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {

        if (version1 == null && version2 == null) return 0;
        if (version1 == null || version1.length() == 0) return -1;
        if (version2 == null || version2.length() == 0) return 1;

        int i1 = 0, i2 = 0;
        while (i1 != version1.length() || i2 != version2.length()) {
            int v1 = 0, v2 = 0;
            if (i1 != version1.length()) {
                int i = version1.indexOf(".", i1);
                v1 = (i == -1) ? Integer.parseInt(version1.substring(i1)) : Integer.parseInt(version1.substring(i1, i));
                i1 = (i == -1) ? version1.length() : i + 1;
            }

            if (i2 != version2.length()) {
                int i = version2.indexOf(".", i2);
                v2 = (i == -1) ? Integer.parseInt(version2.substring(i2)) : Integer.parseInt(version2.substring(i2, i));
                i2 = (i == -1) ? version2.length() : i + 1;
            }

            if (v1 < v2) return -1;
            if (v1 > v2) return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1";

        CompareVersionNumbers solution = new CompareVersionNumbers();
        String answer;
        switch (solution.compareVersion(version1, version2)) {
        case 1:
            answer = ">";
            break;
        case -1:
            answer = "<";
            break;
        default:
            answer = "=";
            break;
        }
        System.out.printf("%s %s %s\n", version1, answer, version2);
    }


}