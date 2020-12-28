package xin.jerome.study.algorithms.tree.leetcode;

import xin.jerome.study.domain.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * @author JeromeSoar
 * @since 2020年05月13日 10:10
 */
public class LeetCode0102 {

    /**
     * 利用队列存储元素(用一个元素做层级隔板): 返回一个树的层序遍历的结果
     * 时间复杂度 O(n) 空间复杂度 O(n)  执行出错  N/A  N/A
     * @param root 树的根节点
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 结果容器
        List<List<Integer>> resultList = new ArrayList<>();
        // 层级隔板
        TreeNode levelOver =  new TreeNode(-1);
        // 存储当前层级元素容器
        List<Integer> curLevel = new ArrayList<>();
        // 存在树节点容器
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队, 同时层级隔板元素入队
        queue.offer(root);
        queue.offer(levelOver);
        // 遍历队列
        while (!queue.isEmpty()) {
            // 元素出队
            TreeNode curNode = queue.poll();
            // 子元素不为空就入队
            if (curNode.left != null) {
                queue.offer(curNode.left);
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
            }
            // 当前元素添加到当前层级元素容器
            curLevel.add(curNode.val);
            // 如果下个元素是层级隔板元素
            if (queue.peek() == levelOver) {
                // 添加本层级元素到结果集
                resultList.add(curLevel);
                // 新建层级容器
                curLevel = new ArrayList<>();
                // 隔板元素出队
                queue.poll();
                // 如果队列不为空, 则隔板元素再入队
                if(!queue.isEmpty()) {
                    queue.offer(levelOver);
                }
            }
        }
        return resultList;
    }

    /**
     * 利用队列存储元素(双层遍历, 广度优先): 返回一个树的层序遍历的结果
     * 时间复杂度 O(n) 空间复杂度 O(n)  1 ms  40.2 MB
     * @param root 树的根节点
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Queue<TreeNode> queueContainer = new LinkedList<>();
        queueContainer.offer(root);
        while (!queueContainer.isEmpty()) {
            int curLevelSize = queueContainer.size();
            List<Integer> curLevelList = new ArrayList<>();
            for (int i = 0; i < curLevelSize; i++) {
                TreeNode curNode = queueContainer.poll();
                curLevelList.add(curNode.val);
                if(curNode.left != null)
                    queueContainer.offer(curNode.left);
                if (curNode.right != null)
                    queueContainer.offer(curNode.right);
            }
            resultList.add(curLevelList);
        }
        return resultList;
    }

    /**
     * 递归存储元素(深度优先): 存储元素时, 同时传入当前层级
     * 时间复杂度 O(n) 空间复杂度 O(n)  0 ms  39.8 MB
     * @param root 树的根节点
     */
    public List<List<Integer>> levelOrder3(TreeNode root) {
        // 存放结果集的容器
        List<List<Integer>> resultList = new ArrayList<>();

        // 开始存放根元素到对应的等级
        levelPutElement(resultList, root, 0);
        return resultList;
    }
    /**
     * 递归存储层级元素
     * @param resultList 结果集的容器
     * @param curNode 当前节点值
     * @param curLevel 当前节点对应的层级值
     */
    private void levelPutElement(List<List<Integer>> resultList, TreeNode curNode, int curLevel) {
        // 如果当前节点为空, 不做任何处理
        if (curNode == null)
            return;

        // 如果结果容器的 size 与 当前层级相等, 说明当前层级的容器还未初始化
        if (resultList.size() == curLevel) {
            // 初始化当前层级的容器
            resultList.add(new ArrayList<>());
        }
        // 将当前层级的元素存储到当前层级容器中
        resultList.get(curLevel).add(curNode.val);
        // 层级 + 1 , 存储子节点元素.
        curLevel++;
        levelPutElement(resultList, curNode.left, curLevel);
        levelPutElement(resultList, curNode.right, curLevel);
    }

    public static void main(String[] args) {
        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        TreeNode root = new TreeNode(nums);
        System.out.println(new LeetCode0102().levelOrder3(root));
    }
}
