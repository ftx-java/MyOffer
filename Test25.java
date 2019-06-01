package tx.offer;

/**
 * 第25题
 * 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 *
 * @author tx
 * @date 2018/03/30
 */
public class Test25 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode newNode = null;
        if (list1.val < list2.val) {
            newNode = list1;
            newNode.next = Merge(list1.next, list2);
        } else {
            newNode = list2;
            newNode.next = Merge(list1, list2.next);
        }
        return newNode;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
