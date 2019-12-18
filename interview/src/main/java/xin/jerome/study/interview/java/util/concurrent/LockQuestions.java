package xin.jerome.study.interview.java.util.concurrent;

import java.util.concurrent.locks.ReentrantLock;
import org.junit.Test;

/**
 * JUC 锁相关问题
 *   1.请说明ReentrantLock与ReentrantReadWriteLock的区别?
 *     {@link LockQuestions#testCompareReentrantLockAndReentrantReadWriteLockDistinction()}
 *   2.请解释ReentrantLock为什么命名为重进入?
 *     {@link LockQuestions#testReentrantLockNaming()}
 *   3.请说明Lock#lock()与Lock#lockInterruptibly()的区别?
 *     {@link LockQuestions#testLockMethodAndLockInterruptiblyDistinction()}
 *
 * @author Jerome Zhu
 * @since 2019年12月18日 15:50
 */
public class LockQuestions {

    /**
     * todo 请说明ReentrantLock与ReentrantReadWriteLock的区别?
     */
    @Test
    public void testCompareReentrantLockAndReentrantReadWriteLockDistinction() {
    }

    /**
     * 2.请解释ReentrantLock为什么命名为重进入?
     * {@link ReentrantLock.Sync#nonfairTryAcquire(int)} : 首先判断当前锁的状态，如果为0,表示没有线程拿到锁，这时
     * 记录当前线程对象 状态 + 1 ; 当线程再次进入时,如果是持有锁的线程,则状态 + 1，若不是加入等待队列.
     *
     */
    @Test
    public void testReentrantLockNaming() {
        // 默认是非公平的
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            reentrantLock.lock();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * todo 请说明Lock#lock()与Lock#lockInterruptibly()的区别?
     */
    @Test
    public void testLockMethodAndLockInterruptiblyDistinction() {
        // 默认是非公平的
        ReentrantLock reentrantLock = new ReentrantLock();
        try {
            // 如果线程的中断状态 ， 状态会被清空
            reentrantLock.lockInterruptibly();
        } catch (InterruptedException e) {
            // 显示的恢复状态
            Thread.currentThread().interrupt();
        } finally {
            reentrantLock.unlock();
        }
    }

}
