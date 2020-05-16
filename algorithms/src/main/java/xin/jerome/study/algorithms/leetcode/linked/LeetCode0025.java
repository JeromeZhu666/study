package xin.jerome.study.algorithms.leetcode.linked;

import xin.jerome.study.algorithms.leetcode.ListNode;


/**
 * 25. K 个一组翻转链表
 * 给你一个链表, 每 k 个节点一组进行翻转, 请你返回翻转后的链表.
 * k 是一个正整数, 它的值小于或等于链表的长度.
 * 如果节点总数不是 k 的整数倍, 那么请将最后剩余的节点保持原有顺序.
 * <p>
 * 示例:
 * 给你这个链表: 1->2->3->4->5
 * 当 k = 2 时, 应当返回: 2->1->4->3->5
 * 当 k = 3 时, 应当返回: 3->2->1->4->5
 * <p>
 * 说明:
 * 你的算法只能使用常数的额外空间.
 * 你不能只是单纯的改变节点内部的值, 而是需要实际进行节点交换.
 *
 * @author JeromeSoar
 * @since 2020年05月16日 15:28
 */
public class LeetCode0025 {

    /**
     * 递归调用本方法: 本方法的语义是只反转节点个数等于 k 的链表.
     * 时间复杂度 O(n) 空间复杂度 O(n)  0 ms  40 MB
     *
     * @param head 头结点
     * @param k    反转的个数
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 如果当前头节点为空, 直接返回
        if (head == null)
            return null;

        // 记录当前节点数量
        int curNodeNum = 0;
        // 遍历游标
        ListNode curHeadNode = head;
        while (curNodeNum < k && curHeadNode != null) {
            curHeadNode = curHeadNode.next;
            curNodeNum++;
        }
        // 如果当前链表节点个数小于 k 不需要反转, 直接放回.
        if (curNodeNum < k) {
            return head;
        }

        // 反转当前链表的前 k 个元素
        curNodeNum = 0;
        curHeadNode = head;
        ListNode reverseHeadNode = null;
        while (curNodeNum < k && curHeadNode != null) {
            ListNode tempHeadNode = curHeadNode.next;
            curHeadNode.next = reverseHeadNode;
            reverseHeadNode = curHeadNode;
            curHeadNode = tempHeadNode;
            curNodeNum++;
        }
        // 因为链表反转后头节点变成了尾节点, 直接拼上递归后的节点即可
        head.next = reverseKGroup(curHeadNode, k);
        return reverseHeadNode;
    }

    /**
     * 递归调用本方法(切断前 k 个节点进行反转): 本方法的语义是只反转节点个数等于 k 的链表.
     * 时间复杂度 O(n) 空间复杂度 O(n)  0 ms  39.4 MB
     *
     * @param head 头结点
     * @param k    反转的个数
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        // 如果当前头节点为空, 直接返回
        if (head == null)
            return null;

        // 记录当前节点数量
        int curNodeNum = 0;
        // 遍历游标
        ListNode curHeadNode = head;
        ListNode preCurHeadNode = new ListNode(-1);
        while (curNodeNum < k && curHeadNode != null) {
            preCurHeadNode = curHeadNode;
            curHeadNode = curHeadNode.next;
            curNodeNum++;
        }
        // 如果当前链表节点个数小于 k 不需要反转, 直接放回.
        if (curNodeNum < k) {
            return head;
        }

        // 切断当前 k 个节点
        preCurHeadNode.next = null;
        // 反转前 k 个节点构成的链表
        ListNode reverseHeadNode = reverseLinked(head);
        // 反转后 head 节点就是尾节点, 尾节点接上后面的数据.
        head.next = reverseKGroup1(curHeadNode, k);
        return reverseHeadNode;
    }

    private ListNode reverseLinked(ListNode head) {
        // 反转后的头节点
        ListNode reverseHeadNode = null;
        // 遍历游标
        ListNode curHeadNode = head;
        while (curHeadNode != null) {
            ListNode tempNode = curHeadNode.next;
            curHeadNode.next = reverseHeadNode;
            reverseHeadNode = curHeadNode;
            curHeadNode = tempNode;
        }
        return reverseHeadNode;
    }

    /**
     * #多指针记录: 记录头节点, 子链表的头尾节点, 子链表节点个数符合 k 后, 子链表反转.
     * 时间复杂度 O(n^2) 空间复杂度 O(1)  1 ms  39.5 MB
     *
     * @param head 头结点
     * @param k    反转的个数
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 0 - k 子链表游标归 0
        ListNode preNode = dummyHead;
        ListNode lastNode = dummyHead;
        while (lastNode != null) {
            // 向后遍历 k 个节点(因为 lastNode 的起点是虚拟头节点)
            for (int i = 0; i < k && lastNode != null; i++)
                lastNode = lastNode.next;
            // 如果子链表中的节点少于 k 个, 则结束反转
            if (lastNode == null)
                break;

            // 准备开始反转前 k 个节点, 临时记录下个节点
            ListNode nextNode = lastNode.next;
            // 截断前 k 个节点
            lastNode.next = null;
            // 记录反转前的开始节点, 即反转后的结束节点.
            ListNode kStartNode = preNode.next;
            // 将反转后的 k 个子节点链接到前面处理过的节点集.
            preNode.next = reverseLinked(kStartNode);
            // 链接上原有下个节点
            kStartNode.next = nextNode;
            // 0 - k 子链表游标归 0
            preNode = kStartNode;
            lastNode = kStartNode;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(new LeetCode0025().reverseKGroup2(head, 3));
    }
}
