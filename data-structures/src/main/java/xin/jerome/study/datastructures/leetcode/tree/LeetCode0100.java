package xin.jerome.study.datastructures.leetcode.tree;

import xin.jerome.study.datastructures.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 相同的树:
 * <br>给定两个二叉树，编写一个函数来检验它们是否相同。
 * <br>如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * <p>示例:
 * <br>输入:       1         1
 * <br>          / \       / \
 * <br>         2   3     2   3
 * <br>        [1,2,3],   [1,2,3]
 * <br>输出: true
 *
 * @author Jerome Zhu
 * @since 2019.06.06 10:58
 */
public class LeetCode0100 {

    /**
     * 验证两个树的节点和值是否相同(递归实现)
     *
     * @param p 树的根节点
     * @param q 树的根节点
     * @return 两个树是否相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 解决最简单的问题(只有一个节点) 判断逻辑过于复杂    1 ms 33.8 MB 战胜 89.51 % 的 java 提交记录
//        if (p == null && q != null || p != null && q == null)
//            return false;
//        if (p != null && q != null) {
//            if (p.val != q.val)
//                return false;
//
//            if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right))
//                return false;
//        }
//        return true;
        // 优化判断逻辑   1 ms 33.6 MB 战胜 89.51 % 的 java 提交记录
        if (p == null && q == null) // 两节点都为空
            return true;
        if (p == null || q == null) // 两节点只有一个为空
            return false;
        // 只剩下两节点都不为空的结果
        if (p.val != q.val) //两个节点值不相等
            return false;

        // 简单问题已解决,只剩下递归逻辑.即:如果两节点的子节点都相等,则以p和q为根节点的树是相等的.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 验证两个树的节点和值是否相同(广度优先遍历)
     *
     * @param p 树的根节点
     * @param q 树的根节点
     * @return 两个树是否相同
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {// 1 ms 33.2 MB 战胜 89.51 % 的 java 提交记录
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);
        while (!pQueue.isEmpty()) {
            TreeNode pNode = pQueue.remove();
            TreeNode qNode = qQueue.remove();
            if (pNode == null && qNode != null || pNode != null && qNode == null)
                return false;
            if (pNode != null && qNode != null) {
                if (pNode.val != qNode.val)
                    return false;
                pQueue.add(pNode.left);
                pQueue.add(pNode.right);
                qQueue.add(qNode.left);
                qQueue.add(qNode.right);
            }
        }
        if (!qQueue.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        Integer[] pArr = {1, 2};
        Integer[] qArr = {1, null, 2};
        TreeNode p = new TreeNode(pArr);
        TreeNode q = new TreeNode(qArr);
        System.out.println("p树:" + p);
        System.out.println("q树:" + q);
        System.out.println(new LeetCode0100().isSameTree1(p, q));
    }
}
