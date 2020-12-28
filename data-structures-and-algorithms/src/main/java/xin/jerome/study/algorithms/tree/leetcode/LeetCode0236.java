package xin.jerome.study.algorithms.tree.leetcode;

import xin.jerome.study.domain.node.TreeNode;

import java.util.*;

/**
 * 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先.
 *
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3
 *
 * 说明:
 * 1、所有节点的值都是唯一的.
 * 2、p、q 为不同节点且均存在于给定的二叉树中.
 *
 * @author Jerome Zhu
 * @since 2020年05月10日 13:47
 */
public class LeetCode0236 {

    /**
     * 广度优先遍历: 找到该树中两个指定节点的最近公共祖先, 广度优先遍历子树确定其父亲节点.
     * 时间复杂度 O(n), 空间复杂度 O(N)  7 ms  42.3 MB
     *
     * @param root 树的根节点
     * @param p 子节点 p
     * @param q 子节点 q
     * @return 节点 p 和 q 最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 后续遍历到节点所在的子树
        postOrder(root, p, q);
        return resultNode;
    }

    // 临时存储结果节点
    private TreeNode resultNode;
    /** 后续遍历树(广度优先遍历) */
    private boolean postOrder(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空, 返回false
        if (root == null)
            return false;

        // 判断左子树中是否有 p 或 q 其中一个节点
        boolean leftSon = postOrder(root.left, p, q);
        // 判断右子树中是否有 p 或 q 其中一个节点
        boolean rightSon = postOrder(root.right, p, q);

        // 如果左右子树中都有其中一个节点 或 当前节点是其中一个节点并且左右子树中有其中一个节点, 则当前节点就是最近公共祖先
        if ((leftSon && rightSon) || (((root.val == p.val || root.val == q.val) && (leftSon || rightSon)))) {
            resultNode = root;
        }
        // 返回当前节点或子节点中是否有 p 或 q 其中一个节点
        return ((root.val == p.val || root.val == q.val) || leftSon || rightSon);
    }

    /**
     * 找到该树中两个指定节点的最近公共祖先, 利用 HashMap 存储所有节点值所对应的父节点, 再用寻找的节点往上跳.
     * 时间复杂度 O(n), 空间复杂度 O(N)  12 ms  42.8 MB
     *
     * @param root 树的根节点
     * @param p 子节点 p
     * @param q 子节点 q
     * @return 节点 p 和 q 最近公共祖先
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 将所有节点值作为 key, 父节点作为 value 放入 map 中.
        Map<Integer, TreeNode> parentsMap = new HashMap<>();
        preOrderTreeNode(root, parentsMap);

        // 存放访问过的 p 节点以及 p 节点所有父节点值
        Set<Integer> pParentsSet = new HashSet<>();
        // 临时存放当前正在遍历的节点
        TreeNode curNode = p;
        // 开始遍历节点 p
        while (curNode != null) {
            // 将访问过的当前节点存储
            pParentsSet.add(curNode.val);
            // 继续向当前节点的父节点访问
            curNode = parentsMap.getOrDefault(curNode.val, null);
        }

        curNode = q;
        // 开始遍历节点 q
        while (curNode != null) {
            // 如果 p 节点已经遍历过当前节点, 则当前节点就是要找的最近共同祖先
            if (pParentsSet.contains(curNode.val)) {
                return curNode;
            }
            // 继续向当前节点的父节点访问
            curNode = parentsMap.getOrDefault(curNode.val, null);
        }

        return root;
    }
    /** 前序遍历二叉树: 将当前节点值作为 key, 父节点作为 value 放入 map 中 */
    private void preOrderTreeNode(TreeNode root, Map<Integer, TreeNode> parentsMap) {
        if (root.left != null) {
            parentsMap.put(root.left.val, root);
            preOrderTreeNode(root.left, parentsMap);
        }
        if (root.right != null) {
            parentsMap.put(root.right.val, root);
            preOrderTreeNode(root.right, parentsMap);
        }
    }

    /**
     * 后续遍历返回节点: 在子树中寻找是否存在 p 或 q 节点如果存在则返回节点,
     * 当左右子树都返回节点时, 当前节点就是 p 和 q 节点的最近公共祖先.
     * 时间复杂度 O(n), 空间复杂度 O(N)  7 ms  42.5 MB
     *
     * @param root 树的根节点
     * @param p 子节点 p
     * @param q 子节点 q
     * @return 节点 p 和 q 最近公共祖先
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空 或 当前节点是 p 和 q 其中一个直接返回
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        // 遍历左子树获取是否存在 p 或 q 节点
        TreeNode leftHasNode = lowestCommonAncestor2(root.left, p, q);
        // 遍历右子树获取是否存在 p 或 q 节点
        TreeNode rightHasNode = lowestCommonAncestor2(root.right, p, q);

        /*// 如果左子树中没有 p 或 q 其中一个节点, 返回右子树的结果
        if (leftHasNode == null) {
            return rightHasNode;
        }
        // 如果右子树中没有 p 或 q 其中一个节点, 返回左子树的结果
        if (rightHasNode == null) {
            return leftHasNode;
        }
        // 如果两个子树中都有 p 或 q 其中一个节点, 则当前节点就是最近公共祖先节点
        return root;*/
        // 上面代码写法优化
        return leftHasNode == null ? rightHasNode : rightHasNode == null ? leftHasNode : root;
    }


    public static void main(String[] args) {
        Integer[] nums = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = new TreeNode(nums);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        System.out.println(new LeetCode0236().lowestCommonAncestor2(root, p, q));
    }
}
