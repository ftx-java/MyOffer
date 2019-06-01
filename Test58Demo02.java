package tx.offer;

/**
 * 第58 第2题
 * 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * @author tx
 * @date 2018/05/14
 */
public class Test58Demo02 {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        sb.append(str);
        sb1.append(str);
        String s = sb.delete(n, str.length()).toString();
        String s1 = sb1.delete(0, n).toString();
        sb1.append(s);
        return sb1.toString();
    }

    public static void main(String[] args) {
        Test58Demo02 test58Demo02 = new Test58Demo02();
        String str = "abcefg";
        test58Demo02.LeftRotateString(str, 2);
    }
}
