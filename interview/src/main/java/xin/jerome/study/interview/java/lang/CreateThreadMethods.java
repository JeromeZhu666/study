package xin.jerome.study.interview.java.lang;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.Test;

/**
 * 创建线程的有几种方式
 *
 * @author zhu shaojie
 * @since 2019年12月10日 17:19
 */
public class CreateThreadMethods {

    /**
     * 创建线程的方法，有且只有一种
     */
    @Test
    public void testCreateThreadMethod() {
        // main 线程 -> 子线程
        Thread thread = new Thread(()->{},"子线程");
    }

    /**
     * 运行线程的方式 : 通过线程实例调用 {@link Thread#start()} 方法
     */
    @Test
    public void testRunThreadByImplementsRunnable () {
        Thread thread = new Thread(()->{},"子线程");
    }

    /**
     * 运行线程的方式 : 通过继承Thread类,重写 {@link Thread#run()} 方法
     * 运行时还是调用 {@link Thread#start()} 方法,由 {@link Thread#start0()} 通过 JVM 来调用 run 方法
     */
    @Test
    public void testRunThreadByThreadSubClass () {
        MyThread myThread = new MyThread();
    }

    /**
     * 运行线程的方式 : 通过线程池 {@link ThreadPoolExecutor#execute(java.lang.Runnable)} 方法
     * 会将任务通过 {@link ThreadPoolExecutor#addWorker(Runnable, boolean)} 方法加入到任务队列,
     * 只后再由{@link ThreadPoolExecutor.Worker#Worker(java.lang.Runnable)} 内嵌类调用工厂方法创建线程对象.
     *
     */
    @Test
    public void testRunThreadByThreadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        threadPoolExecutor.execute(()->{});
    }


    private class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
        }
    }
}
