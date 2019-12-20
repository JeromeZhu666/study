package xin.jerome.study.javabasic.lang.thread;

import org.junit.Test;

/**
 * todo 线程通讯
 *
 * @author Jerome Zhu
 * @since 2019年12月20日 17:44
 */
public class ThreadCommunication {

    @Test
    public void testThreadCommunication() {

    }

    /**
     * 打印当前正在运行的线程
     */
    private static void action() {
        System.out.printf("线程[%s] 正在运行... \n", Thread.currentThread().getName());
    }
}
