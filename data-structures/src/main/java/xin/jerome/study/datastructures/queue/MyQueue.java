package xin.jerome.study.datastructures.queue;

/**
 * 自定义队列的实现
 *
 * @author Jerome Zhu
 * @since 2018.10.25 21:12
 */
public interface MyQueue<E> {

    /**
     * 元素入队
     *
     * @param e 入队的对象
     */
    void add(E e);

    /**
     * 元素出队
     *
     * @return 队首的元素
     */
    E remove();

    /**
     * 查看队首的元素
     *
     * @return 队首的元素
     */
    E getFront();

    /**
     * 获取队列的大小
     *
     * @return 队列的大小
     */
    int size();

    /**
     * 查看队列是否为空
     *
     * @return true or false
     */
    boolean isEmpty();

}
