package xin.jerome.study.algorithms.leetcode.tree;

import xin.jerome.study.algorithms.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度(就是找最远的叶子节点):
 * <br>给定一个二叉树，找出其最大深度.
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
 * <br>返回它的最大深度 3 .
 *
 * @author Jerome Zhu
 * @since 2019.06.06 17:42
 */
public class LeetCode0104 {

    /**
     * 获取当前二叉树的最大深度(递归实现-深度优先遍历)
     *
     * @param root 根节点
     * @return 最大深度的值
     */
    public int maxDepth(TreeNode root) { // 1 ms 35.9 MB 战胜 94.67 % 的 java 提交记录
        // 最简单的问题,根节点为空,深度为0.
        if (root == null)
            return 0;

        // 获取当前节点子树的最大深度 + 1
        return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * 获取当前二叉树的最大深度(迭代实现-广度优先遍历)
     *
     * @param root 根节点
     * @return 最大深度的值
     */
    public int maxDepth1(TreeNode root) { // 2 ms 36.6 MB 战胜 15.47 % 的 java 提交记录
        if (root == null) return 0;

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode cur = queue.remove();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 9};
        TreeNode root = new TreeNode(arr);
        System.out.println(new LeetCode0104().maxDepth1(root));
    }
}
