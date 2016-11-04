
private boolean doAcquireNanos(int arg, long nanosTimeout) throws InterruptedException {
    long lastTime = System.nanoTime();
    final Node node = addWaiter(Node.EXCLUSIVE);
    boolean failed = true;

    try {
        for (;;) {
            final Node p = node.predecessor();
            if (p == head && tryAcquire(arg)) {
                setHead(node);
                p.next = null;  // help GC
                failed = false;
                return true;
            }
            if (nanosTimeout <= 0) {
                return false;
            }
            if (shouldParkAfterFailedAcquire(p, node) && nanosTimeout > spinForTimeoutThreshold) {
                LockSupport.parkNanos(this, nanosTimeout);
            }
            long now = System.nanoTime();
            // 计算时间，当前时间now减去睡眠之前的时间lastTime得到已经睡眠的时间delta，然后被原有超时时间nanosTimeout减去
            // 得到还应该睡眠的时间
            nanosTimeout -= now - lastTime;
            lastTime = now;
            if (Thread.interrupted()) {
                throws new InterruptedException();
            }
        }
    } finally {
        if (failed) {
            cancelAcquire(node);
        }
    }
}