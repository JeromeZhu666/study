package xin.jerome.study.datastructures.leetcode.array;

import java.util.HashMap;

/**
 * 两数之和:
 * <br>给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * <p>你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <br>示例:
 * <br>给定 nums = [2, 7, 11, 15], target = 9
 * <br>因为 nums[0] + nums[1] = 2 + 7 = 9
 * <br>所以返回 [0, 1]
 *
 * @author Jerome Zhu
 * @since 2019.06.03 20:46
 */
public class LeetCode0001 {

    /**
     * 暴力遍历  时间复杂度为 O(n^2)
     * 不是最优解
     *
     * @param nums   待选数组
     * @param target 目标值
     * @return 数组下标
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        // 每次比较都要进行一次加法操作   53 ms   37.4 MB
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (target == nums[i] + nums[j]) {
//                    result[0] = i;
//                    result[1] = j;
//                    return result;
//                }
//            }
//        }
        // 避免每次都要进行加操作  22 ms	36.8 MB
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                result[0] = i;
                int diff = target - nums[i];
                if (target == nums[j]) {
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 解决思路  利用哈希表 将元素作为key,角标作为value
     * 从哈希表中查询元素近乎常数  即O(1)
     *
     * @param nums   待选数组
     * @param target 目标值
     * @return 数组下标
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        // 每次put操作需要 ：计算一下hash值 + 并且两次从数组中取元素 + 两次差值计算    8 ms  38.3 MB 战胜 84.37 % 的 java 提交记录
//        for (int i = 0; i < nums.length; i++) {
//            int val = nums[i];
//            if (map.containsKey(target - val)) {
//                result[0] = map.get(target - val);
//                result[1] = i;
//                return result;
//            } else {
//                map.put(nums[i], i);
//            }
//        }
        // 优化掉了一次数组中取元素 + 一次差值计算    7 ms	37.1 MB 战胜 88.98 % 的 java 提交记录
//        for (int i = 0; i < nums.length; i++) {
//            int val = nums[i];
//            int diff = target - val;
//            if (map.containsKey(diff)) {
//                result[0] = map.get(diff);
//                result[1] = i;
//                return result;
//            } else {
//                map.put(val, i);
//            }
//        }
        // 优化掉数组的创建与赋值  3 ms	35.8 MB 战胜 99.41 % 的 java 提交记录
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int diff = target - val;
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(val, i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] indexes = new LeetCode0001().twoSum1(nums, target);
        System.out.println(String.format("[%d,%d]", indexes[0], indexes[1]));
    }
}
