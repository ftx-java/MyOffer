package tx.offer;

/**
 * 第23题
 * 链表中环的入口节点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author tx
 * @date 2018/03/25
 */
public class Test23 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = MeetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }

        //计算环中节点的个数
        int index = 1;
        ListNode pNode = meetingNode;
        while (pNode.next != meetingNode) {
            pNode = pNode.next;
            ++index;
        }

        //找出环的入口节点
        pNode = pHead;
        for (int i = 0; i < index; i++) {
            pNode = pNode.next;
        }

        ListNode pNode1 = pHead;
        while (pNode != pNode1) {
            pNode = pNode.next;
            pNode1 = pNode1.next;
        }

        return pNode;
    }

    /**
     * 利用快与慢指针找到在环中相遇的节点
     *
     * @param pHead
     * @return
     */
    private ListNode MeetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode slowNode = pHead.next;
        if (slowNode == null) {
            return null;
        }
        ListNode fastNode = slowNode.next;

        while (slowNode != null && fastNode != null) {
            if (slowNode == fastNode) {
                return fastNode;
            }

            slowNode = slowNode.next;
            fastNode = fastNode.next;
            if (fastNode != null) {
                fastNode = fastNode.next;
            }
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
