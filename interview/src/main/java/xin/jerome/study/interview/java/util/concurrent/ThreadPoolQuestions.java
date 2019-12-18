package xin.jerome.study.interview.java.util.concurrent;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * JUC 线程池相关问题
 *   1.请问JUC中内建了几种ExecutorService实现?
 *     {@link ThreadPoolQuestions#testHowManyImplementationExecutorService()}
 *   todo 2.请分别解释Thread PoolExecutor构造器参数在运行时的作用?
 *   3.如何获取Thread PoolExecutor正在运行的线程?
 *
 * @author Jerome Zhu
 * @since 2019年12月18日 19:25
 */
public class ThreadPoolQuestions {

    /**
     * JUC中内建了几种ExecutorService实现?
     *   Java 5:
     *     {@link ThreadPoolExecutor}
     *     {@link ScheduledThreadPoolExecutor}
     *   Java 7:
     *     {@link ForkJoinPool}
     */
    @Test
    public void testHowManyImplementationExecutorService() {
    }
}
