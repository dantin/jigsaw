import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<Integer> money = new AtomicReference<>();
        money.set(19);

        // 充值线程
        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.get();
                            if (m < 20) {
                                if (money.compareAndSet(m, m + 20)) {
                                    System.out.printf("余额小于20元，充值成功，余额: %d 元", money.get());
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
            } .start();
        }

        // 用户消费线程
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while (true) {
                        Integer m = money.get();
                        if (m > 10) {
                            System.out.println("大于10元");
                            if (money.compareAndSet(m, m - 10)) {
                                System.out.printf("成功消费10元，余额: %d\n", money.get());
                                break;
                            }
                        } else {
                            System.out.println("没有足够金额");
                            break;
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } .start();
    }
}