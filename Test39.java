package tx.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 第39题
 * 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @author tx
 * @date 2018/05/06
 */
public class Test39 {
    public int MoreThanHalfNum_Solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            Integer index = map.get(array[i]);
            if (index == null) {
                map.put(array[i], 1);
                index = 0;
            } else {
                map.put(array[i], index + 1);
            }
            if (index+1 > array.length / 2) {
                System.out.println(array[i]);
                return array[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Test39 test39 =new Test39();
        int[] array={1,2,3,2,2,2,5,4,2};
        int[] array1={1,2,3};
        test39.MoreThanHalfNum_Solution(array);
    }
}
