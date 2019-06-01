package tx.offer;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第50 第2题
 * 字符流中第一次只出现一次的字符   利用LinkedHashMap有序性
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * @author tx
 * @date 2018/05/15
 */
public class Test50Demo02 {
    HashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();

    /**
     * Insert one char from stringstream
     */
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }

    /**
     * return the first appearence once char in current stringstream
     * Map中采用Entry内部类来表示一个映射项，映射项包含Key和Value
     * Map.Entry里面包含getKey()和getValue()方法
     */
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> res : map.entrySet()) {
            if (res.getValue() == 1) {
                return res.getKey();
            }
        }
        return '#';
    }
}
