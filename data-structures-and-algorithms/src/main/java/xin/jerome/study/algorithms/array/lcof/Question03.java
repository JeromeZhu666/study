package xin.jerome.study.algorithms.array.lcof;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题03. 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内. 数组中某些数字是重复的, 但不知道有几个数字重复了, 
 * 也不知道每个数字重复了几次. 请找出数组中任意一个重复的数字. 
 *
 * 示例 1: 
 * 输入: 
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出: 2 或 3
 *
 * 限制: 2 <= n <= 100000
 *
 * @author JeromeSoar
 * @since 2020年04月25日 17:41
 */
public class Question03 {

    /**
     * 暴力求解: 双重遍历, 找到第一个重复元素返回
     * 时间复杂度O(n^2)  空间复杂度O(1)  2636 ms  48.1 MB
     *
     * @param nums 含有重复元素的数组
     * @return 任意一个重复的元素
     */
    public int findRepeatNumber(int[] nums) {
        // 第一次遍历取出当前遍历的元素
        for (int i = 0; i < nums.length; i++) {
            // 第二次遍历判断两元素是否相等
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    /**
     * 利用哈希碰撞: 可以将数据存放入一个临时的 HashSet 中, 看是否数据插入成功.
     * 时间复杂度O(n)  空间复杂度O(n)  5 ms  49.9 MB
     *
     * @param nums 含有重复元素的数组
     * @return 任意一个重复的元素
     */
    public int findRepeatNumber1(int[] nums) {
        // 用于临时存储元素的 HashSet
        Set<Integer> tempSet = new HashSet<>();
        // 遍历数组, 将数据插入 HashSet
        for (int i = 0; i < nums.length; i++) {
            // 因为在 HashSet 在插入元素的时候, 会对插入的值做 Hash 来确定插入的位置.
            // 所发现 Hash 碰撞的时间复杂度是  O(1)
            if (!tempSet.add(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 模仿哈希碰撞: 一个长度为 n 的数组, 数组中的数据 e 满足: 0 <= e <= n - 1, 可以申请大小为 n 数组.
     * 判断数组中的元素是否为 0 (int 变量默认值为 0).
     * 时间复杂度O(n)  空间复杂度O(n)  1 ms  47.2 MB
     *
     * @param nums 含有重复元素的数组
     * @return 任意一个重复的元素
     */
    public int findRepeatNumber2(int[] nums) {
        // 初始化一个容量为 nums.length 的数组
        int[] tempArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 模仿 Hash 表的碰撞
            if(tempArray[nums[i]] == 0) {
                tempArray[nums[i]] = 1;
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 原地交换(破坏了原数组): 一个长度为 n 的数组, 数组中的数据 e 满足: 0 <= e <= n - 1.
     * 如果数组中没有重复数据, 数组中的元素可以作为原数组的角标存储.
     * 时间复杂度O(n)  空间复杂度O(1)  1 ms  47.6 MB
     *
     * @param nums 含有重复元素的数组
     * @return 任意一个重复的元素
     */
    public int findRepeatNumber3(int[] nums) {
        // 初始化一个临时交换对象
        int temp;
        // 遍历数组, 将每个元素归为到该元素值对应的数组中位置
        for (int i = 0; i < nums.length; i++) {
            // 当前元素 nums[i] 不应该在 i 这个位置需要交换到应对应的位置.
            // 直至下标 i 与元素值 nums[i] 相等为止.
            while (i != nums[i]) {
                // 如果当前元素 nums[i] 和待交换的元素 nums[nums[i]] 相等, 则发生碰撞, 即找到重复值.
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                // 如果当前元素 nums[i] 和待交换的元素 nums[nums[i]] 不相等, 则发生交换
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(new Question03().findRepeatNumber3(nums));
    }
}
