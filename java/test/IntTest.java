import java.lang.reflect.Field;

public class IntTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        method(a, b);
        System.out.println("a = " + Integer.valueOf(a));
        System.out.println("b = " + Integer.valueOf(b));
    }

    private static void method(Integer a, Integer b) {
        try {
            Field value = a.getClass().getDeclaredField("value");
            value.setAccessible(true);
            value.setInt(a, 100);

            value = b.getClass().getDeclaredField("value");
            value.setAccessible(true);
            value.setInt(b, 200);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}