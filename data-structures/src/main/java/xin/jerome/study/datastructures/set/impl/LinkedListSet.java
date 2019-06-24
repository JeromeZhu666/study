package xin.jerome.study.datastructures.set.impl;

import xin.jerome.study.datastructures.linked.impl.LinkedList;
import xin.jerome.study.datastructures.set.MySet;

/**
 * 集合 {@link MySet} 的链表 {@link LinkedList} 实现
 *
 * @author Jerome Zhu
 * @since 2019.06.23 21:02
 */
public class LinkedListSet<E> implements MySet<E> {

    // 集合容器
    private LinkedList<E> list;

    /**
     * 初始化容器
     */
    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        // 如果集合中不包含元素E,才做添加操作
        if(!list.contains(e))
            list.addHead(e);
    }

    @Override
    public void remove(E e) {
        list.del(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
