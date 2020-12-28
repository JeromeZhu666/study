package xin.jerome.study.algorithms.queue.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 前K个高频元素<br>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1: <br>
 * 输入: nums = [1,1,1,2,2,3], k = 2 <br>
 * 输出: [1,2]
 *
 * @author Jerome Zhu
 * @since 2019.07.04 22:48
 */
public class LeetCode0347 {

    /**
     * 统计数组中前K个高频的元素 104 ms 46.6 MB 战胜 13.82 % 的 java 提交记录
     * 
     * @param nums
     *            统计源数组
     * @param k
     *            前k个元素
     * @return 前k个元素的 {@code List} 集合
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 先用map对元素的频率进行统计
        HashMap<Integer, Integer> numsMap = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (numsMap.containsKey(key)) {
                numsMap.put(key, numsMap.get(key) + 1);
            } else {
                numsMap.put(key, 1);
            }
        }
        // 使用优先队列,对统计过的元素根据频次作为优先级
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> numsMap.get(b) - numsMap.get(a));
        priorityQueue.addAll(numsMap.keySet());
        // 取出前K个优先级最高的元素
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.poll());
        }
        return result;
    }

    /**
     * 统计数组中前K个高频的元素 113 ms 47.7 MB 战胜 8.82 % 的 java 提交记录
     * 
     * @param nums
     *            统计源数组
     * @param k
     *            前k个元素
     * @return 前k个元素的 {@code List} 集合
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {
        // 先用map对元素的频率进行统计
        HashMap<Integer, Integer> numsMap = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (numsMap.containsKey(key)) {
                numsMap.put(key, numsMap.get(key) + 1);
            } else {
                numsMap.put(key, 1);
            }
        }
        // 使用优先队列,对统计过的元素根据频次作为优先级
        // 优化: 只维护前k个元素 利用最小堆(PriorityQueue)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> numsMap.get(a) - numsMap.get(b));
        for (Integer key : numsMap.keySet()) {
            if (priorityQueue.size() < k) {
                // 优先队列还没维护够K个元素,直接入队.
                priorityQueue.add(key);
            } else {
                // 判断是否大于当前最小堆顶部元素
                if (numsMap.get(key) > numsMap.get(priorityQueue.peek())) {
                    // 如果当前key的频次大于优先队列中最小频次的元素,key入队
                    priorityQueue.remove();
                    priorityQueue.add(key);
                }

            }
        }
        // 将优先队列中所有元素存放到List中
        List<Integer> result = priorityQueue.stream().collect(Collectors.toList());
        return result;
    }

    /**
     * 统计数组中前K个高频的元素 104 ms 45.3 MB 战胜 13.82 % 的 java 提交记录
     * 
     * @param nums
     *            统计源数组
     * @param k
     *            前k个元素
     * @return 前k个元素的 {@code List} 集合
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        // 先用map对元素的频率进行统计
        HashMap<Integer, Integer> numsMap = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (numsMap.containsKey(key)) {
                numsMap.put(key, numsMap.get(key) + 1);
            } else {
                numsMap.put(key, 1);
            }
            numsMap.put(key, numsMap.getOrDefault(key, 0) + 1);
        }
        // 使用优先队列,对统计过的元素根据频次作为优先级
        // 优化: 只维护前k个元素 利用最小堆(PriorityQueue)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> numsMap.get(a) - numsMap.get(b));
        for (Integer key : numsMap.keySet()) {
            if (priorityQueue.size() < k) {
                // 优先队列还没维护够K个元素,直接入队.
                priorityQueue.add(key);
            } else {
                // 判断是否大于当前最小堆顶部元素
                if (numsMap.get(key) > numsMap.get(priorityQueue.peek())) {
                    // 如果当前key的频次大于优先队列中最小频次的元素,key入队
                    priorityQueue.remove();
                    priorityQueue.add(key);
                }

            }
        }
        // 将优先队列中所有元素存放到List中
        List<Integer> result = priorityQueue.stream().collect(Collectors.toList());
        return result;
    }

    /**
     * 统计数组中前K个高频的元素 104 ms 46.6 MB 战胜 13.82 % 的 java 提交记录
     *
     * @param nums
     *            统计源数组
     * @param k
     *            前k个元素
     * @return 前k个元素的 {@code List} 集合
     */
    public List<Integer> topKFrequent3(int[] nums, int k) {
        // 先用map对元素的频率进行统计
        HashMap<Integer, Integer> numsMap = new HashMap<>(16);
        for (int key : nums) {
            numsMap.put(key, numsMap.getOrDefault(key, 0) + 1);
        }
        return numsMap.keySet().stream().sorted((a, b) -> numsMap.get(b) - numsMap.get(a)).limit(k)
            .collect(Collectors.toList());
    }

    @Test
    public void test() {
        int[] nums = {3, 0, 1, 0};
        System.out.println(topKFrequent1(nums, 1));
    }
}
