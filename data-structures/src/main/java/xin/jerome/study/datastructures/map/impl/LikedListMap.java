package xin.jerome.study.datastructures.map.impl;

import xin.jerome.study.datastructures.map.MyMap;

/**
 * 映射 {@link MyMap} 的链表实现
 *
 * @author Jerome Zhu
 * @since 2019.06.30 18:03
 */
public class LikedListMap<K, V> implements MyMap<K, V> {

    private Node dummyHead;
    private int size;

    public LikedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        Node node = getNode(key);
        if(node == null) { // map中不存在,则添加元素
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else { // map中存在,更新value.
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
//        Node node = getNode(key);
//        if (node == null)
//            return null;
//        V oldValue = node.value;
//        Node pre = dummyHead;
//        while (pre.next != null) {
//            if (pre.next == node)
//                break;
//            pre = pre.next;
//        }
//        pre.next = node.next;
//        node.next = null;
//        size--;
//        return oldValue;
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.key.equals(key)) // 找到了待删除节点
                break;
            pre = pre.next;
        }
        if (pre.next != null) {
            Node delNode = pre.next;
            pre.next = pre.next.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(key + "not exist !");
        node.value = value;
    }

    /**
     * 根据key值获取,key所对应的节点
     *
     * @param key key值
     * @return 若存在返回Node, 否则返回null.
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, Node next) {
            this(key, null, next);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }
}
