package xin.jerome.study.datastructures.queue.impl;

import xin.jerome.study.datastructures.heap.impl.MaxHeap;
import xin.jerome.study.datastructures.queue.MyQueue;

/**
 * {@link MyQueue} 基于 {@link MaxHeap} 的优先队列的实现
 *
 * @author Jerome Zhu
 * @since 2019.07.04 20:40
 */
public class PriorityQueue<E extends Comparable<E>> implements MyQueue<E>  {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void add(E e) {
        maxHeap.add(e);
    }

    @Override
    public E remove() { // 优先级最高的
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int size() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
