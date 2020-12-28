package xin.jerome.study.algorithms.hash.leetcode;


import java.util.HashMap;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k, 你需要找到该数组中和为 k 的连续的子数组的个数.
 * <p>
 * 示例 1 :
 * 输入: nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况.
 * <p>
 * 说明 :
 * 数组的长度为 [1, 20,000].
 * 数组中元素的范围是 [-1000, 1000] , 且整数 k 的范围是 [-1e7, 1e7].
 *
 * @author JeromeSoar
 * @since 2020年05月15日 10:59
 */
public class LeetCode0560 {

    /**
     * 暴力累加: 利用哈希表存储结果值出现的次数
     * 时间复杂度 O(n^2) 空间复杂度 O(n)  超出时间限制  N/A  N/A
     *
     * @param nums 数组
     * @param k    整数 k
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                resultMap.put(count, resultMap.getOrDefault(count, 0) + 1);
            }
        }
        return resultMap.getOrDefault(k, 0);
    }

    /**
     * #存储前缀和: 利用 HashMap 存储前面数据和结果值.
     * 时间复杂度 O(n) 空间复杂度 O(n)  408 ms  41 MB
     *
     * @param nums 数组
     * @param k    整数 k
     */
    public int subarraySum1(int[] nums, int k) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                count += nums[j];
                if (count == k)
                    result++;
            }
        }
        return result;
    }

    /**
     * #暴力累加: 利用临时变量存储结果值出现的次数.
     * 如果 sum(0, j) - sum(0, i) == k ,说明 (i, j) 这个区间的和为 k.
     * 因为 sum(0, i) 的值在计算 sum(0, j) 之前计算过, 所以只需要判断 sum(0, j) - k 的结果值是否出现过.
     * 时间复杂度 O(n^2) 空间复杂度 O(1)  21 ms  40.5 MB
     *
     * @param nums 数组
     * @param k    整数 k
     */
    public int subarraySum2(int[] nums, int k) {
        // 初始化存储 sum(0, i) 值的 Map
        HashMap<Integer, Integer> preElementSumMap = new HashMap<>();
        preElementSumMap.put(0, 1);

        // 计数的变量
        int countResult = 0;
        int preElementSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 累加 (0, i) 元素的值
            preElementSum += nums[i];
            // 如果出现过 preElementSum - k , 说明有符合的区间, 类加上出现的次数
            if (preElementSumMap.containsKey(preElementSum - k))
                countResult += preElementSumMap.get(preElementSum - k);

            // 存放当前的 (0, i) 元素的值, 出现次数累加 1.
            preElementSumMap.put(preElementSum, preElementSumMap.getOrDefault(preElementSum, 0) + 1);
        }
        return countResult;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1, 1};
        System.out.println(new LeetCode0560().subarraySum2(nums, 0));
    }
}
