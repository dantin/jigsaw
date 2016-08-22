/**
 * 不要将获取锁的过程写在try块中，因为如果在获取锁（自定义锁的实现）时
 * 发生了异常，异常抛出的同时，也会导致锁无故释放。
 */
Lock lock = new ReentrantLock();
lock.lock();
try {
} finally {
    lock.unlock();
}