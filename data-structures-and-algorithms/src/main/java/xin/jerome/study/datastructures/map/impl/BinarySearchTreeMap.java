package xin.jerome.study.datastructures.map.impl;

import java.util.ArrayList;

import xin.jerome.study.datastructures.map.MyMap;

/**
 * 映射 {@link MyMap} 的二分搜索树的实现
 * 
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
     * @param key
     *            key值
     * @param value
     *            value值
     * @return 根节点
     */
    private Node put(Node node, K key, V value) {
        // 最小问题 当前节点为null
        if (node == null) {
            // 创建了新节点 维护size
            size++;
            return new Node(key, value);
        }

        // 递归问题
        if (node.key.compareTo(key) > 0) {
            node.left = put(node.left, key, value);
        } else if (node.key.compareTo(key) < 0) {
            node.right = put(node.right, key, value);
        } else {
            // 已经存在 key 节点,直接更新该节点的value.
            node.value = value;
        }
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
     * @param node
     *            指定节点
     * @param key
     *            key 值
     * @return 删除key值所在节点后的二叉树
     */
    private Node remove(Node node, K key) {
        // 最小问题 当前节点为null,直接返回
        if (node == null) {
            return node;
        }

        // 递归问题
        if (node.key.compareTo(key) > 0) {
            // 当前节点大于 key 去左子树中删除.
            node.left = remove(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            // 当前节点小于 key 去右子树中删除.
            node.right = remove(node.right, key);
        } else {
            // 待删除的就是本节点 (最优删除: 用右子树中的最小节点代替当前节点)
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
        return node;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除掉以node为根的二分搜索树中的最小节点 返回删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
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
        if (node == null) {
            throw new IllegalArgumentException(key + "not exist !");
        }
        node.value = value;
    }

    /**
     * 获取以当前节点为根节点的二叉树中的key所在节点
     *
     * @param node
     *            当前节点
     * @param key
     *            key值
     * @return 若找到key所在的节点, 则返回节点;否则返回null.
     */
    private Node getNode(Node node, K key) {
        // 最小问题 当前节点为null
        if (node == null) {
            return null;
        }

        // 递归问题
        if (node.key.compareTo(key) > 0) {
            // 当前节点比 key 大,去左边找.
            return getNode(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            // 当前节点比 key 小,去右边找.
            return getNode(node.right, key);
        } else {
            return node;
        }
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
     * 当前树的前序遍历: 根节点->左子树->右子树 (最常用的遍历方式)
     */
    public void preOrder() {
        recursivePreOrder(root);
    }

    /**
     * 指定节点树的前序遍历(递归实现)
     */
    private void recursivePreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.key);
        recursivePreOrder(node.left);
        recursivePreOrder(node.right);
    }

    /**
     * 判断当前AVL树是否是二分搜索树
     */
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /** 中序遍历获取所有的key,存入keys中 */
    private void inOrder(Node root, ArrayList<K> keys) {
        if (root == null) {
            return;
        }

        inOrder(root.left, keys);
        keys.add(root.key);
        inOrder(root.right, keys);
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

        @Override
        public String toString() {
            return String.format("key : %s,left : %s,right : %s", key, left == null ? "null" : left.key,
                right == null ? "null" : right.key);
        }
    }
}
