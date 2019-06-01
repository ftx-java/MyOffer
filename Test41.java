package tx.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 第41题
 * 数据流中的中位数  采用最大堆最小堆求解
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 *
 * @author tx
 * @date 2018/05/07
 */
public class Test41 {
    int count;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        //先将数据加到最小堆 但要先经过最大堆在进入最小堆
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int Max = maxHeap.poll();
            minHeap.offer(Max);
        } else {
            minHeap.offer(num);
            int Min = minHeap.poll();
            maxHeap.offer(Min);
        }
        count++;
    }

    public Double GetMedian() {
        if (count % 2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            //因为先向最小堆中加入数据 所以当数据总数为奇数时最小堆的根就是中位数
            return new Double(minHeap.peek());
        }
    }
}
