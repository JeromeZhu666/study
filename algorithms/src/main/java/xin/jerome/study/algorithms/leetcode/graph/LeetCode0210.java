package xin.jerome.study.algorithms.leetcode.graph;

import java.util.*;

/**
 * 210. 课程表 II
 * 现在你总共有 n 门课需要选, 记为 0 到 n-1. 
 * 在选修某些课程之前需要一些先修课程.  例如, 想要学习课程 0 , 你需要先完成课程 1 , 我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件, 返回你为了学完所有课程所安排的学习顺序. 
 * 可能会有多个正确的顺序, 你只要返回一种就可以了. 如果不可能完成所有课程, 返回一个空数组. 
 *
 * 示例 2:
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程. 要学习课程 3, 你应该先完成课程 1 和课程 2. 并且课程 1 和课程 2 都应该排在课程 0 之后. 
 *      因此, 一个正确的课程顺序是 [0,1,2,3] . 另一个正确的排序是 [0,2,1,3] . 
 *
 * @author JeromeSoar
 * @since 2020年05月17日 21:45
 */
public class LeetCode0210 {

    /**
     * 广度优先遍历: 把当前课程被依赖的次数计做入度, 首先处理入度为 0 的课程, 放入队列.
     * 然后入度为 0 的课程先出队, 被依赖课程入度减 1 .
     * 时间复杂度 O(m + n) 空间复杂度 O(m + n) 其中 m 为依赖的深度  12 ms  40.5 MB
     * @param numCourses 课程数
     * @param prerequisites 前置需要课程关系
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 构造有向图, 构建依赖
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        // 记录各个节点的入度(引用次数)
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            // 后置课程
            int sufCourse = prerequisite[0];
            // 学习后置课程的前置课程
            int preCourse = prerequisite[1];
            // 存储前置课程学习完可以学习的后置课程列表
            List<Integer> srcList = courseMap.getOrDefault(preCourse, new ArrayList<>());
            srcList.add(sufCourse);
            courseMap.put(preCourse, srcList);
            // 后置课程的入度加 1
            indegree[sufCourse]++;
        }

        // 当前入度为 0 的课程入队, 即没有前置课程的课程.
        Queue<Integer> zeroIndegree = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                zeroIndegree.offer(i);
        }

        // 存储结果集
        List<Integer> result = new ArrayList<>();
        while (!zeroIndegree.isEmpty()) {
            // 当前入度为 0 的课程出队
            Integer curZeroIndegree = zeroIndegree.poll();
            // 当前课程进入结果集
            result.add(curZeroIndegree);
            // 对后置课程进行入度减 1
            for (Integer courseNo : courseMap.getOrDefault(curZeroIndegree, new ArrayList<>())) {
                if (--indegree[courseNo] == 0)
                    zeroIndegree.offer(courseNo);
            }
        }

        // 如果课程路径锁经历的节点 与 课程总数不符, 则不可能完成所有课程, 返回一个空数组.
        if (result.size() != numCourses)
            result.clear();
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * todo 深度优先遍历:
     *
     * @param numCourses 课程数
     * @param prerequisites 前置需要课程关系
     */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        return new int[]{};
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(new LeetCode0210().findOrder(4, prerequisites)));
    }
}
