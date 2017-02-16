public class InterfaceDefaultMethodResolve {
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

interface IDonkey {
    void eat();
default void run() {
        System.out.println("donkey run");
    }
}

class Mule implements IHorse, IDonkey, IAnimal {
    @Override
    public void run() {
        IHorse.super.run();
    }

    @Override
    public void eat() {
        System.out.println("Mule eat");
    }
}