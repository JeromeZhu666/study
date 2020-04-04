package xin.jerome.study.algorithms.leetcode.tree;

import xin.jerome.study.algorithms.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度(就是找最近的叶子节点):
 * <br>给定一个二叉树，找出其最小深度.
 * <br>二叉树的深度为根节点到最远叶子节点的最长路径上的节点数.
 * <br>说明: 叶子节点是指没有子节点的节点.
 *
 * <p>示例：
 * <br>给定二叉树 [3,9,20,null,null,15,7],
 * <br>     3
 * <br>    / \
 * <br>   9  20
 * <br>     /  \
 * <br>    15   7
 * <br>返回它的最小深度 2 .
 *
 * @author Jerome Zhu
 * @since 2019.06.06 18:45
 */
public class LeetCode0111 {

    /**
     * 获取当前二叉树的最小深度(递归实现-深度优先遍历)
     *
     * @param root 根节点
     * @return 最小深度的值
     */
    public int minDepth(TreeNode root) { // 2 ms 36.2 MB 战胜 13.85 % 的 java 提交记录
        // 如果是个空树,深度为0.
        if (root == null) return 0;

        // 递归获取左子树的深度
        int leftMinDepth = minDepth(root.left);
        // 递归获取右子树的深度
        int rightMinDepth = minDepth(root.right);
        // 如果左子树或者右子树的深度为0,则需要当前另外一个子树深度+1.因为只有左右子树同时为0时,才算是叶子节点.
        if (leftMinDepth == 0 || rightMinDepth == 0) return 1 + leftMinDepth + rightMinDepth;
        // 返回当前节点最小子树深度的值+1
        return 1 + Integer.min(leftMinDepth, rightMinDepth);
    }

    /**
     * 获取当前二叉树的最小深度(迭代实现-广度优先遍历)
     *
     * @param root 根节点
     * @return 最小深度的值
     */
    public int minDepth1(TreeNode root) { // 2 ms 37.3 MB 战胜 13.85 % 的 java 提交记录
        // 初始化深度的值
        int depth = 0;
        // 如果是个空树,深度为0.
        if (root == null) return depth;
        // 构造一个队列,对树进行广度优先遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 遍历
        while (!queue.isEmpty()) {
            // 遍历一层,深度+1.
            depth++;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.remove();
                // 如果左右子树同时为null,则找到了第一个叶子节点.
                if (cur.left == null && cur.right == null) return depth;
                // 如果子节点不为null,则加入队列.
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 9, 2, 15, 7};
        TreeNode root = new TreeNode(arr);
        System.out.println(new LeetCode0111().minDepth1(root));
    }
}
