package tx.offer;

/**
 * 第35题
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author tx
 * @date 2018/04/06
 */
public class Test35 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode pNode = pHead;
        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while (pNode != null) {
            RandomListNode pClone = new RandomListNode(pNode.label);
            pClone.next = pNode.next;
            pNode.next = pClone;
            pNode = pClone.next;
        }
        pNode = pHead;
        //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
        while (pNode != null) {
            if (pNode.random != null) {
                pNode.next.random = pNode.random.next;
            }
            pNode = pNode.next.next;
        }

        RandomListNode res = pHead.next;
        RandomListNode node = res;
        pNode = pHead;
        //拆分链表
        while (pNode != null) {
            pNode.next = pNode.next.next;
            if (node.next != null) {
                node.next = node.next.next;
            }
            node = node.next;
            pNode = pNode.next;
        }
        return res;
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
