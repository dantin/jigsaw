import java.lang.ref.SoftReference;

/**
 * java -Xmx10m SoftRef
 */
public class SoftRef {
    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("[id=%d, name=%s]", id, name);
        }
    }

    public static void main(String[] args) {
        User u = new User(1, "david");
        SoftReference<User> userSoftRef = new SoftReference<>(u);
        u = null;

        System.out.println(userSoftRef.get());
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftRef.get());

        byte[] b = new byte[1024 * 925 * 7];
        System.gc();
        System.out.println(userSoftRef.get());
    }
}