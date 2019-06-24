package xin.jerome.study.datastructures.stack;

import xin.jerome.study.datastructures.stack.impl.MyArrayStack;
import xin.jerome.study.datastructures.stack.impl.MyLinkedListStack;

import java.util.Random;

/**
 * 测试自定义栈的功能性
 *
 * @author Jerome Zhu
 * @since 2019.06.03 16:11
 */
public class TestMyStack {
    public static void main(String[] args) {
        MyArrayStack<Integer> myArrayStack = new MyArrayStack<>();
        MyLinkedListStack<Integer> myLinkedListStack = new MyLinkedListStack<>();
//        testMyStack(myArrayStack);
//        testMyStack(myLinkedListStack);
        int opCount = 10000000;
        double arrayStack = testMyStackPerformance(myArrayStack,opCount);
        System.out.println("ArrayStack, time:" + arrayStack + "s");
        double linkedListStack = testMyStackPerformance(myLinkedListStack, opCount);
        System.out.println("LinkedListStack, time:" + linkedListStack + "s");
    }


    /**
     * 测试进行 opCount 个进栈出栈操作所需时间
     *
     * @param stack   {@link MyStack}的实现类
     * @param opCount 操作次数
     * @return 花费的时间
     */
    public static Double testMyStackPerformance(MyStack<Integer> stack, int opCount) {
        // 纳秒值
        Long startTime = System.nanoTime();
        Random random = new Random();
        // 进栈操作
        System.out.println("push ...");
        for (int i = 0; i < opCount; i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        // 出栈操作
        System.out.println("pop ...");
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        Long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * 测试{@link MyStack}功能
     */
    private static void testMyStack(MyStack stack) {
        for (int i = 0; i < 6; i++) {
            stack.push(i);
        }
        stack.pop();
        System.out.println(stack);
    }
}
