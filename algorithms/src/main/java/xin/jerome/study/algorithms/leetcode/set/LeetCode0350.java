package xin.jerome.study.algorithms.leetcode.set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个数组的交集 II:
 * <br>给定两个数组,编写一个函数来计算它们的交集.
 * <p>示例:
 * <br>输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * <br>输出: [2,2]
 *
 * @author Jerome Zhu
 * @since 2019.07.06 14:12
 */
public class LeetCode0350 {

    /**
     * 求两个数组的交集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 返回两个数组的交集, 包含重复元素无序.
     */
    public int[] intersect(int[] nums1, int[] nums2) { // 10 ms 37.4 MB 战胜 41.35 % 的 java 提交记录

        Map<Integer, Integer> nums1Map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int key = nums1[i];
            if (nums1Map.containsKey(key)) {
                nums1Map.put(key, nums1Map.get(key) + 1);
            } else {
                nums1Map.put(key, 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int key = nums2[i];
            if (nums1Map.containsKey(key)) {
                res.add(key);
                int value = nums1Map.get(key);
                if(value == 1)
                    nums1Map.remove(key);
                else
                    nums1Map.put(key, value - 1);
            }
        }

        int[] result = new int[res.size()];
        int index = 0;
        for(int i : res)
            result[index ++] = i;

        return result;
    }

}
