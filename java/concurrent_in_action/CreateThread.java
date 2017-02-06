public class CreateThread implements Runnable {
    public static void main(String[] args) {
        Thread t = new Thread(new CreateThread());
        t.start();
    }

    @Override
    public void run() {
        System.out.println("I'm a runnable.");
    }
}