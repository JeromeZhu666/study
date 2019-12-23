package xin.jerome.study.datastructures.leetcode.linked;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
     * 删除链表中的重复元素 (基于虚拟头结点的改造)
     *
     * @param head 已head为链表头的链表
     * @return 删除重复元素后的链表
     */
    public ListNode deleteDuplicatesRemoldByDummyHead(ListNode head) {// 3 ms    36.9 MB 已经战胜 5.47 % 的 java 提交记录
        return new ListNode(0);
    }

    @Test
    public void testLeetCode0083() {
        int[] nodeElements = {1, 1, 2, 3, 3};
        ListNode head = new ListNode(nodeElements);
        System.out.println("删除前 :" + head.toString());
        deleteDuplicates(head);
        System.out.println("删除后 :" + head.toString());
    }
}
