package xin.jerome.study.algorithms.tree.leetcode;

import xin.jerome.study.datastructures.tree.SegmentTree;

/**
 * 区域和检索 - 数组可修改
 * <p>
 * 给定一个整数数组nums,求出数组从索引i到j(i ≤ j)范围内元素的总和,包含i,j两点.<br>
 * update(i, val)函数可以通过将下标为i的数值更新为 val,从而对数列进行修改.<br>
 * 
 * 示例:<br>
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9 <br>
 * update(1, 2) <br>
 * sumRange(0, 2) -> 8
 *
 * @author Jerome Zhu
 * @since 2019.07.13 22:17
 */
public class LeetCode0307 {

    private SegmentTree<Integer> segmentTree;

    public LeetCode0307(Integer[] nums) {
        if (nums.length > 0) {
            segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        }
    }

    public void update(int i, int val) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("segmentTree is empty.");
        }
        segmentTree.set(i, val);
    }

    public int sumRange(int i, int j) { // 142 ms 58.3 MB 战胜 57.11 % 的 java 提交记录
        if (segmentTree == null) {
            throw new IllegalArgumentException("segmentTree is empty.");
        }
        return segmentTree.query(i, j);
    }
}
