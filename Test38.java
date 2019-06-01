package tx.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 第38题
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * @author tx
 * @date 2018/04/28
 */
public class Test38 {
    public ArrayList<String> Permutation(String str) {
        List<String> resultList = new ArrayList<>();
        if (str.length() == 0) {
            return (ArrayList) resultList;
        }
        //递归的初始值为（str数组，空的list，初始下标0）
        fun(str.toCharArray(), resultList, 0);
        Collections.sort(resultList);
        return (ArrayList) resultList;
    }

    private void fun(char[] ch, List<String> list, int i) {
        //这是递归的终止条件，就是i下标已经移到char数组的末尾的时候，考虑添加这一组字符串进入结果集中
        if (i == ch.length - 1) {
            //判断一下是否重复
            if (!list.contains(new String(ch))) {
                list.add(new String(ch));
                return;
            }
        } else {
            for (int j = i; j < ch.length; j++) {
                swap(ch, i, j);
                fun(ch, list, i + 1);
                swap(ch, i, j);
            }
        }
    }

    //交换数组的两个下标的元素
    private void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        Test38 test38 = new Test38();
        test38.Permutation(str);
    }
}
