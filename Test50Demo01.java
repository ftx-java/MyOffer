package tx.offer;

import java.util.HashMap;

/**
 * 第50 第1题
 * 字符串中第一次只出现一次的字符
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * @author tx
 * @date 2018/05/10
 */
public class Test50Demo01 {
    public int FirstNotRepeatingChar(String str) {
        if (str.length() <= 0 || str == null) {
            return -1;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //统计每个字符出现的次数
        for (int i = 0; i < str.length(); i++) {
            //如果这个字符出现过则对应的次数加一
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        //拿到第一个次数为一的字符位置
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            int value = map.get(str.charAt(i));
            if (value == 1) {
                System.out.println(index);
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Test50Demo01 test50 = new Test50Demo01();
        String str = "abaccdeff";
        String str1 = "google";
        test50.FirstNotRepeatingChar(str1);
    }
}
