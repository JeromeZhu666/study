package xin.jerome.study.datastructures.leetcode.tree;

import xin.jerome.study.datastructures.tree.SegmentTree;

/**
 * 区域和检索 - 数组不可变 <br>
 * 给定一个整数数组 nums,求出数组从索引i到j(i ≤ j)范围内元素的总和包含i,j两点.
 * <p>
 * 示例：<br>
 * 给定 nums = [-2, 0, 3, -5, 2, -1],求和函数为 sumRange().<br>
 * sumRange(0, 2) -> 1<br>
 * sumRange(2, 5) -> -1<br>
 * sumRange(0, 5) -> -3
 *
 * @author Jerome Zhu
 * @since 2019.07.13 20:14
 */
public class LeetCode0303 {
    /**
     * 第一种解法:数组和的统计,前index个数的和
     */
    private int[] sums;

    public LeetCode0303(int[] nums) {
        if (nums.length > 0) {
            sums = new int[nums.length + 1];
            sums[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }
    }

    /**
     * 获取索引[i,j]所有元素和
     */
    public int sumRange(int i, int j) { // 76 ms 41.5 MB 战胜 99.71 % 的 java 提交记录
        return sums[j + 1] - sums[i];
    }

    /**
     * 第二种解法:线段树解决
     */
    private SegmentTree<Integer> segmentTree;

    public LeetCode0303(Integer[] nums) {
        segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
    }

    /**
     * 获取索引[i,j]所有元素和
     */
    public int sumRange2(int i, int j) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("segmentTree is empty.");
        }
        return segmentTree.query(i, j);
    }

}
