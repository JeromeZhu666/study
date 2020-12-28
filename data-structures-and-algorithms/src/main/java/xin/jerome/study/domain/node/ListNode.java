package xin.jerome.study.domain.node;

/**
 * 链表节点的定义
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /**
     * 使用数组作为参数，创建一个链表
     *
     * @param arr 数组参数
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Arr can not be empty.");
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListNode: ");
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val + "->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }
}