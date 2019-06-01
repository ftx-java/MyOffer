package tx.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 第6题
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * @author tx
 * @date 2019/03/04
 */
public class Test06 {
    ArrayList<Integer> arrayList = new <Integer>ArrayList();

    /**
     * 使用递归实现
     * 递归的点在printListFromTailToHaed(listNode.next)这个节点，
     * 那么在最后一次递归方法返回以后，每一层的递归方法都会做一个arrayList.add(lizxstNode.val)这个操作，
     * 从最后一次到第一次，逆向的调用了后面的方法。因为之前的递归点已经返回了。
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            System.out.println(listNode.val);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    //使用栈实现
    public void printListFromTailToHeadByStack(ListNode node) {
        ArrayList<Integer> arrayList1 = new <Integer>ArrayList();
        Stack<Integer> stack = new Stack<Integer>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ",");
            arrayList1.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Test06 test06 = new Test06();
    }

    class ListNode {
        ListNode next;
        int val;

        public ListNode() {

        }

        public ListNode(int val) {
            this.val = val;
        }

    }
}


