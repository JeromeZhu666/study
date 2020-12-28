package xin.jerome.study.algorithms.linked.lcof;

import xin.jerome.study.domain.node.ListNode;

import java.util.Arrays;
import java.util.Stack;


/**
 * 面试题06. 从尾到头打印链表
 *
 * @author JeromeSoar
 * @since 2020年05月16日 17:45
 */
public class Question06 {

    /**
     * 递归遍历: 采用边遍历, 边计数的方式.
     * 时间复杂度 O(n) 空间复杂度 O(n)  0 ms  40.8 MB
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        // 递归遍历打印数组
        reversePrint(head, 0);
        if(nums == null) {
            nums = new int[]{};
        }
        return nums;
    }
    /** 存储反转的元素数据 */
    private int[] nums = null;
    /** 递归遍历链表节点, 并获取节点个数 */
    private int reversePrint(ListNode head, int nodeNums) {
        // 如果遍历到空节点, 说明已经将所有节点计数, 返回节点数量.
        if (head == null)
            return nodeNums;

        // 节点数量累加
        nodeNums ++;
        // 获取所有节点数量累加值
        int countNums = reversePrint(head.next, nodeNums);
        // 如果 nums 还未初始化, 则说明当前处于最后一个节点.
        if (nums == null) {
            // 初始化 nums , 大小为 countNums 节点数量.
            nums = new int[countNums];
        }
        // 所有节点数 - 当前节点位置 = 反转后的在数组位置
        nums[countNums - nodeNums] = head.val;
        // 返回所有节点数量累加值
        return countNums;
    }

    /**
     * 利用栈空间临时存储: 采用遍历元素入栈, 根据栈的 size 创建数组.
     * 时间复杂度 O(n) 空间复杂度 O(n)  2 ms  40.4 MB
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {
        // 申请栈空间
        Stack<Integer> nodeStack = new Stack<>();
        // 遍历游标
        ListNode curNode = head;
        // 所有元素进栈
        while (curNode != null) {
            nodeStack.push(curNode.val);
            curNode = curNode.next;
        }

        // 初始化结果集
        int[] nums = new int[nodeStack.size()];
        // 所有元素出栈, 赋值
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nodeStack.pop();
        }
        return nums;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ListNode head = new ListNode(nums);
        int[] result = new Question06().reversePrint1(head);
        System.out.println(Arrays.toString(result));
    }
}
