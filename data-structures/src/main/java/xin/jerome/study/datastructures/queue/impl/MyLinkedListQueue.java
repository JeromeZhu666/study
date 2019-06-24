package xin.jerome.study.datastructures.queue.impl;

import xin.jerome.study.datastructures.queue.MyQueue;

/**
 * {@link MyQueue} 链表实现
 *
 * @author Jerome Zhu
 * @since 2019.06.04 13:05
 */
public class MyLinkedListQueue<E> implements MyQueue<E> {

    /**
     * 头结点
     */
    private Node head;
    /**
     * 尾节点
     */
    private Node tail;
    /**
     * 队列容量大小
     */
    private int size;

    /**
     * 创建一个空队列
     */
    public MyLinkedListQueue() {
    }

    @Override
    public void add(E e) {
        Node node = new Node(e);
        if (size == 0) {
            tail = node;
            head = tail;
        } else { // 链表头  作为队列的头
            tail.next = node;
            tail = tail.next;
        }
        size++;
    }
    @Override
    public E remove() {
        // 判断队列是否为空
        if(isEmpty())
            throw new IllegalArgumentException("Cannot remove from an Empty queue.");

        Node delNode = head;
        if(size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        delNode.next = null;
        size--;
        return delNode.e;
    }

    @Override
    public E getFront() {
        // 判断队列是否为空
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return head.e;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LikedListQueue: front{");
        Node cur = head; // 一定要定义遍历的节点， 不然会改变到链表里面的值
        while (cur != null) {
            sb.append(cur.e + "->");
            cur = cur.next;
        }
        sb.append("null } tail");
        return sb.toString();
    }

    /**
     * 私有的结点类
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
