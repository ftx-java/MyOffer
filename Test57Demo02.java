package tx.offer;

import java.util.ArrayList;

/**
 * 第57 第2题
 * 和为S的连续正数序列
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * @author tx
 * @date 2018/05/13
 */
public class Test57Demo02 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum < 3) {
            return res;
        }
        int small = 1;
        int big = 2;
        int mid = (1 + sum) / 2;
        int sumTemp = small + big;

        while (small < mid) {
            if (sumTemp == sum) {
                result(small, big);
            }

            while (sumTemp > sum && small < mid) {
                sumTemp -= small;
                small++;
                if (sumTemp == sum) {
                    result(small, big);
                }
            }

            big++;
            sumTemp += big;
        }
        return res;
    }

    public void result(int small, int big) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = small; i <= big; i++) {
            list.add(i);
        }
        res.add(list);
    }

    public static void main(String[] args) {
        Test57Demo02 test57Demo02 = new Test57Demo02();
        test57Demo02.FindContinuousSequence(9);
    }
}
