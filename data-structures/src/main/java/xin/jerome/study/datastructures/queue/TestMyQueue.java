package xin.jerome.study.datastructures.queue;

import xin.jerome.study.datastructures.queue.impl.MyArrayQueue;
import xin.jerome.study.datastructures.queue.impl.MyLinkedListQueue;
import xin.jerome.study.datastructures.queue.impl.MyLoopQueue;

import java.util.Random;

/**
 * 测试队列与循环队列的性能
 *
 * @author Jerome Zhu
 * @since 2018.10.25 22:52
 */
public class TestMyQueue {

    public static void main(String[] args) {
        MyArrayQueue<Integer> arrayQueue = new MyArrayQueue<>();
        MyLoopQueue<Integer> loopQueue = new MyLoopQueue<>();
        MyLinkedListQueue<Integer> linkedListQueue = new MyLinkedListQueue<>();
//        testQueue(arrayQueue);
//        testQueue(loopQueue);
//        testQueue(linkedListQueue);


        int opCount = 100000;

        double arrayQueueTime = testQueue(arrayQueue, opCount);
        System.out.println("MyArrayQueue, time:" + arrayQueueTime + "s");

        double loopQueueTime = testQueue(loopQueue, opCount);
        System.out.println("MyLoopQueue, time:" + loopQueueTime + "s");

        double linkedListQueueTime = testQueue(loopQueue, opCount);
        System.out.println("MyLinkedListQueue, time:" + linkedListQueueTime + "s");
    }

    /**
     * 测试进行 opCount 个进队出队操作所需时间
     *
     * @param queue   {@link MyQueue}的实现类
     * @param opCount 操作次数
     * @return 花费的时间
     */
    public static Double testQueue(MyQueue<Integer> queue, int opCount) {
        // 纳秒值
        Long startTime = System.nanoTime();

        Random random = new Random();
        System.out.println("add ...");
        for (int i = 0; i < opCount; i++)
            queue.add(random.nextInt(Integer.MAX_VALUE));

        System.out.println("remove ...");
        for (int i = 0; i < opCount; i++) {
            queue.remove();
        }

        Long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * 测试{@link MyQueue}功能
     */
    private static void testQueue(MyQueue<Integer> queue) {
        for (int i = 0; i < 10; i++) {
            queue.add(i);
            System.out.println(queue);
            if (i % 3 == 0) {
                Integer e = queue.remove();
                System.out.println(String.format("Integer : %d remove .", e));
            }
        }
    }
}
