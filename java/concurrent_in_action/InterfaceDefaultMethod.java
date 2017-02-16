public class InterfaceDefaultMethod {
    public static void main(String[] args) {
        Mule m = new Mule();
        m.run();
        m.breath();
    }

}

interface IAnimal {
default void breath() {
        System.out.println("breath");
    }
}

interface IHorse {
    void eat();

default void run() {
        System.out.println("horse run");
    }
}

class Mule implements IHorse, IAnimal {
    @Override
    public void eat() {
        System.out.println("Mule eat");
    }
}