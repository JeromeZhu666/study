package xin.jerome.study.datastructures.stack.impl;

import xin.jerome.study.datastructures.stack.MyStack;
import xin.jerome.study.datastructures.linked.impl.LinkedList;

/**
 * {@link MyStack}链表{@link LinkedList}实现
 *
 * @author Jerome Zhu
 * @since 2019.06.03 15:52
 */
public class MyLinkedListStack<E> implements MyStack<E>{

    /**
     * 存放栈中元素的容器
     */
    private LinkedList<E> list;

    /**
     * 构造函数
     */
    public MyLinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addHead(e);
    }

    @Override
    public E pop() {
        return list.del(0);
    }

    @Override
    public E peek() {
        return list.getHead();
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyLinkedListStack: top ");
        sb.append(list);
        return sb.toString();
    }
}
