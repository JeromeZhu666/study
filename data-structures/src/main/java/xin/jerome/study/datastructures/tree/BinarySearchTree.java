package xin.jerome.study.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树的实现(不包含重复元素)
 * <p>
 * 二分搜索树是二叉树,每个叶子节点的值满足: <br>
 * 1、大于其左子树所有节点的值. <br>
 * 2、小于其右子树所有节点的值. <br>
 * 每一颗子树也是二分搜索树,存储的元素必须具有可比较性.
 *
 * <p>
 * 二叉树的定义: <br>
 * 二叉树是一个动态的数据结构,具有唯一的根节点. <br>
 * 二叉树的每一个节点最多有两个孩子. <br>
 * 二叉树的每一个节点最多有一个父亲. <br>
 * 二叉树具有天然的递归性:每个节点左子树也是二叉树,每个节点的右子树也是二叉树. <br>
 * 二叉树不一定是"满"的:一个节点也是二叉树,null也是二叉树.
 *
 * @author Jerome Zhu
 * @since 2019.06.05 13:26
 */
public class BinarySearchTree<E extends Comparable<E>> {

    /**
     * 根节点的定义
     */
    private Node root;
    /**
     * 树的大小
     */
    private int size;

    /**
     * 创建一个空的二分搜索树
     */
    public BinarySearchTree() {}

    /**
     * 向二分搜索树种插入一个元素
     *
     * @param e
     *            待插入元素
     */
    public void add(E e) {
        // 直接插入Node节点下,不返回任何结果
        // if (root == null) {
        // root = new Node(e);
        // size++;
        // }
        // else
        // add(root, e);
        // 向根节点插入元素,并将新的树赋给根节点
        root = recursiveAdd(root, e);
    }

    /**
     * 向Node节点插入一个元素(递归实现)
     *
     * @param node
     *            插入元素的节点
     * @param e
     *            待插入元素
     */
    private Node recursiveAdd(Node node, E e) {
        // 直接插入Node节点下,不返回任何结果
        // if(e.equals(node.e)){
        // return;
        // }else if(e.compareTo(node.e) < 0) {
        // if(node.left == null) {
        // node.left = new Node(e);
        // size++;
        // return;
        // }
        // else
        // add(node.left, e);
        // } else {
        // if(node.right == null) {
        // node.right = new Node(e);
        // size++;
        // return;
        // }
        // else
        // add(node.right, e);
        // }
        // 改进将元素插入Node节点下,返回Node节点
        // 最基本的问题,应该插入的位置节点为null
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            // 插入的元素比当前节点小
            // 向当前节点的左子树插入元素,并将新的左子树赋给当前节点
            node.left = recursiveAdd(node.left, e);

        } else if (e.compareTo(node.e) > 0) {
            // 插入的元素比当前节点大
            // 向当前节点的右子树插入元素,并将新的右子树赋给当前节点
            node.right = recursiveAdd(node.right, e);

        }
        return node;
    }

    /**
     * 检查当前二分搜索树中是否包含元素 e
     *
     * @param e
     *            待检查元素
     * @return 检查结果
     */
    public boolean contains(E e) {
        return recursiveSearch(root, e) == null;
    }

    /**
     * 检查当前二分搜索树中是否包含元素 e (递归实现)
     *
     * @param e
     *            待检查元素
     * @return 检查结果
     */
    private Node recursiveSearch(Node node, E e) {
        if (node == null) {
            // 已经递归到叶子节点
            return null;
        }

        if (e.equals(node.e)) {
            return node;
        } else if (e.compareTo(node.e) < 0) {
            // 去左子树中匹配
            return recursiveSearch(node.left, e);
        } else {
            // 去右子树中匹配
            return recursiveSearch(node.right, e);
        }
    }

    /**
     * 当前树的前序遍历: 根节点->左子树->右子树 (最常用的遍历方式)
     */
    public void preOrder() {
        stackPreOrder(root);
    }

    /**
     * 指定节点树的前序遍历(递归实现)
     */
    private void recursivePreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        recursivePreOrder(node.left);
        recursivePreOrder(node.right);
    }

    /**
     * 指定节点树的前序遍历(栈实现)
     */
    private void stackPreOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        // 首先将二分查找树的根节点压入栈
        stack.push(node);
        // 开始遍历,直到栈中的元素为空
        while (!stack.empty()) {
            // 栈顶元素出栈,访问该元素
            Node curNode = stack.pop();
            System.out.println(curNode.e);
            // 判断当前节点是否有叶子节点,如果有,先将右叶子节点压入栈,后将左叶子节点压入栈.(栈:先入后出)
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
    }

    /**
     * 当前树的中序遍历: 左子树->根节点->右子树 (结果都是顺序的)
     */
    public void inOrder() {
        recursiveInOrder(root);
    }

    /**
     * 指定节点树的中序遍历(递归实现)
     */
    private void recursiveInOrder(Node node) {
        if (node == null) {
            return;
        }

        recursiveInOrder(node.left);
        System.out.println(node.e);
        recursiveInOrder(node.right);
    }

    /**
     * 当前树的后序遍历: 左子树->右子树->根节点 (为二分搜索树释放内存)
     */
    public void postOrder() {
        recursivePostOrder(root);
    }

    /**
     * 指定节点树的后序遍历(递归实现)
     */
    private void recursivePostOrder(Node node) {
        if (node == null) {
            return;
        }

        recursivePostOrder(node.left);
        recursivePostOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 广度优先遍历,即是层序遍历(利用队列实现,常用于算法设计中-最短路径).
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        // 根节点入队
        queue.add(root);
        // 当队列不为空
        while (!queue.isEmpty()) {
            // 元素出队
            Node curNode = queue.remove();
            System.out.println(curNode.e);
            // 判断当前节点是否还有叶子节点.若有,先左叶子节点入队,后右叶子节点入队(队列:先进先出).
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
    }

    /**
     * 获取当前二分搜索树的最小元素
     *
     * @return 最小元素的值
     */
    public E minElement() {
        checkedEmpty();

        Node curNode = root;
        while (curNode.left != null) {
            curNode = curNode.left;
        }
        return curNode.e;
    }

    /**
     * 获取以当前节点为根节点的二分搜索树的最小元素节点(递归实现)
     */
    private Node minElement(Node node) {
        if (node.left == null) {
            return node;
        }
        return minElement(node.left);
    }

    /**
     * 获取当前二分搜索树的最大元素
     *
     * @return 最大元素的值
     */
    public E maxElement() {
        checkedEmpty();

        Node curNode = root;
        while (curNode.right != null) {
            curNode = curNode.right;
        }
        return curNode.e;
    }

    /**
     * 删除当前二分搜索树的最小节点
     *
     * @return 最小节点的值
     */
    public E removeMinElement() {
        E e = minElement();
        removeMinElement(root);
        return e;
    }

    /**
     * 删除已当前节点为根节点的二分搜索树中的最小元素
     *
     * @param node
     *            当前节点
     * @return 处理后的当前节点
     */
    private Node removeMinElement(Node node) {
        if (node.left == null) {
            // 没有做更新size的动作,没有做如果当前节点如果有右子树的断开操作
            // if (node.right == null)
            // return null;
            // else
            // return node.right;
            // 优化
            // 拿到待返回的当前节点的右子树
            // 将当前节点从当前树中断开
            Node rightNode = node.right;
            node.right = null;
            size--;// 维护size
            // 返回右子树
            return rightNode;
        }
        node.left = removeMinElement(node.left);
        return node;
    }

    /**
     * 删除当前二分搜索树的最大节点
     *
     * @return 最大节点的值
     */
    public E removeMaxElement() {
        E e = maxElement();
        removeMaxElement(root);
        return e;
    }

    /**
     * 删除已当前节点为根节点的二分搜索树中的最小元素
     *
     * @param node
     *            当前节点
     * @return 处理后的当前节点
     */
    private Node removeMaxElement(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMaxElement(node.right);
        return node;
    }

    /**
     * 删除指定元素
     *
     * @param e
     *            删除的元素
     */
    public void removeElement(E e) {
        root = recursiveRemoveElement(root, e);
    }

    /**
     * 删除已以当前节点为根节点的二分搜索树的指定元素<code>E</code>.(后继节点代替被删除节点)
     *
     * @param node
     *            指定的需要处理的二分搜索树的根节点
     * @param e
     *            指定的元素
     * @return 处理后的二分搜索树
     */
    public Node recursiveRemoveElement(Node node, E e) {
        if (node == null)
            return null;

        if (node.e.compareTo(e) < 0) {
            node.right = recursiveRemoveElement(node.right, e);
            return node;
        } else if (node.e.compareTo(e) > 0) {
            node.left = recursiveRemoveElement(node.left, e);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            } else {
                Node newNode = minElement(node.right);
                newNode.right = removeMinElement(node.right);
                newNode.left = node.left;
                node.left = null;
                node.right = null;
                return newNode;
            }
        }
    }

    /**
     * 获取当前树中存储了多少元素
     *
     * @return 元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断当前树是否为空
     *
     * @return 布尔值
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private void checkedEmpty() {
        if (isEmpty()) {
            throw new IllegalArgumentException("BinarySearchTree is empty.");
        }
    }

    /**
     * 树的节点定义
     */
    private class Node {
        public E e;
        public Node left, right;

        /**
         * 构造一个节点
         *
         * @param e
         *            该节点中存放的值
         */
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
}
