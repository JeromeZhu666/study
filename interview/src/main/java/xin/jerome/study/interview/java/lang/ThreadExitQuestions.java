package xin.jerome.study.interview.java.lang;

import org.junit.Test;

/**
 * 线程退出相关问题
 *   1.当主线程退出时，守候子线程会执行完毕吗?
 *     {@link ThreadExitQuestions#testMainThreadExitSubThreadExecuteOrNot()}
 *   2.请说明Sthutdown Hook线程的使用场景, 以及如何触发执行?
 *     {@link ThreadExitQuestions#testShutdownHook()}
 *   3.如何确保在主线程退出前, 所有线程执行完毕?
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

    @Test
    public void testShutdownHook() {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(ThreadExitQuestions::action,"shutdown hook"));
    }



    /**
     * 打印当前正在运行的线程
     */
    private static void action() {
        Thread t = Thread.currentThread();
        System.out.printf("线程[name : %s, isDaemon : %s] 正在运行... \n", t.getName(), t.isDaemon());
    }
}
