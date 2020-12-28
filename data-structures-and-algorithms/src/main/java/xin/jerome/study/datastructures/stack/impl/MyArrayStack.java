package xin.jerome.study.datastructures.stack.impl;

import xin.jerome.study.datastructures.array.MyGenericArray;
import xin.jerome.study.datastructures.stack.MyStack;

/**
 * {@link MyStack}数组{@link MyGenericArray}实现
 *
 * @author Jerome Zhu
 * @since 2018.10.23 20:34
 */
public class MyArrayStack<E> implements MyStack<E> {

    /**
     * 存放栈元素的数组
     */
    private MyGenericArray<E> array;

    /**
     * 有参构造函数，声明栈的初始容量
     * @param capacity 初始大小
     */
    public MyArrayStack(int capacity) {
        array = new MyGenericArray<>(capacity);
    }

    /**
     * 无参构造函数，使用默认的容量
     */
    public MyArrayStack() {
        array = new MyGenericArray<>();
    }

    @Override
    public void push(E e) {
        array.addToLast(e);
    }

    @Override
    public E pop() {
        return array.deleteLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int size() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取栈的容量
     * @return 容量大小
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MyArrayStack:[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if(i != array.getSize() - 1)
                sb.append(",");
        }
        sb.append("] top");
        return sb.toString();
    }
}
