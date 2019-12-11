package xin.jerome.study.interview.java.lang;

import java.security.AccessControlContext;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.junit.Test;

/**
 * 线程创建问题
 *   1.创建线程的方法
 *
 * @author Jerome Zhu
 * @since 2019年12月10日 17:19
 */
public class ThreadCreationQuestions {

    /**
     * 创建线程的方法 : 有且只有一种 : 通过构造方法调用私有的
     * {@link Thread#init(ThreadGroup, Runnable, String, long, AccessControlContext, boolean)}  方法
     */
    @Test
    public void testCreateThreadMethod() {
        // main 线程 -> 子线程
        Thread thread = new Thread(()->{},"子线程");
    }

}
