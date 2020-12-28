package xin.jerome.study.datastructures.heap;

/**
 * 自定义堆
 * 堆的定义:给定堆中任意节点 P 和 C,若 P 是 C 的父节点,那么 P 的值会小于等于（或大于等于） C 的值.
 * 最小堆:父节点的值恒小于等于子节点的值.
 * 最大堆:父节点的值恒大于等于子节点的值.
 *
 * @author Jerome Zhu
 * @since 2019.07.01 22:02
 */
public interface MyHeap<E> {

    /**
     * 向堆中添加一个元素
     *
     * @param e 添加入堆的元素
     */
    void add(E e);

    /**
     * 从堆中取出最大元素
     *
     * @return 删除元素的值
     */
    E extractMax();

    /**
     * 查看堆中最大的元素
     *
     * @return 最大的元素值
     */
    E findMax();

    /**
     * 将堆中最大的元素取出,并添加新的元素
     *
     * @param e 待添加的元素
     * @return 堆中被替换的最大的元素
     */
    E replace(E e);

    /**
     * 返回堆的大小
     */
    int size();

    /**
     * 返回当前堆是否为空
     */
    boolean isEmpty();

}
