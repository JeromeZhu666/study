package xin.jerome.study.interview.java.lang.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * 线程异常相关问题
 *   1.当线程发生异常时怎么捕获
 *     {@link ThreadExceptionQuestions#howToCatchThreadException()}
 *   2.线程池发生异常时怎么捕获
 *     {@link ThreadExceptionQuestions#howToCatchThreadPoolExecutorException()}
 *
 * @author Jerome Zhu
 * @since 2019年12月12日 15:35
 */
public class ThreadExceptionQuestions {

    /**
     * 当线程发生异常时怎么捕获
     */
    @Test
    public void howToCatchThreadException() {
        // 设置不被捕捉的异常处理
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.out.printf("线程[%s]发生了异常,详细信息: %s", thread.getName(), throwable.getMessage());
        });

        Thread t1 = new Thread(()-> {
            throw new RuntimeException("线程异常终止.");
        },"T1");
        t1.start();
    }

    /**
     * 可以捕获到信息,不会阻止到错误流中
     * @throws InterruptedException
     */
    @Test
    public void howToCatchThreadPoolExecutorException() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            1,
            1,
            0,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>()){
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.printf("线程[%s]发生了异常,详细信息: %s", Thread.currentThread().getName(), t.getMessage());
            }
        };

        executor.execute(()-> { throw new RuntimeException("线程异常终止.");});

        // 等待一秒
        executor.awaitTermination(1, TimeUnit.SECONDS);
        // 关闭
        executor.shutdown();
    }
}
