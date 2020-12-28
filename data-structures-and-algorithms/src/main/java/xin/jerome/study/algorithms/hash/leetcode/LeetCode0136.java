package xin.jerome.study.algorithms.hash.leetcode;

import java.util.HashSet;

/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组, 除了某个元素只出现一次以外, 其余每个元素均出现两次. 找出那个只出现了一次的元素.
 * 
 * 示例 1:
 * 输入: [4, 1, 2, 1, 2]
 * 输出: 4
 *
 * @author JeromeSoar
 * @since 2020年05月14日 19:40
 */
public class LeetCode0136 {

    /**
     * HashSet 存储数据: 第一次出现就插入, 第二次出现就删除, 最后剩余的元素就是唯一的元素
     * 时间复杂度 O(n) 空间复杂度 O(n)  10 ms  40.1 MB
     * @param nums 非空整数数组
     */
    public int singleNumber(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            boolean result = numsSet.contains(num) ? numsSet.remove(num) : numsSet.add(num);
        }
        return numsSet.stream().findFirst().orElse(-1);
    }

    /**
     * 先排序再两两比较值: 重复数字肯定两两在一起, 唯一的数字和后面的数字肯定不一样.
     * 时间复杂度 O(n(n+1)) 空间复杂度 O(1)  153 ms  40.6 MB
     * @param nums 非空整数数组
     */
    public int singleNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 待插入的元素
            int temp = nums[i];
            // 待插入的位置
            int j = i;
            for (; j > 0 && temp < nums[j - 1]; j--) {
                // 待插入的元素比排好序的元素小,将排好序的元素后移.
                nums[j] = nums[j - 1];
            }
            // 已经遍历找到插入的位置
            nums[j] = temp;
        }
        for (int i = 0; i < nums.length - 1; i += 2) {
            if(nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * #位运算(异或运算):
     *   1.任何数和 0 做异或运算，结果仍然是原来的数.
     *   2.任何数和其自身做异或运算，结果是 0.
     *   3.异或运算满足交换律和结合律.
     * 时间复杂度 O(n) 空间复杂度 O(1)  1 ms  41 MB
     * @param nums 非空整数数组
     */
    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums)
            result ^= num;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new LeetCode0136().singleNumber1(nums));
    }
}
