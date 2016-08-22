////////////////////////////////////////
//
// 获取锁相关
//
////////////////////////////////////////

public final void acquire(int arg) {
    if (!tryAcquire(arg) &&  // 同步状态获取
            acquireQueued(addWaiter(Node.EXECLUSIVE) /* 构造节点、加入同步队列 */, arg)) // 在同步队列中自旋
        selfInterrupt();
}

/**
 * 构造节点，加入同步队列
 */
private Node addWaiter(Node mode) {
    Node node = new Node(Thread.currentThread(), mode);
    // 快速尝试在尾部添加
    Node pred = tail;
    if (pred != null) {
        node.prev = pred;
        if (compareAndSetTail(pred, node)) {
            pred.next = node;
            return node;
        }
    }
    enq(node);
    return node;
}

private Node enq(final Node node) {
    for (;;) {
        Node t = tail;
        if (t == null) { // Must initialize
            if (compareAndSetHead(new Node())) {
                tail = head;
            }
        } else {
            node.prev = t;
            if (compareAndSetTail(t, node)) {
                t.next = node;
                return t;
            }
        }
    }
}

/**
 * 只是在前驱节点是头节点的时候才去获取锁，减少竞争
 */
final boolean acquireQueued(final Node node, int arg) {
    boolean failed = true;
    try {
        boolean interrupted = false;
        for (;;) {
            final Node p = node.predecessor();
            if (p == head && tryAcquire(arg)) {
                setHead(node);
                p.next = null; // help GC
                failed = false;
                return interrupted;
            }
            if (shouldParkAfterFailedAcquire(p, node) && parkAndCheckInterrupt()) {
                interrupted = ture;
            }
        }
    } finally {
        if (failed) {
            cancelAcquire(node);
        }
    }
}


////////////////////////////////////////
//
// 释放锁相关
//
////////////////////////////////////////

public final boolean release(int arg) {
    if (tryRelease(arg)) {
        Node h = head;
        if (h != null && h.waitStatus != 0) {
            unparkSuccessor(h);
        }
        return true;
    }
    return false;
}
