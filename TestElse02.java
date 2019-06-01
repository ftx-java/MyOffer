package tx.offer;

/**
 * 牛客
 * 把字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * @author tx
 * @date 2018/05/15
 */
public class TestElse02 {
    public int StrToInt(String str) {
        boolean index = true;
        char[] chars = str.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+') {
                continue;
            } else if (chars[i] == '-') {
                index = false;
                continue;
            } else if (chars[i] > '9' || chars[i] < '0') {
                return 0;
            } else {
                res = res * 10 + (chars[i] - '0');
            }
        }
        if (res == 0) {
            return 0;
        }
        return index == true ? res : -res;
    }

    public static void main(String[] args) {
        TestElse02 testElse02 = new TestElse02();
        String str = "+2147483647";
        testElse02.StrToInt(str);
    }
}
