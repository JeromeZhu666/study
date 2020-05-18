package xin.jerome.study.algorithms.leetcode.array;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums, 请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）, 并返回该子数组所对应的乘积.
 *
 * 示例 1:
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6.
 *
 * @author JeromeSoar
 * @since 2020年05月18日 21:27
 */
public class LeetCode0152 {

    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE, curMin = 1, curMax = 1;
        for (int i = 0; i < nums.length; i++) {

            int curNum = nums[i];
            int maxR = curNum * curMax;
            int minR = curNum * curMin;
            curMax = Math.max(maxR, Math.max(curNum, minR));
            curMin = Math.min(maxR, Math.min(curNum, minR));

            result = Math.max(result, curMax);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        int[] nums1 = {-2,0,-1};
        System.out.println(new LeetCode0152().maxProduct(nums));
    }
}
