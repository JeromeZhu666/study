package xin.jerome.study.javabasic.lang.thread;

import java.lang.Thread.State;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * 线程状态
 *
 * @author Jerome Zhu
 * @since 2019年12月19日 15:33
 */
public class ThreadState {

    /**
     * 线程的状态
     *   NEW : 线程已创建,尚未启动. 此时系统的线程已经创建好了,因为创建线程时会设置优先级
     *      {@link Thread#setPriority0(int)}
     *   RUNNABLE : 表示线程处于可运行状态,不代表一定运行.
     *   BLOCKED : 被Monitor锁阻塞，表示当前线程在同步锁的场景运作.
     *   WAITING : 线程处于等待状态，由Object#wait()、Thread#join() 或LockSupport#park()引起.
     *   TIMED_WAITING : 线程处于规定时间内的等待状态, 由Object#wait(long)、Thread#join(long)、
     *      Thread#sleep、LockSupport#parkNanos 或 LockSupport#parkUntil 引起.
     *   TERMINATED : 线程执行结束(正常退出 或 异常退出), 线程没有消亡, 需要等待GC.
     */
    @Test
    public void testThreadState() {
        System.out.println(State.NEW);
        System.out.println(State.RUNNABLE);
        System.out.println(State.BLOCKED);
        System.out.println(State.WAITING);
        System.out.println(State.TIMED_WAITING);
        System.out.println(State.TERMINATED);
    }

    /**
     * 查看线程状态的方式
     *   1.通过 {@code jstack PID}
     *   2.通过 JMX {@link ThreadMXBean#dumpAllThreads(boolean, boolean)} 的方法
     *   3.通过 {@link Thread#dumpStack()} API 的方式 , 输入的是标准的错误流.
     *   4.通过模仿 {@link Thread#dumpStack()} 方法的实现 , 自定义输入到标准的输出流.
     */
    @Test
    public void testCheckThreadState() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        Stream.of(threadInfos)
            .filter(threadInfo -> "main".equals(threadInfo.getThreadName()))
            .forEach(System.out::println);

        System.out.println("------------------------------");
        // Thread 内建实现
        Thread.dumpStack();

        System.out.println("------------------------------");
        // 模仿 Thread#dumpStack() 的实现
        new Throwable("My stack trace").printStackTrace(System.out);
    }
}
