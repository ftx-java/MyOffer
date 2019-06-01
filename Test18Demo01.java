package tx.offer;

/**
 * 第18题 第一问
 * 在O（1）的时间复杂度删除链表节点
 *
 * @author tx
 * @date 2018/03/28
 */
public class Test18Demo01 {
    public void delectNode(ListNode head, ListNode deListNode) {
        if (head == null || deListNode == null) {
            return;
        }
        //如果要删除的节点为头节点
        if (head == deListNode) {
            head = null;
        } else {
            //如果要删除的节点为最后一个节点
            if (deListNode.next == null) {
                ListNode indexNode = head;
                while (indexNode.next.next != null) {
                    indexNode = indexNode.next;
                }
                indexNode.next = null;
            } else {
                //正常情况
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;

            }
        }
    }

    class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }

    }
}
