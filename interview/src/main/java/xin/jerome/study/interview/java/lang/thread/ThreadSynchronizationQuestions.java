package xin.jerome.study.interview.java.lang.thread;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步相关问题
 *   1.请说明synchronized 关键字在修饰方法与代码块中的区别?
 *      {@link ThreadSynchronizationQuestions#testSynchronizedModificationMethodsAndCodeBlockDistinction()}
 *   2.请说明synchronized 关键字与ReentrantLock之间的区别?
 *      {@linkplain ThreadSynchronizationQuestions#testSynchronizedModificationMethodsAndCodeBlockDistinction()}
 *   3.请解释偏向锁对synchronized与ReentrantLock的价值?
 *      优化了synchronized 在无竞争状态下的性能问题,{@link ReentrantLock.Sync#nonfairTryAcquire(int)}默认实现了偏向锁.
 *
 *
 * @author Jerome Zhu
 * @since 2019年12月12日 21:27
 */
public class ThreadSynchronizationQuestions {

    /**
     * 请说明synchronized 关键字在修饰方法与代码块中的区别?
     * 只有字节码上的区别 :
     *   1.修饰在方法上 : 多了一个访问修饰状态 {@code ACC_SYNCHRONIZED}
     *      {@link SynchronizedOnMethodsAndCodeBlock#synchronizedMethod()}
     *   2.修饰在代码块上 : 方法体内的字节码多了 monitor 监视器
     *      {@link SynchronizedOnMethodsAndCodeBlock#synchronizedBlock()}
     */
    @Test
    public void testSynchronizedModificationMethodsAndCodeBlockDistinction() {
    }

    /**
     * 请说明synchronized关键字与ReentrantLock之间的区别?
     * 锁的实现 : synchronized关键字是依赖JVM的实现;ReentrantLock是依赖Java 1.5提供{@link Lock}API实现.
     * 可重入性 : 两者都具有可重性,同一个线程每进入一次,锁计数器自增1,直到计数器为0时释放锁.
     * 性能差别 : 在 synchronized 引入偏向锁、轻量级锁(自旋锁)后,两者的性能就差不多了.
     * 在使用上 : synchronized使用简单,由JVM去实现加锁和释放锁;ReentrantLock需手动加锁,防止死锁就必须将unLock()放到finally{}中.
     * ReenTrantLock独有的能力：
     *   1)ReenTrantLock可以指定是公平锁还是非公平锁.而synchronized只能是非公平锁.所谓的公平锁就是先等待的线程先获得锁.
     *   2)ReenTrantLock提供了一个Condition（条件）类,用来实现分组唤醒需要唤醒的线程们,
     *     而不是像synchronized要么随机唤醒一个线程要么唤醒全部线程.
     *   3)ReenTrantLock提供了一种能够中断等待锁的线程的机制,通过lock.lockInterruptibly()来实现这个机制.
     */
    @Test
    public void testSynchronizedKeyWordAndReentrantLockDistinction() {
    }

}
