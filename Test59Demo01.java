package tx.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 第59 第1题
 * 滑动窗口的最大值  利用双端队列
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * @author tx
 * @date 2018/05/15
 */
public class Test59Demo01 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || num.length == 0 || size <= 0 || size > num.length) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        //定义双端队列
        LinkedList<Integer> win = new LinkedList<Integer>();

        for (int i = 0; i < num.length; i++) {
            //保证队列首部存的最大值
            while (!win.isEmpty() && num[win.peekLast()] < num[i]) {
                win.pollLast();
            }
            //存索引
            win.addLast(i);
            //判断队列首元素是否不在窗口了
            if (win.peekFirst() == i - size) {
                win.pollFirst();
            }
            //将窗口最大值加入list
            if (i >= size - 1) {
                list.add(num[win.peekFirst()]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Test59Demo01 test59Demo01 = new Test59Demo01();
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        test59Demo01.maxInWindows(num, 3);

    }
}
