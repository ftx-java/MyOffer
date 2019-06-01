package tx.offer;

/**
 * 第18题 第二问
 * 删除链表重复的节点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author tx
 * @date 2018/03/28
 */
public class Test18Demo02 {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //新增一个头节点
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        ListNode last = head.next;

        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                //找到所有重复的节点
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                //删除重复节点
                pre.next = last.next;
                last = last.next;
            } else {
                //不重复的情况
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
