import java.util.ArrayList;
import java.util.List;

public class ConstructionMethodRef {

    @FunctionalInterface
    interface UserFactory<U extends User> {
        U create(int id, String name);
    }

    static UserFactory<User> uf = User::new;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(uf.create(i, "billy" + i));
        }
        users.stream().map(User::getName).forEach(System.out::println);
    }
}

class User {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}