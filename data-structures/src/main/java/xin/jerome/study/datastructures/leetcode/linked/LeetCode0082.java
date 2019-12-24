package xin.jerome.study.datastructures.leetcode.linked;

import org.junit.Test;
import xin.jerome.study.datastructures.leetcode.ListNode;

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

    public ListNode deleteDuplicates(ListNode head) {
        // 构造虚拟头结点
        ListNode preCurNode = new ListNode(-1);
        preCurNode.next = head;
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            if(curNode.val == curNode.next.val) {
                Integer deletedVal = curNode.val;
                while (curNode != null && deletedVal == curNode.val) {
                    curNode = curNode.next;
                }
                preCurNode.next = curNode;
            } else {
                preCurNode = curNode;
                curNode = curNode.next;
            }
        }
        return head;
    }

    @Test
    public void testLeetCode0082() {
        int[] nodeElements = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = new ListNode(nodeElements);
        System.out.println("删除前 :" + head.toString());
        deleteDuplicates(head);
        System.out.println("删除后 :" + head.toString());
    }
}
