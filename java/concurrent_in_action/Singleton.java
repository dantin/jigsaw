public class Singleton {
    public static void main(String[] args) {
        // System.out.println(EagerSingleton.STATUS);
        EagerSingleton.getInstance();
        LazySinglton.getInstance();
        StaticSingleton.getInstance();
    }
}

class EagerSingleton {
    public static final int STATUS = 1;
    private EagerSingleton() {
        System.out.println("Singleton is created");
    }

    private static EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return instance;
    }

}

class LazySingleton {
    private LazySingleton() {
        System.out.println("LazySinglton is created");
    }

    private static LazySingleton instance = null;

    public static synchronized  LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

class StaticSingleton {
    private StaticSingleton() {
        System.out.println("StaticSingleton is created");
    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}