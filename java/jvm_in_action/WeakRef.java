import java.lang.ref.WeakReference;

public class WeakRef {
    public static class User {
        public int id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return String.format("[id=%d, name=%s]", id, name);
        }
    }

    public static void main(String[] args) {
        User u = new User(1, "david");
        WeakReference<User> userWeakRef = new WeakReference<>(u);
        u = null;
        System.out.println(userWeakRef.get());
        System.gc();
        System.out.println("After GC:");
        System.out.println(userWeakRef.get());
    }
}