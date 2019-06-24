package xin.jerome.study.datastructures.queue.impl;

import xin.jerome.study.datastructures.queue.MyQueue;

/**
 * {@link MyQueue} 的循环队列实现
 *
 * @author Jerome Zhu
 * @since 2018.10.25 21:55
 */
public class MyLoopQueue<E> implements MyQueue<E> {

    /**
     * 循环队列的容器
     */
    private E[] data;

    /**
     * 循环队列的队首的位置
     */
    private int front;

    /**
     * 循环队列的队尾的位置
     */
    private int tail;

    /**
     * 循环队列的大小
     */
    private int size;

    /**
     * 无参构造，使用默认大小
     */
    public MyLoopQueue() {
        this(10);
    }

    /**
     * 根据参数构造初始容量大小
     *
     * @param capacity 初始容量大小s
     */
    public MyLoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public void add(E e) {
        // 如果循环队列满的话需要进行扩容
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);

        data[tail] = e;
        // 维护队尾的索引
        tail = (tail + 1) % data.length;
        // 维护队列大小
        size++;
    }

    @Override
    public E remove() {
        // 判断队列是否为空，再进行出队操作
        if (isEmpty())
            throw new IllegalArgumentException("队列为空，不能进行出队操作！");
        E e = data[front];
        // 维护出队位置
        data[front] = null;
        // 维护队首的索引
        front = (front + 1) % data.length;
        // 维护队列大小
        size--;
        // 如果队列大小为容量的四分之一的话，进行缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return e;
    }

    @Override
    public E getFront() {
        // 判断队列是否为空，再进行出队操作
        if (isEmpty())
            throw new IllegalArgumentException("队列为空！");
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 获取队列的容量
     *
     * @return 容量的大小
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 对循环队列进行容量改变
     *
     * @param newCapacity 新的容量大小
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MyLoopQueue: front[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail)
                sb.append(",");
        }
        sb.append("] tail");
        sb.append(String.format("  size : %d , capacity : %d", size, getCapacity()));
        return sb.toString();
    }

}
