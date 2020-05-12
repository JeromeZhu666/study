package xin.jerome.study.algorithms.leetcode.stack;

import java.util.LinkedList;

/**
 * 155. 最小栈
 * 设计一个支持 push, pop, top 操作, 并能在常数时间内检索到最小元素的栈.
 * 
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   // 返回 -3.
 * minStack.pop();
 * minStack.top();      // 返回 0.
 * minStack.getMin();   // 返回 -2.
 *
 * @author JeromeSoar
 * @since 2020年05月12日 22:06
 */
public class LeetCode0155 {

    /**
     * 暴力实现最小栈: 获取最小元素时, 遍历查找.
     * MinStack#getMin() 时间复杂度 O(n) 空间复杂度 O(n) 1513 ms  43.5 MB
     */
    class MinStack {
        private LinkedList<Integer> elementContainer;  // 用 LinkedList 存储元素
        /** initialize your data structure here. */
        MinStack() { elementContainer = new LinkedList<>(); }
        public void push(int x) { elementContainer.addLast(x); }
        public void pop() { elementContainer.removeLast(); }
        public int top() { return elementContainer.getLast(); }
        public int getMin() { return elementContainer.stream().sorted().findFirst().orElse(-1); }
    }

    /**
     * 维护最小值辅助栈(同样可以使用Node(e,minE)): 利用栈先进后出的性质, 一个元素进栈时, 之前元素的最小元素的确定的.
     * 只需与当前最小元素比较, 得到当前元素出栈之时的最小元素.
     * MinStack#getMin() 时间复杂度 O(n) 空间复杂度 O(n)  7 ms  41.4 MB
     */
    class MinStack1 {
        private LinkedList<Integer> elementContainer;  // 用 LinkedList 存储元素
        private LinkedList<Integer> minElementContainer;  // 用 LinkedList 存储维护当前元素插入后最小值元素
        /** initialize your data structure here. */
        MinStack1() { elementContainer = new LinkedList<>(); minElementContainer = new LinkedList<>(); }
        public void push(int x) {
            elementContainer.addLast(x);
            if (minElementContainer.size() < 1)
                minElementContainer.addLast(x);
            else
                minElementContainer.addLast(Math.min(x, getMin()));
        }
        public void pop() { elementContainer.removeLast(); minElementContainer.removeLast(); }
        public int top() { return elementContainer.getLast(); }
        public int getMin() { return minElementContainer.getLast(); }
    }

    /**
     * 维护最小值辅助栈(同一个栈中完成): 利用栈先进后出的性质, 一个元素进栈时, 之前元素的最小元素的确定的.
     * 只需与当前最小元素比较, 得到当前元素出栈之时的最小元素. 得到最小值时同时压入栈(相当于括号匹配).
     * MinStack#getMin() 时间复杂度 O(n) 空间复杂度 O(n)  7 ms  41.6 MB
     */
    class MinStack2 {
        private LinkedList<Integer> elementContainer;  // 用 LinkedList 存储元素
        private int minElement = Integer.MAX_VALUE; // 用于存储当前栈中最小值
        /** initialize your data structure here. */
        MinStack2() { elementContainer = new LinkedList<>();}
        public void push(int x) {
            // 如果当前的最小值发生改变, 则将最小值压入栈
            if (x <= minElement) {
                elementContainer.addLast(minElement);
                minElement = x;
            }
            // 先压入最小值, 后压入元素值
            elementContainer.addLast(x);
        }
        public void pop() {
            if(minElement == elementContainer.removeLast()) {
                minElement = elementContainer.removeLast();
            }
        }
        public int top() { return elementContainer.getLast(); }
        public int getMin() { return minElement; }
    }

    public static void main(String[] args) {
        MinStack2 minStack = new LeetCode0155().new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-1);
        minStack.push(1);
        minStack.push(-5);
        System.out.println(minStack.getMin()); // 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());  // 返回 0.
        System.out.println(minStack.getMin()); // 返回 -2.
    }
}
