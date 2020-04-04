package xin.jerome.study.algorithms.leetcode.set;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 两个数组的交集(不包含重复元素):
 * <br>给定两个数组,编写一个函数来计算它们的交集.
 * <p>示例:
 * <br>输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * <br>输出: [2]
 *
 * @author Jerome Zhu
 * @since 2019.06.30 23:16
 */
public class LeetCode0349 {

    /**
     * 求两个数组的交集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 返回两个数组的交集,不包含重复元素无序.
     */
    public int[] intersection(int[] nums1, int[] nums2) { // 17 ms 37.9 MB  战胜 18.77 % 的 java 提交记录

        // 将数组1放入到Set中去
        TreeSet<Integer> nums1Set = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++)
            nums1Set.add(nums1[i]);
        // 将数组2放入到Set中去
        TreeSet<Integer> nums2Set = new TreeSet<>();
        for (int i = 0; i < nums2.length; i++)
            nums2Set.add(nums2[i]);
        nums1Set.retainAll(nums2Set);
        int[] res = new int[nums1Set.size()];
        int index = 0;
        for(int i : nums1Set)
            res[index ++] = i;

        return res;
    }

    /**
     * 求两个数组的交集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 返回两个数组的交集,不包含重复元素无序.
     */
    public int[] intersection1(int[] nums1, int[] nums2) { // 16 ms 37.1 MB  战胜 20.04 % 的 java 提交记录

        // 将数组1放入到Set中去
        TreeSet<Integer> nums1Set = new TreeSet<>();
        for (int i = 0; i < nums1.length; i++)
            nums1Set.add(nums1[i]);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (nums1Set.contains(nums2[i])) {
                result.add(nums2[i]);
                nums1Set.remove(nums2[i]);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
