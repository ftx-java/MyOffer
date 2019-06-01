package tx.offer;

/**
 * 第52题
 * 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * @author tx
 * @date 2018/05/10
 */
public class Test52 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        //首先得到两个链表的长度
        int len1 = dis(pHead1);
        int len2 = dis(pHead2);
        int dis = len1 - len2;

        ListNode pLong = pHead1;
        ListNode pShort = pHead2;
        if (len1 < len2) {
            pLong = pHead2;
            pShort = pHead1;
            dis = len2 - len1;
        }
        //令长的先走
        for (int i = 0; i < dis; i++) {
            pLong = pLong.next;
        }
        //查找公共节点
        while (pLong != null && pShort != null && pLong != pShort) {
            pLong = pLong.next;
            pShort = pShort.next;
        }
        ListNode pRes = pLong;
        return pRes;
    }

    /**
     * 计算链表的长度
     */
    private int dis(ListNode pHead) {
        ListNode pre = pHead;
        int len = 0;
        while (pre.next != null) {
            len++;
            pre = pre.next;
        }
        return len;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

