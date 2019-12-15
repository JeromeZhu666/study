package xin.jerome.study.interview.java.lang.thread;

import java.lang.Thread.State;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * 线程状态相关问题
 *   1.线程都有哪些状态,都代表什么含义
 *     {@link ThreadStateQuestions#threadStateMeaning()}
 *   2.怎么查看当前JVM的所有状态
 *     {@link ThreadStateQuestions#viewJavaVirtualMachineAllThreadState()}
 *
 *
 * @author Jerome Zhu
 * @since 2019年12月12日 17:11
 */
public class ThreadStateQuestions {

    /**
     * 1.线程都有哪些状态,都代表什么含义
     *   1) {@link State#NEW} 线程刚创建好,表示还未启动.
     *   2) {@link State#RUNNABLE} 线程可以执行的状态,表示线程正在 Java 虚拟机中执行 或 等待系统资源.
     *   3) {@link State#BLOCKED} 线程处于阻塞状态,表示线程等待锁的释放、进入同步代码 或 重新进入同步代码.
     *   4) {@link State#WAITING} 线程处于等待状态,直到被通知(notify、notifyAll、join).
     *   5) {@link State#TIMED_WAITING} 线程处于时间等待状态,由于主动调用(sleep(),wait(long),join(long))等方法.
     *   6) {@link State#TERMINATED} 线程处于终止状态,线程已经执行完成(正常或异常).
     */
    @Test
    public void threadStateMeaning() {}

    /**
     * 怎么查看当前JVM的所有状态
     *   1) 通过命令 {@code jstack PID} 查看
     */
    @Test
    public void viewJavaVirtualMachineAllThreadState() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] allThreadIds = threadMXBean.getAllThreadIds();
        ThreadInfo[] threadInfo = threadMXBean.getThreadInfo(allThreadIds);
        Stream.of(threadInfo).forEach((tf)->{
            long threadId = tf.getThreadId();
            System. out. printf("线程[ID:%d]\n",threadId);
            System. out. printf("线程[ID:%d]\n",threadId);
        });
    }

}
