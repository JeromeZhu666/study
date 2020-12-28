package xin.jerome.study.algorithms.linked.leetcode;

import org.junit.Test;
import xin.jerome.study.domain.node.ListNode;

/**
 * 删除排序链表中的重复元素 II :
 * <br>给定一个排序链表,删除所有含有重复数字的节点,只保留原始链表中没有重复出现的数字.
 *
 * <p>示例 1:
 * <br>输入: 1->2->3->3->4->4->5
 * <br>输出: 1->2->5
 *
 * @author Jerome Zhu
 * @since 2019年12月24日 18:05
 */
public class LeetCode0082 {

    /**
     * 删除排序链表中的重复元素 : 题目给的是一个有序的链表,重复元素都是紧挨着的.
     *
     * @param head 已head为链表头的链表
     * @return 删除重复元素后的链表
     */
    public ListNode deleteDuplicates(ListNode head) {// 2 ms    36.7 MB 已经战胜 11.80 % 的 java 提交记录
        // 构造虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 记录遍历当前节点的前节点
        ListNode preCurNode = dummyHead;
        // 记录当前节点
        ListNode curNode = head;
        // 当前节点和当前节点的下一个节点都不为空时遍历
        while (curNode != null && curNode.next != null) {
            // 如果当前节点和下一个节点值相同则删除当前节点以及相同值得节点
            if(curNode.val == curNode.next.val) {
                Integer deletedVal = curNode.val;
                while (curNode != null && deletedVal == curNode.val) {
                    curNode = curNode.next;
                }
                preCurNode.next = curNode;
            } else { // 值不相同向下一个节点遍历
                preCurNode = curNode;
                curNode = curNode.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 删除排序链表中的重复元素 : 题目给的是一个有序的链表,重复元素都是紧挨着的.
     *
     * @param head 已head为链表头的链表
     * @return 删除重复元素后的链表
     */
    public ListNode deleteDuplicatesRemold(ListNode head) {// 1 ms  36.8 MB 已经战胜 98.25 % 的 java 提交记录
        // 构造虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 记录遍历当前节点的前节点
        ListNode preCurNode = dummyHead;
        // 当前节点和当前节点的下一个节点都不为空时遍历
        while (head != null && head.next != null) {
            // 如果当前节点和下一个节点值相同则删除当前节点以及相同值得节点
            if(head.val == head.next.val) {
                Integer deletedVal = head.val;
                while (head != null && deletedVal == head.val) {
                    head = head.next;
                }
                preCurNode.next = head;
            } else { // 值不相同向下一个节点遍历
                preCurNode = head;
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    @Test
    public void testLeetCode0082() {
        int[] nodeElements = {1, 1, 1, 1, 1, 4, 5};
        ListNode head = new ListNode(nodeElements);
        System.out.println("删除前 :" + head.toString());
        System.out.println("删除后 :" + deleteDuplicates(head).toString());
    }
}
