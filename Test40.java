package tx.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 第40题
 * 最小的k个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，
 * 则最小的4个数字是1,2,3,4,。
 *
 * @author tx
 * @date 2018/05/06
 */
public class Test40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k > input.length || k <= 0) {
            return res;
        }
        //定义最大堆来存储k个数（底层是优先队列实现）
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.add(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                maxHeap.poll();
                maxHeap.add(input[i]);
            }
        }
        for (Integer data : maxHeap) {
            res.add(data);
        }
        return res;
    }
}
