package xin.jerome.study.interview.java.util;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import org.junit.Test;

/**
 * 线程安全Queue相关问题
 *   1.请说明BlockingQueue与Queue的区别?
 *     {@link ThreadSafeQueueQuestions#testCompareBlockingQueueAndQueueDistinction()}
 *   2.请说明LinkedBlockingQueue 与ArrayBlockingQueue 的区别?
 *     {@link ThreadSafeQueueQuestions#testCompareLinkedBlockingQueueAndArrayBlockingQueueDistinction()}
 *   3.请说明LinkedTransferQueue与LinkedBlockingQueue的区别?
 *     {@link ThreadSafeQueueQuestions#testCompareLinkedTransferQueueAndLinkedBlockingQueueDistinction()}
 *
 * @author Jerome Zhu
 * @since 2019年12月18日 12:40
 */
public class ThreadSafeQueueQuestions {

    /**
     * 1.请说明BlockingQueue与Queue的区别?、
     *   BlockingQueue 实现了 Queue , {@link BlockingQueue#put(java.lang.Object)} 当队列满时会阻塞
     */
    @Test
    public void testCompareBlockingQueueAndQueueDistinction() {
    }

    /**
     * 2.请说明LinkedBlockingQueue 与ArrayBlockingQueue 的区别?
     *   1) LinkedBlockingQueue 链表结构 ; ArrayBlockingQueue 数组结构
     *   2）LinkedBlockingQueue 有边界默认 Integer.MAX_VALUE ; ArrayBlockingQueue 有边界
     */
    @Test
    public void testCompareLinkedBlockingQueueAndArrayBlockingQueueDistinction() {
    }

    /**
     * 3.请说明LinkedTransferQueue与LinkedBlockingQueue的区别?
     *   LinkedTransferQueue 是 Java7 提供的实现 , 性能上比 LinkedBlockingQueue 要好
     */
    @Test
    public void testCompareLinkedTransferQueueAndLinkedBlockingQueueDistinction() {
    }

    /**
     * 评估代码运行结果 :
     * @throws InterruptedException
     */
    @Test
    public void testPriorityBlockingQueue() throws InterruptedException {
        // 优先队列
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(2);
        queue.put(9);
        queue.put(1);
        // put 方法不阻塞，会自动扩容，有默认自然排序(siftUp)
        queue.put(8);
        System.out.println("queue.size() = " + queue.size()); // 猜想 3
        // 元素出队 数组中第一个 array[0];
        System.out.println("queue.take() = " + queue.take()); // 猜想 9
        System.out.println("queue = " + queue); // 猜想 1 8
        //queue.size() = 3
        //queue.take() = 1
        //queue = [8, 9]
    }
    /**
     * 评估代码运行结果 :
     * @throws InterruptedException
     */
    @Test
    public void testSynchronousQueue() throws InterruptedException {
        // 同步队列
        // 1. SynchronousQueue 是无空间，offer 永远返回 false
        // 2. SynchronousQueue take() 方法会被阻塞因为SynchronousQueue.TransferQueue#transfer
        //    必须被其他线程显示地调用 put(Object);
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
        System.out.println("queue.offer(1) = " + queue.offer(1)); // 猜想 true
        System.out.println("queue.offer(2) = " + queue.offer(2)); // 猜想 true
        System.out.println("queue.offer(3) = " + queue.offer(3)); // 猜想 true
        System.out.println("queue.take() = " + queue.take()); // 猜想 3
        System.out.println("queue.size = " + queue.size()); // 猜想
    }
    /**
     * 评估代码运行结果 :
     * @throws InterruptedException
     */
    @Test
    public void testOfferQueue() throws InterruptedException {
        // 有边界会阻塞
        offer(new ArrayBlockingQueue<>(2));
        offer(new LinkedBlockingQueue<>(2));
        // 有边界会自动扩容  不会阻塞
        offer(new PriorityBlockingQueue<>(2));
        // 会阻塞
        offer(new SynchronousQueue<>());
    }
    private void offer(BlockingQueue<Integer> queue) throws InterruptedException {
        System.out.println("queue.getClass() = " + queue.getClass().getName());
        System.out.println("queue.offer(1) = " + queue.offer(1));
        System.out.println("queue.offer(2) = " + queue.offer(2));
        System.out.println("queue.offer(3) = " + queue.offer(3));
        System.out.println("queue.size() = " + queue.size());
        System.out.println("queue.take() = " + queue.take());
    }

}
