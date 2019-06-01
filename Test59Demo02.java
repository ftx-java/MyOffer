package tx.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 第59 第2题
 * 队列的最大值
 *
 * @author tx
 * @date 2018/05/15
 */
public class Test59Demo02 {
    private ArrayDeque<InternalData> data = new ArrayDeque<InternalData>();
    private ArrayDeque<InternalData> maximum = new ArrayDeque<InternalData>();

    private class InternalData {
        int number;
        int index;

        public InternalData(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    private int curIndex;

    public void push_back(int number) {
        InternalData curData = new InternalData(number, curIndex);
        data.addLast(curData);

        while (!maximum.isEmpty() && maximum.getLast().number < number) {
            maximum.removeLast();
        }
        maximum.addLast(curData);

        curIndex++;  //别漏了这句
    }

    public void pop_front() {
        if (data.isEmpty()) {
            System.out.println("队列为空，无法删除！");
            return;
        }
        InternalData curData = data.removeFirst();
        if (curData.index == maximum.getFirst().index) {
            maximum.removeFirst();
        }
    }

    public int max() {
        if (maximum == null) {
            System.out.println("队列为空，无法删除！");
            return 0;
        }
        return maximum.getFirst().number;
    }

}
