package xin.jerome.study.algorithms.linked.leetcode;

import java.util.Stack;

import xin.jerome.study.domain.node.ListNode;

/**
 * 反转链表:
 * 
 * 反转一个单链表。
 * 
 * 示例: <br>
 * 输入: 1->2->3->4->5->NULL <br>
 * 输出: 5->4->3->2->1->NULL
 *
 * @author Jerome Zhu
 * @since 2019.08.21 20:51
 */
public class LeetCode0206 {

    /**
     * 反转以head为头结点的链表 1 ms 36.4 MB 战胜 86.11 % 的 java 提交记录
     * 
     * @param head
     *            头结点
     * @return 反转后的头结点
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 反转后序节点,反转后的链表的最后一个元素就是当前元素 head.next.
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 反转以head为头结点的链表 3 ms 36.7 MB 战胜 8.88 % 的 java 提交记录
     * 
     * @param head
     *            头结点
     * @return 反转后的头结点
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            ListNode node = cur;
            stack.push(node);
            cur = cur.next;
            node.next = null;
        }
        ListNode newHead = stack.pop();
        ListNode curNode = newHead;
        while (!stack.empty()) {
            curNode.next = stack.pop();
            curNode = curNode.next;
        }
        return newHead;
    }

    /**
     * 反转以head为头结点的链表 1 ms 36.6 MB 战胜 86.11 % 的 java 提交记录
     * 
     * @param head
     *            头结点
     * @return 反转后的头结点
     */
    public ListNode reverseList2(ListNode head) {
        ListNode preNode = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = cur;
            cur = cur.next;
            node.next = preNode;
            preNode = node;
        }
        return preNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (int i = 1; i < 6; i++) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }
        printLiked(head);
        ListNode newHead = new LeetCode0206().reverseList2(head);
        printLiked(newHead);
    }

    private static void printLiked(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;
        while (cur.next != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append(cur.val + "->null");
        System.out.println(sb.toString());
    }
}
