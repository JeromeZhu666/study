package xin.jerome.study.algorithms.tree.leetcode;

import xin.jerome.study.domain.node.TreeNode;

import java.util.LinkedList;

/**
 * 对称二叉树:
 * <br>给定一个二叉树，检查它是否是镜像对称的。
 *
 * <p>例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <br>     1
 * <br>    / \
 * <br>   2   2
 * <br>  / \ / \
 * <br> 3  4 4  3
 *
 * @author Jerome Zhu
 * @since 2019.06.06 15:47
 */
public class LeetCode0101 {

    /**
     * 判断当前二叉树是否镜像对称(层序遍历-迭代实现)
     *
     * @param root 二叉树的跟节点
     * @return 检查结果
     */
    public boolean isSymmetric(TreeNode root) { // 3 ms 35 MB 战胜 48.69 % 的 java 提交记录
        // 节点为空
        if (root == null)
            return true;
        // 将当前节点的所有左字节点插入到链表的头部,所有右子节点插入到链表的尾部,同时取出链表的头和尾作比较.
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addFirst(root.left);
        list.addLast(root.right);
        while (!list.isEmpty()) { // 如果链表不为空,一直循环遍历
            TreeNode left = list.removeFirst();
            TreeNode right = list.removeLast();
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;

            list.addFirst(left.left);
            list.addFirst(left.right);
            list.addLast(right.right);
            list.addLast(right.left);
        }
        return true;
    }

    /**
     * 判断当前二叉树是否镜像对称(递归实现)
     *
     * @param root 二叉树的跟节点
     * @return 检查结果
     */
    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    /**
     * 将以当前两个节点为根节点的二叉树是否镜像一致
     *
     * @param leftNode  左子树
     * @param rightNode 右子树
     * @return 检查结果
     */
    private boolean isMirror(TreeNode leftNode, TreeNode rightNode) { // 2 ms 34.3 MB 战胜 88.04 % 的 java 提交记录
        // 解决最简单的问题,一个节点的二叉树.
        if (leftNode == null && rightNode == null)
            return true;
        if (leftNode == null || rightNode == null)
            return false;
        if (leftNode.val != rightNode.val)
            return false;

        return isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left);
    }


    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root = new TreeNode(arr);
        System.out.println(new LeetCode0101().isSymmetric(root));
    }
}
