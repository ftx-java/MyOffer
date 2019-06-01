package tx.offer;

/**
 * 第24题
 * 反转链表
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author tx
 * @date 2018/03/25
 */
public class Test24 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode tmp = null;

        while (head != null) {
            tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
