package xin.jerome.study.javabasic.lang.thread;

import org.junit.Test;

/**
 * 线程的生命周期
 *
 * @author Jerome Zhu
 * @since 2019年12月19日 17:25
 */
public class ThreadLifecycle {

    /**
     * 线程的生命周期
     *   1.启动 - {@link Thread#start()} 通知线程启动.
     *   2.停止 - {@link Thread#stop()} 停止线程,会给当前线程解锁,导致状态不一致.
     *   3.暂停 - {@link Thread#suspend()} 暂停线程,如果当前线程获取到了锁对象,会导致死锁.
     *   4.恢复 - {@link Thread#resume()}
     *   5.中止 - {@link Thread#interrupt()} 设置线程为中断状态.
     *            {@link Thread#isInterrupted()} 判断线程是否为中断状态,不清除中断状态.
     *            {@link Thread#interrupted()} 判断线程是否为中断状态,清除中断状态.
     * ps:<a href="https://docs.oracle.com/javase/8/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html">
     *     Why are Thread.stop, Thread.suspend and Thread.resume Deprecated?</a>
     */
    @Test
    public void testThreadLifecycle() {
    }

    /**
     * 中断线程的运行
     */
    @Test
    public void testStopThread() throws InterruptedException {
        Thread stoppableThread = new Thread(ThreadLifecycle::action,"stoppableThread");
        // 通知线程启动
        stoppableThread.start();
        // 设置线程的中断状态
        stoppableThread.interrupt();
        // 等待线程执行完毕
        stoppableThread.join();
    }

    /**
     * 打印当前正在运行的线程
     */
    private static void action() {
        if (Thread.currentThread().isInterrupted()) {
            System.out.printf("线程[%s] 被中断... \n", Thread.currentThread().getName());
            return;
        }
        System.out.printf("线程[%s] 正在运行... \n", Thread.currentThread().getName());
    }
}
