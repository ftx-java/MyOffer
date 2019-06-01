package tx.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 第45题
 * 把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @author tx
 * @date 2018/05/08
 */
public class Test45 {
    public String PrintMinNumber(int[] numbers) {
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        for (int num : list) {
            s.append(num);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Test45 test45 = new Test45();
        int[] number = {3, 5, 1, 4, 2};
        int[] number1 = {3, 32, 321};
        test45.PrintMinNumber(number);
    }
}
