package tx.offer;

/**
 * 第22题
 * 链表中的倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author tx
 * @date 2018/03/21
 */
public class Test22 {
    public ListNode FindKthToTail(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }

        ListNode pre = head;
        ListNode last = head;

        for (int i = 0; i < k; i++) {
            if (pre != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }

        while (pre != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
