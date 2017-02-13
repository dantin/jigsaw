import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceDemo {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19, 0);
        
        // 充值线程
        for (int i = 0; i < 3; i++) {
            final int timestamp = money.getStamp();
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.getReference();
                            if (m < 20) {
                                if (money.compareAndSet(m, m + 20, timestamp, timestamp + 1)) {
                                    System.out.printf("余额小于20元，充值成功，余额: %d 元", money.getReference());
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
                        int timestamp = money.getStamp();
                        Integer m = money.getReference();
                        if (m > 10) {
                            System.out.println("大于10元");
                            if (money.compareAndSet(m, m - 10, timestamp, timestamp + 1)) {
                                System.out.printf("成功消费10元，余额: %d\n", money.getReference());
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