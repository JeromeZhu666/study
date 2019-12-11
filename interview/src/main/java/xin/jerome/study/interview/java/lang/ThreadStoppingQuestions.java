package xin.jerome.study.interview.java.lang;

import org.junit.Test;

/**
 * 线程终止相关问题
 *   1.如何停止一个线程
 *     {@link ThreadStoppingQuestions#testHowToStopThread()}
 *   2.为什么会废弃 {@link Thread#stop()} 方法
 *     {@link ThreadStoppingQuestions#whyIsStopMethodDeprecated()}
 *
 * @author Jerome Zhu
 * @since 2019年12月11日 17:46
 */
public class ThreadStoppingQuestions {

    @Test
    public void testHowToStopThread() throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable,"T1");
        // 通知线程启动
        t1.start();
        // 设置终止开关为
        myRunnable.setStopped(true);
        // 线程必须执行完成
        t1.join();


        Thread t2 = new Thread(()-> {
            if(!Thread.currentThread().isInterrupted()) {
                action();
            }
        },"T2");
        // 通知线程启动
        t2.start();
        // 设置线程中断状态为 true (仅仅设置状态，而并非中止线程）
        t2.interrupt();
        // 线程必须执行完成
        t2.join();
    }

    /** 带有自定义开关的 {@link Runnable} 接口的实现 */
    private static class MyRunnable implements Runnable {
        private volatile boolean stopped = false;
        @Override
        public void run() { if(!stopped) action();}
        public void setStopped(boolean stopped) { this.stopped = stopped;}
    }

    /**
     * 为什么会废弃 {@link Thread#stop()} 方法 :
     *   因为 stop 方法 有安全问题,停止线程会使它解锁它已锁定的所有监视器,导致状态不一致的问题.
     *   <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/concurrency/threadPrimitiveDeprecation.html">
     *       Why are Thread.stop, Thread.suspend and Thread.resume Deprecated?</a>
     */
    @Test
    public void whyIsStopMethodDeprecated() {}


    @Test
    public void explainInterrupt() {
        Thread t1 = new Thread(ThreadStoppingQuestions::action,"T1");
        // 返回中断状态,不清除状态;如果没设置过 interrupted 返回 false.
//        System.out.println(t1.isInterrupted());
        // 设置中断状态
        t1.interrupt();
        System.out.println(t1.isInterrupted());

        System.out.println(Thread.interrupted());

        System.out.println(t1.isInterrupted());
    }



    /**
     * 打印当前正在运行的线程
     */
    private static void action() {
        System.out.printf("线程[%s] 正在运行... \n", Thread.currentThread().getName());
    }
}
