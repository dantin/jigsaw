public class Finally {
    public static void main(String[] args) {
        System.out.println(x());
        System.out.println(sb());
        System.out.println(str());
    }

    private static int x() {
        int i = 0;

        try {
            i = 5;
            return i;
        } finally {
            i = 10;
        }
    }

    private static StringBuffer sb() {
        StringBuffer sb = new StringBuffer("");

        try {
            sb = new StringBuffer("a");
            return sb;
        } finally {
            sb.append("b");
        }
    }

    private static String str() {
        String s = "";

        try {
            s = "a";
            return s;
        } finally {
            s = "a" + "b";
        }
    }
}