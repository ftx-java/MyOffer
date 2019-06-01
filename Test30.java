package tx.offer;

import java.util.Stack;

/**
 * 第30题
 * 包括main函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * @author tx
 * @date 2018/04/02
 */
public class Test30 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        if (stack2.empty()) {
            stack2.push(node);
        } else if (node < stack2.peek()) {
            stack2.push(node);
        } else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack2.pop();
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
