package xin.jerome.study.datastructures.leetcode.linked;

import java.util.HashSet;
import org.junit.Test;
import xin.jerome.study.datastructures.leetcode.ListNode;

/**
 * 删除排序链表中的重复元素:
 * <br>给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * <p>示例 2:
 * <br>输入: 1->1->2->3->3
 * <br>输出: 1->2->3
 *
 * @author Jerome Zhu
 * @since 2019年12月23日 17:12
 */
public class LeetCode0083 {

    /**
     * 删除链表中的重复元素 (需要额外的空间存储唯一的元素)
     *
     * @param head 已head为链表头的链表
     * @return 删除重复元素后的链表
     */
    public ListNode deleteDuplicates(ListNode head) {// 3 ms    36.9 MB 已经战胜 5.47 % 的 java 提交记录
        // 用于存储唯一的元素值
        HashSet<Integer> uniqueElementSet = new HashSet<>();
        // 用于遍历的结点
        ListNode traversalNode = head;
        // 记录遍历结点的前置结点
        ListNode preNode = null;
        // 重头遍历结点
        while (traversalNode != null) {
            // 如果已经出现过当前结点的元素,则删除当前结点.
            if(uniqueElementSet.contains(traversalNode.val)) {
                preNode.next = traversalNode.next;
                traversalNode.next = null;
                traversalNode = preNode;
            } else {
                // 如果没有出现过当前结点,则加入唯一结点的集合中.
                uniqueElementSet.add(traversalNode.val);
            }
            // 记录当前结点的前置结点
            preNode = traversalNode;
            // 当前结点向后继续遍历
            traversalNode = traversalNode.next;
        }
        return head;
    }

    /**
     * 删除排序链表中的重复元素 : 题目给的是一个有序的链表,重复元素都是紧挨着的.
     *
     * @param head 已head为链表头的链表
     * @return 删除重复元素后的链表
     */
    public ListNode deleteOrderedLinkedDuplicates(ListNode head) {// 1 ms   37.9 MB 已经战胜 98.42 % 的 java 提交记录
        // 遍历链表的指针结点
        ListNode traversalNode = head;
        // 只有当前遍历结点和当前结点的下一个结点不为空的时候才需要继续遍历
        while (traversalNode != null && traversalNode.next != null) {
            // 如果当前结点的值和下一个结点的值相等则需要删除下一个结点
            if (traversalNode.val == traversalNode.next.val) {
                // 找到待删除的结点
                ListNode deletedNode = traversalNode.next;
                // 删除该结点
                traversalNode.next = deletedNode.next;
                // 释放该结点
                deletedNode.next = null;
            } else {// 如果不需要删除则向后遍历
                traversalNode = traversalNode.next;
            }
        }
        return head;
    }

    /**
     * 删除排序链表中的重复元素(递归思路的实现) : 题目给的是一个有序的链表,重复元素都是紧挨着的.
     *
     * @param head 已head为链表头的链表
     * @return 删除重复元素后的链表
     */
    public ListNode recursionDeleteOrderedLinkedDuplicates(ListNode head) {// 1 ms	36.6 MB 已经战胜 98.42 % 的 java 提交记录
        // 解决最小问题,空链表直接返回 null
        if(head == null) {
            return null;
        }

        // 先递归解决子链表的重复元素,获得一个没有重复元素的子链表
        ListNode subLinkedHead = recursionDeleteOrderedLinkedDuplicates(head.next);
        // 由于当前链表是有序的,所以只需要判断当前结点和子链表的头结点值是否相同.
        // 如果子链表的头结点的值与当前结点的值相等,则删除头结点
        if(subLinkedHead != null && head.val == subLinkedHead.val) {
            // 删除子链表的头结点
            head.next = subLinkedHead.next;
            // 释放头结点
            subLinkedHead.next = null;
        } else {// 如果子链表的头结点的值与当前结点的不相等,直接获取头结点
            head.next = subLinkedHead;
        }
        return head;
    }

    @Test
    public void testLeetCode0083() {
        int[] nodeElements = {1, 1, 2, 3, 3};
        ListNode head = new ListNode(nodeElements);
        System.out.println("删除前 :" + head.toString());
        recursionDeleteOrderedLinkedDuplicates(head);
        System.out.println("删除后 :" + head.toString());
    }
}
