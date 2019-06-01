package tx.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 第21题
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author tx
 * @date 2018/03/20
 */
public class Test21 {
    public void reOrderArray(int[] array) {
        ArrayList<Integer> a = new ArrayList<Integer>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                a.add(array[i]);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                a.add(array[i]);
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = a.get(i);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Test21 test21 = new Test21();
        int[] array = {1, 3, 5, 2, 4, 9, 7};
        int[] array1 = {};
        test21.reOrderArray(array1);
    }
}
