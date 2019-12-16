package xin.jerome.study.interview.java.lang.thread;

import org.junit.Test;

import java.util.Arrays;

/**
 * 线程退出相关问题
 *   1.当主线程退出时，守候子线程会执行完毕吗?
 *     {@link ThreadExitQuestions#testMainThreadExitSubThreadExecuteOrNot()}
 *   2.请说明Sthutdown Hook线程的使用场景, 以及如何触发执行?
 *     {@link ThreadExitQuestions#testShutdownHook()}
 *   3.如何确保在主线程退出前, 所有线程执行完毕?
 *     {@link ThreadExitQuestions#testMainThreadExitBeforeAllThreadComplete()}
 *
 * @author Jerome Zhu
 * @since 2019年12月12日 21:39
 */
public class ThreadExitQuestions {

    /**
     * 1.当主线程退出时，守候子线程会执行完毕吗?
     *   不一定，守护线程的执行依赖于执行时间
     */
    @Test
    public void testMainThreadExitSubThreadExecuteOrNot() {
        Thread daemon = new Thread(ThreadExitQuestions::action,"daemon");
        daemon.setDaemon(true); // 设置守护线程
        daemon.start();
    }

    /**
     * Sthutdown Hook线程的使用场景 :
     *    1.Spring Bean 的销毁.
     */
    @Test
    public void testShutdownHook() {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(ThreadExitQuestions::action,"shutdown hook"));
    }

    /**
     * 如何确保在主线程退出前, 所有线程执行完毕?
     */
    @Test
    public void testMainThreadExitBeforeAllThreadComplete() throws InterruptedException {
        // 子线程如果不指定线程组，默认加到父线程的线程组中
        Thread t1 = new Thread(ThreadExitQuestions::action, "t1");
        Thread t2 = new Thread(ThreadExitQuestions::action, "t2");
        Thread t3 = new Thread(ThreadExitQuestions::action, "t3");

        // 不确定 t1、t2、t3 是否调用 start()
        t1.start();
        t2.start();
        t3.start();

        // 创建了 N Thread
        Thread mainThread = Thread.currentThread();
        // 获取 main 线程组
        ThreadGroup threadGroup = mainThread.getThreadGroup();
        // 活跃的线程数
        int count = threadGroup.activeCount();
        Thread[] threads = new Thread[count];
        // 把所有的线程复制 threads 数组
        threadGroup.enumerate(threads, true);
        // 查看线程组中所有活跃的线程
        for (Thread thread : threads) {
            System.out.printf("当前活跃线程: %s, 线程状态: %s\n", thread.getName(), thread.getState());
            // Monitor Ctrl-Break 使由 IntelliJ IDEA 创建的监视线程
            if(!"main".equalsIgnoreCase(thread.getName()) && !"Monitor Ctrl-Break".equalsIgnoreCase(thread.getName())) {
                while (!"TERMINATED".equals(thread.getState().toString())){
                    System.out.printf("当前活跃线程: %s, 线程状态: %s\n", thread.getName(), thread.getState());
                    Thread.sleep(0);
                }
            }
        }
    }

    /**
     * 打印当前正在运行的线程
     */
    private static void action() {
        Thread t = Thread.currentThread();
        System.out.printf("线程[name : %s, isDaemon : %s] 正在运行... \n", t.getName(), t.isDaemon());
    }
}
