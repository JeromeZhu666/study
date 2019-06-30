package xin.jerome.study.datastructures.map.impl;

import xin.jerome.study.datastructures.map.MyMap;

/**
 * @author Jerome Zhu
 * @since 2019.06.30 21:04
 */
public class BinarySearchTreeMap<K extends Comparable<K>, V> implements MyMap<K, V> {

    private Node root;
    private int size;

    public BinarySearchTreeMap() {
        root = null;
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    /**
     * 向以指定节点为根节点的树中添加元素(递归实现)
     *
     * @param key   key值
     * @param value value值
     * @return 根节点
     */
    private Node put(Node node, K key, V value) {
        // 最小问题   当前节点为null
        if (node == null) {
            // 创建了新节点   维护size
            size++;
            return new Node(key, value);
        }

        // 递归问题
        if (node.key.compareTo(key) > 0)
            node.left = put(node.left, key, value);
        else if (node.key.compareTo(key) < 0)
            node.right = put(node.right, key, value);
        else // 已经存在 key 节点,直接更新该节点的value.
            node.value = value;
        return node;
    }

    @Override
    public V remove(K key) {
        Node delNode = getNode(root, key);
        if (delNode != null) {
            root = remove(root, key);
            return delNode.value;
        }
        return null;
    }

    /**
     * 删除以指定节点为根的二叉树中key值所在的节点.
     *
     * @param node 指定节点
     * @param key  key 值
     * @return 删除key值所在节点后的二叉树
     */
    private Node remove(Node node, K key) {
        // 最小问题  当前节点为null,直接返回
        if (node == null)
            return node;

        // 递归问题
        if (node.key.compareTo(key) > 0) // 当前节点大于 key 去左子树中删除.
            node.left = remove(node.left, key);
        else if (node.key.compareTo(key) < 0) // 当前节点小于 key 去右子树中删除.
            node.right = remove(node.right, key);
        else { // 待删除的就是本节点 (最优删除: 用右子树中的最小节点代替当前节点)
            size--;
            if (node.left != null) {// 当前节点的右子树不为空,用左子树代替当前节点,并将右子树添加到最右节点
                Node cur = node.left;
                while (cur.right != null) // 遍历得到左子树的最右节点
                    cur = cur.right;
                cur.right = node.right;
                return node.left;
            } else {// 左子树为空, 直接用右子树代替当前节点
                return node.right;
            }
        }
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + "not exist !");
        node.value = value;
    }

    /**
     * 获取以当前节点为根节点的二叉树中的key所在节点
     *
     * @param node 当前节点
     * @param key  key值
     * @return 若找到key所在的节点, 则返回节点;否则返回null.
     */
    private Node getNode(Node node, K key) {
        // 最小问题 当前节点为null
        if (node == null)
            return null;

        // 递归问题
        if (node.key.compareTo(key) > 0)
            return getNode(node.left, key); // 当前节点比 key 大,去左边找.
        else if (node.key.compareTo(key) < 0)
            return getNode(node.right, key);// 当前节点比 key 小,去右边找.
        else
            return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 当前树的前序遍历:    根节点->左子树->右子树   (最常用的遍历方式)
     */
    public void preOrder() {
        recursivePreOrder(root);
    }

    /**
     * 指定节点树的前序遍历(递归实现)
     */
    private void recursivePreOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.key);
        recursivePreOrder(node.left);
        recursivePreOrder(node.right);
    }

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
