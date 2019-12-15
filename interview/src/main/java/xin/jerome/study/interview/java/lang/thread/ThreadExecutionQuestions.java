package xin.jerome.study.interview.java.lang.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.Test;

/**
 * 线程执行相关问题
 *   1.运行线程的方式
 *     1) {@link ThreadExecutionQuestions#testThreadExecutionByImplementsRunnable()}
 *     2) {@link ThreadExecutionQuestions#testThreadExecutionByThreadSubClass()}
 *     3) {@link ThreadExecutionQuestions#testThreadExecutionByThreadPoolExecutor()}
 *   2.保证线程的运行顺序 T1 -> T2 -> T3
 *     1) {@link ThreadExecutionQuestions#testThreadExecutionOrderByJoinOneByOne()}
 *     2) {@link ThreadExecutionQuestions#testThreadExecutionOrderByThreadLoop()}
 *
 * @author Jerome Zhu
 * @since 2019年12月11日 16:10
 */
public class ThreadExecutionQuestions {

    /**
     * 运行线程的方式 : 通过线程实例调用 {@link Thread#start()} 方法
     */
    @Test
    public void testThreadExecutionByImplementsRunnable () {
        Thread thread = new Thread(ThreadExecutionQuestions::action,"子线程");
        thread.start();
    }

    /**
     * 运行线程的方式 : 通过继承Thread类,重写 {@link Thread#run()} 方法
     * 运行时还是调用 {@link Thread#start()} 方法,由 {@link Thread#start0()} 通过 JVM 来调用 run 方法
     */
    @Test
    public void testThreadExecutionByThreadSubClass () {
        MyThread myThread = new MyThread();
        myThread.start();
    }
    private static class MyThread extends Thread {
        @Override
        public void run() {
            ThreadExecutionQuestions.action();
            super.run();
        }
    }

    /**
     * 运行线程的方式 : 通过线程池 {@link ThreadPoolExecutor#execute(java.lang.Runnable)} 方法
     * 会将任务通过 {@link ThreadPoolExecutor#addWorker(Runnable, boolean)} 方法加入到任务队列,
     * 只后再由{@link ThreadPoolExecutor.Worker#Worker(java.lang.Runnable)} 内嵌类调用工厂方法创建线程对象.
     *
     */
    @Test
    public void testThreadExecutionByThreadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        threadPoolExecutor.execute(ThreadExecutionQuestions::action);
    }

    /**
     * 保证线程的运行顺序 : 保证线程T1,T2,T3运行顺序为 T1 -> T2 -> T3
     */
    @Test
    public void testThreadExecutionOrderBefore() throws InterruptedException {
        Thread t1 = new Thread(ThreadExecutionQuestions::action,"T1");
        Thread t2 = new Thread(ThreadExecutionQuestions::action,"T2");
        Thread t3 = new Thread(ThreadExecutionQuestions::action,"T3");
        // start() 仅是通知线程启动 : 每次执行的结果都不同
        t1.start();
        t2.start();
        t3.start();
        // join() 控制线程必须执行完成
        t1.join();
        t2.join();
        t3.join();
    }

    /**
     * 保证线程T1,T2,T3运行顺序为 T1 -> T2 -> T3. 最稳定的方式(一个一个来)
     */
    @Test
    public void testThreadExecutionOrderByJoinOneByOne() throws InterruptedException {
        Thread t1 = new Thread(ThreadExecutionQuestions::action,"T1");
        Thread t2 = new Thread(ThreadExecutionQuestions::action,"T2");
        Thread t3 = new Thread(ThreadExecutionQuestions::action,"T3");
        // start() 仅是通知线程启动 : 每次执行的结果都不同
        t1.start();
        // join() 控制线程必须执行完成
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }

    /**
     * 保证线程T1,T2,T3,T4运行顺序为 T1 -> T2 -> T3 -> T4. 线程自旋转
     */
    @Test
    public void testThreadExecutionOrderByThreadLoop() throws InterruptedException {
        Thread t1 = new Thread(ThreadExecutionQuestions::action,"T1");
        Thread t2 = new Thread(ThreadExecutionQuestions::action,"T2");
        Thread t3 = new Thread(ThreadExecutionQuestions::action,"T3");
        Thread t4 = new Thread(ThreadExecutionQuestions::action,"T4");

        t1.start();
        // 线程自转,啥也不干
        while (t1.isAlive()){}

        t2.start();
        // 线程自转,睡0毫秒
        while (t2.isAlive()){Thread.sleep(0);}

        t3.start();
        // 线程自转,利用 join() 方法的底层实现方法实现
        while (t3.isAlive()){
            synchronized (t3){
                t3.wait();
            }
        }

        t4.start();
    }


    /**
     * 打印当前正在运行的线程
     */
    private static void action() {
        System.out.printf("线程[%s] 正在运行... \n", Thread.currentThread().getName());
    }
}
