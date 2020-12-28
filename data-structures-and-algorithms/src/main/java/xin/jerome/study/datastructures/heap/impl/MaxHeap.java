package xin.jerome.study.datastructures.heap.impl;

import xin.jerome.study.datastructures.array.MyGenericArray;
import xin.jerome.study.datastructures.heap.MyHeap;

/**
 * 最大堆的数组实现 <br>
 * 二叉堆(若不加限定时，堆这种数据结构均指二叉堆这种实现): <br>
 * 1.堆总是一棵完全二叉树,即按照层序从左到右依次排列. <br>
 * 2.堆中任意节点的值总是不大于其父节点的值.
 *
 * @author Jerome Zhu
 * @since 2019.07.01 21:57
 */
public class MaxHeap<E extends Comparable<E>> implements MyHeap<E> {

    private MyGenericArray<E> data;

    public MaxHeap(int capacity) {
        data = new MyGenericArray<>(capacity);
    }

    public MaxHeap() {
        data = new MyGenericArray<>();
    }

    /**
     * Heapify 将一个数组堆化
     *
     * @param arr
     *            待转化的数组
     */
    public MaxHeap(E[] arr) {
        data = new MyGenericArray<>(arr);
        // 从最后一个非叶子节点,进行下沉操作. 时间复杂度O(n)
        for (int i = getParentIndex(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    @Override
    public void add(E e) {
        // 首先将元素加入数组的末尾,保证第一个性质.
        data.addToLast(e);
        // 将新加入的元素上浮,保证第二个性质.
        siftUp(data.getSize() - 1);
    }

    /**
     * 将index位置的元素进行上浮
     *
     * @param index
     *            指定位置
     */
    private void siftUp(int index) {
        // 若当前节点大于父节点,将当前节点与父节点进行交换.
        while (index > 0 && data.get(index).compareTo(data.get(getParentIndex(index))) > 0) {
            data.swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    @Override
    public E extractMax() {
        // 查看当前堆中最大的元素
        E e = findMax();
        // 先将最后一个元素和第一个元素交换位置
        data.swap(0, data.getSize() - 1);
        // 删除最后一个元素,满足第一个性质.
        data.deleteLast();
        // 再将第一个元素下沉,满足第二个性质.
        siftDown(0);
        return e;
    }

    @Override
    public E findMax() {
        // 如果当前堆为空,抛异常.
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can't extractMax when heap is empty.");
        }
        return data.get(0);
    }

    @Override
    public E replace(E e) {
        E max = findMax();
        // 将最大元替换成新元素
        data.set(0, e);
        // 将第一个元素进行下沉,以满足第二个性质.
        siftDown(0);
        return max;
    }

    /**
     * 将指定位置的元素下沉
     *
     * @param index
     *            指定的位置
     */
    private void siftDown(int index) {

        // 当左孩子的索引小于data.size说明当前节点有左孩子
        while (getLeftChildIndex(index) < data.getSize()) {
            int maxChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < data.getSize()
                && data.get(getRightChildIndex(index)).compareTo(data.get(maxChildIndex)) > 0) {
                maxChildIndex = getRightChildIndex(index);
            }
            // 如果当前节点比最大节点还要大,不用交换了已经平衡了.
            if (data.get(index).compareTo(data.get(maxChildIndex)) > 0) {
                break;
            }

            // 否则进行交换
            data.swap(index, maxChildIndex);
            // 维护i
            index = maxChildIndex;
        }

    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 获取指定节点的父亲节点的索引
     *
     * @param index
     *            指定节点的索引
     * @return 父亲节点的索引
     */
    private int getParentIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    /**
     * 获取指定节点的左孩子节点的索引
     *
     * @param index
     *            指定节点的索引
     * @return 左孩子节点的索引
     */
    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    /**
     * 获取指定节点的右孩子节点的索引
     *
     * @param index
     *            指定节点的索引
     * @return 右孩子节点的索引
     */
    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }
}
