package xin.jerome.study.datastructures.linked.impl;

import xin.jerome.study.datastructures.linked.MyLinkedList;

/**
 * 自定义链表（单向链表）
 *
 * @author Jerome Zhu
 * @since 2018.11.27 20:13
 */
public class LinkedList<E> implements MyLinkedList<E> {

    private Node head;
    private int size;

    /**
     * 构造函数，初始化链表对象
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * 向链表头添加元素:
     * 1、首先创建一个节点
     * 2、将新节点的next指向head
     * 3、将头节点指向新增节点，
     *
     * @param e 添加的元素
     */
    @Override
    public void addHead(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e, head);
        size++;
    }

    /**
     * 在指定索引位置添加元素
     *
     * @param index 指定的索引
     * @param e     添加的元素
     */
    public void addIndex(int index, E e) {
        // 如果角标小于0获取越界则报错
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界了");
        }
        if (index == 0) {
            addHead(e);
        } else {
            // 定义插入位置的前一个结点
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            prev.next = new Node(e, prev.next);

            // 维护size
            size++;
        }
    }

    /**
     * 在链表的尾部添加元素
     *
     * @param e 添加的元素
     */
    public void addLast(E e) {
        addIndex(size, e);
    }

    /**
     * 获取链表中指定位置的元素
     *
     * @param index 指定的位置
     * @return 该位置的元素
     * @throws IndexOutOfBoundsException 索引越界
     */
    public E getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界了");
        }

        Node cur = head;
        if (index != 0) {
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        }
        return cur.e;
    }

    /**
     * 获取头结点的元素
     *
     * @return 元素内容
     */
    public E getHead() {
        return getIndex(0);
    }

    /**
     * 获取尾结点的元素
     *
     * @return 元素内容
     */
    public E getLast() {
        return getIndex(size - 1);
    }

    /**
     * 修改指定位置的元素
     *
     * @param index 指定的位置
     * @param e     修改后的元素
     * @throws IndexOutOfBoundsException 索引越界
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界了");
        }

        Node cur = head;
        if (index != 0) {
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        }
        cur.e = e;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 指定位置
     * @return 删除元素
     * @throws IndexOutOfBoundsException 索引越界
     */
    public E del(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界了");
        }
        Node delNode = head;

        if (index == 0) { // 如果删除的是头结点
            head = head.next;
        } else { // 删除普通节点，需要获取待删除节点的前置节点
            Node preNode = null;
            for (int i = 0; i < index; i++) {
                preNode = delNode;
                delNode = delNode.next;
            }
            preNode.next = delNode.next;
        }

        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 删除指定的元素
     *
     * @param e 指定元素e
     * @throws IndexOutOfBoundsException 索引越界
     */
    @Override
    public void del(E e) {
        // 设置一个虚拟头结点
        Node dummyHead = new Node(e,head);
        Node curNode = dummyHead;
        while (curNode.next != null) {
            if(e.equals(curNode.next.e)) {
                Node delNode = curNode.next;
                curNode.next = delNode.next;
                delNode.next = null;
                size--;
                break;
            }
            curNode = curNode.next;
        }
        // 将头结点还原,避免删除头结点,后续节点丢失的问题。
        head = dummyHead.next;
        dummyHead.next = null;
    }

    /**
     * 判断是否包含某个元素
     *
     * @param e 查找的元素
     * @return 布尔值
     */
    public boolean contains(E e) {
        Node node = head;
        if (head.e.equals(e))
            return true;

        while (node.next != null) {
            if (node.e.equals(e))
                return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        while (cur != null) {
            sb.append(cur.e + "->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    /**
     * 获取链表的大小
     *
     * @return 链表的大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取链表是否为空
     *
     * @return 布尔值
     */
    public boolean isEmpty() {
        return size == 0;
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