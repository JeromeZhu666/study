package xin.jerome.study.datastructures.tree;

import java.util.ArrayList;

/**
 * AVL树(高度平衡树)
 * 
 * AVL树也是一个二分搜索树,在AVL树中,任一节点对应的两棵子树的最大高度差为1,因此它也被称为高度平衡树。
 * 
 * 查找、插入和删除在平均和最坏情况下的时间复杂度都是 O(log n)。增加和删除元素的操作则可能需要借由一次或多次树旋转,以实现树的重新平衡。
 *
 * @author Jerome Zhu
 * @since 2019.07.31 21:09
 */
public class AVLTree<K extends Comparable<K>, V> {

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
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
    private Node add(Node node, K key, V value) {
        // 最小问题 当前节点为null
        if (node == null) {
            // 创建了新节点 维护size
            size++;
            return new Node(key, value);
        }

        // 递归问题
        if (node.key.compareTo(key) > 0) {
            node.left = add(node.left, key, value);
        } else if (node.key.compareTo(key) < 0) {
            node.right = add(node.right, key, value);
        } else {
            // 已经存在 key 节点,直接更新该节点的value.
            node.value = value;
        }
        // 更新高度值
        node.height = 1 + Math.max(height(node.left), height(node.right));
        return autoBalance(node);
    }

    /**
     * 完成以当前节点为根节点的自平衡
     *
     * @param node
     *            当前节点
     * @return 平衡后的根节点
     */
    private Node autoBalance(Node node) {
        // 计算平衡因子,判断 AVL 树是否需要重新平衡
        int balanceFactor = getBalanceFactor(node);
        // LL 情况需要右旋转
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        // LR 情况需要左子树左旋转为 LL 后,在进行右旋转
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RR 情况需要左旋转
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        // RL 情况需要右子树右旋转为 RR 后,在进行左旋转
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    /** 将以node节点为根的AVL树进行右旋转,完成自平衡 */
    private Node rightRotate(Node node) {
        Node leftNode = node.left;
        Node leftRightNode = leftNode.right;

        // 向右旋转过程
        leftNode.right = node;
        node.left = leftRightNode;

        // 更新节点的高度,先更新子节点的高度,在更新父节点的高度
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        leftNode.height = Math.max(height(leftNode.left), height(leftNode.right)) + 1;

        return leftNode;
    }

    /** 将以node节点为根的AVL树进行左旋转,完成自平衡 */
    private Node leftRotate(Node node) {
        Node rightNode = node.right;
        Node rightLeftNode = rightNode.left;

        // 向左旋转过程
        rightNode.left = node;
        node.right = rightLeftNode;

        // 更新节点的高度,先更新子节点的高度,在更新父节点的高度
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        rightNode.height = Math.max(height(rightNode.left), height(rightNode.right)) + 1;

        return rightNode;
    }

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
            return null;
        }

        // 递归问题
        Node returnNode = null;
        if (key.compareTo(node.key) < 0) {
            // 当前节点大于 key 去左子树中删除.
            node.left = remove(node.left, key);
            returnNode = node;
        } else if (key.compareTo(node.key) > 0) {
            // 当前节点小于 key 去右子树中删除.
            node.right = remove(node.right, key);
            returnNode = node;
        } else {
            // 待删除的就是本节点 (最优删除: 用右子树中的最小节点代替当前节点)
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                returnNode = rightNode;
            }
            // 待删除节点右子树为空的情况
            else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                returnNode = leftNode;
            }
            // 待删除节点左右子树均不为空的情况
            else {
                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                // successor.right = removeMin(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                returnNode = successor;
            }
        }
        if (returnNode == null) {
            return null;
        }
        // 更新高度值
        returnNode.height = 1 + Math.max(height(returnNode.left), height(returnNode.right));
        return autoBalance(returnNode);
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

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

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

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取当前节点的高度值
     */
    private int height(Node cur) {
        if (cur == null) {
            return 0;
        }
        return cur.height;
    }

    /**
     * 获取当前节点的平衡因子
     */
    private int getBalanceFactor(Node cur) {
        if (cur == null) {
            return 0;
        }
        return height(cur.left) - height(cur.right);
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

    /** 判断AVL树是否是平衡的 */
    public boolean isBalance() {
        return isBalance(root);
    }

    /** 判断以root为根节点的AVL树是否是平衡的 */
    private boolean isBalance(Node root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(getBalanceFactor(root)) > 1) {
            return false;
        }

        return isBalance(root.left) && isBalance(root.right);
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

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        @Override
        public String toString() {
            return String.format("key : %s,left : %s,right : %s", key, left == null ? "null" : left.key,
                right == null ? "null" : right.key);
        }
    }
}
