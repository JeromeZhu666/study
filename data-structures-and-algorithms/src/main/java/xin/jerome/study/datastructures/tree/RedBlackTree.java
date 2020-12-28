package xin.jerome.study.datastructures.tree;

import java.util.ArrayList;

/**
 * 红黑树
 * 
 * 红黑树是一种自平衡二叉查找树,它可以在O(log n)时间内完成查找,插入和删除.
 * 
 * 1.节点是红色或黑色. <br>
 * 2.根是黑色. <br>
 * 3.所有叶子都是黑色(叶子是NIL节点). <br>
 * 4.每个红色节点必须有两个黑色的子节点(从每个叶子到根的所有路径上不能有两个连续的红色节点). <br>
 * 5.从任一节点到其每个叶子的所有简单路径都包含相同数目的黑色节点. <br>
 *
 * @author Jerome Zhu
 * @since 2019.08.01 08:19
 */
public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BALCK = false;
    private Node root;
    private int size;

    public RedBlackTree() {
        root = null;
        size = 0;
    }

    /**
     * 向红黑树中添加一个元素
     *
     * @param key
     *            key值
     * @param value
     *            value值
     */
    public void add(K key, V value) {
        root = add(root, key, value);
        // 维护性质2,保持根节点是黑色.
        root.color = BALCK;
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

        // 维护红黑树的性质
        // 二节点的右侧是红色,左侧不是红色(左旋转).
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        // 三节点的左侧是红色(右旋转).
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        // 临时的四节点,即左右子节点都是红色(颜色翻转).
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    /**
     * 删除红黑树中的一个元素 todo 维护红黑树的性质
     * 
     * @param key
     *            待删除元素的key
     * @return 已删除元素的Value
     */
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
     * 判断一个节点是否是红色
     * 
     * @param node
     *            待验证的节点
     * @return 红色返回 true, 黑色返回 false.
     */
    private boolean isRed(Node node) {
        // 性质3所有叶子节点都是黑色
        if (node == null) {
            return BALCK;
        }
        return node.color;
    }

    /**
     * 将以 node 节点为根的树进行左旋转
     * 
     * @param node
     *            根节点
     * @return 左旋转后的根节点
     */
    private Node leftRotate(Node node) {
        Node rightNode = node.right;
        // 进行左旋转
        node.right = rightNode.left;
        rightNode.left = node;
        // 维护颜色(红色是向左倾的)
        rightNode.color = node.color;
        node.color = RED;

        return rightNode;
    }

    /**
     * 将以 node 节点为根的树进行右旋转
     *
     * @param node
     *            根节点
     * @return 右旋转后的根节点
     */
    private Node rightRotate(Node node) {
        Node leftNode = node.left;
        // 进行右旋转
        node.left = leftNode.right;
        leftNode.right = node;
        // 维护颜色(红色是向左倾的)
        leftNode.color = node.color;
        node.color = RED;

        return leftNode;
    }

    /**
     * 颜色翻转
     * 
     * @param node
     *            翻转的节点
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BALCK;
        node.right.color = BALCK;
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
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.color = RED;
        }

        @Override
        public String toString() {
            return String.format("key : %s,left : %s,right : %s", key, left == null ? "null" : left.key,
                right == null ? "null" : right.key);
        }
    }
}
