package tx.offer;

import java.util.ArrayList;

/**
 * 第57 第1题
 * 和为s的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @author tx
 * @date 2018/05/13
 */
public class Test57Demo01 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length == 0) {
            return list;
        }

        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                list.add(array[start]);
                list.add(array[end]);
                break;
            } else if (array[start] + array[end] > sum) {
                end--;
            } else {
                start++;
            }
        }
        return list;
    }
}
