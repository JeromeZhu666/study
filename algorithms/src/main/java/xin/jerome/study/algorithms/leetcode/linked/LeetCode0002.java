package xin.jerome.study.algorithms.leetcode.linked;

import xin.jerome.study.algorithms.leetcode.ListNode;

import java.util.HashMap;

/**
 * 两数相加:
 * <br>给出两个非空的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储一位数字。
 *
 * <p>如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * <p>您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <br>示例:
 * <br>输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * <br>输出：7 -> 0 -> 8
 * <br>原因：342 + 465 = 807
 *
 * @author Jerome Zhu
 * @since 2019.06.03 22:08
 */
public class LeetCode0002 {

    /**
     * 解决思路将每一位相加的值先放入map，然后再map中重新构造链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {// 15 ms   43.5 MB 战胜 44.72 % 的 java 提交记录
        // 将相加的结果放到map中存储
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; l1 != null || l2 != null; i++) {
            if (l1 == null) {
                map.put(i, l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                map.put(i, l1.val);
                l1 = l1.next;
            } else {
                map.put(i, l1.val + l2.val);
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        // 创建虚拟头结点，将相加结果转换成链表
        ListNode dummyHead = new ListNode(-1);
        ListNode curNode = dummyHead;
        for (int i = 1; i <= map.size(); i++) {
            if (map.get(i) > 9) {
                curNode.next = new ListNode(map.get(i) % 10);
                map.put(i + 1, map.get(i + 1) == null ? 1 : map.get(i + 1) + 1);
            } else {
                curNode.next = new ListNode(map.get(i));
            }
            curNode = curNode.next;
        }
        return dummyHead.next;
    }

    /**
     * 解决思路将每一位相加的值先放入map，然后再map中重新构造链表
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果链表
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 创建虚拟头结点
        ListNode dummyHead = new ListNode(0);
        // 创建遍历结点
        ListNode cur = dummyHead;
        // 同时循环两个链表(代码过多  代码冗余)     11 ms   41.2 MB 战胜 63.03 % 的 java 提交记录
//        while (l1 != null || l2 != null) {
//            if(cur.next == null) {
//                cur.next = new ListNode(0);
//            }
//            cur = cur.next;
//            if (l1 == null) {
//                int sum = cur.val + l2.val;
//                if (sum > 9) {
//                    cur.val = sum % 10;
//                    cur.next = new ListNode(1);
//                } else {
//                    cur.val = sum;
//                }
//                l2 = l2.next;
//            } else if (l2 == null) {
//                int sum = cur.val + l1.val;
//                if (sum > 9) {
//                    cur.val = sum % 10;
//                    cur.next = new ListNode(1);
//                } else {
//                    cur.val = sum;
//                }
//                l1 = l1.next;
//            } else {
//                int sum = cur.val + l1.val + l2.val;
//                if (sum > 9) {
//                    cur.val = sum % 10;
//                    cur.next = new ListNode(1);
//                } else {
//                    cur.val = sum;
//                }
//                l1 = l1.next;
//                l2 = l2.next;
//            }
//        }
        // 优化了部分代码冗余        8 ms    38.4 MB 战胜 98.78 % 的 java 提交记录
        while (l1 != null || l2 != null) {
            if (cur.next == null)
                cur.next = new ListNode(0);
            cur = cur.next;

            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = cur.val + val1 + val2;
            if (sum > 9) {
                cur.val = sum % 10;
                cur.next = new ListNode(1);
            } else {
                cur.val = sum;
            }
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6};
        int[] arr2 = {5, 6, 4};
        ListNode result = new LeetCode0002().addTwoNumbers1(new ListNode(arr1), new ListNode(arr2));
        System.out.println(result);
    }
}
