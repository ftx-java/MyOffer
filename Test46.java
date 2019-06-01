package tx.offer;

/**
 * 第46题
 * 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻译成"b"，……，
 * 11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例如12258有5种不同的翻译，
 * 它们分别"bccfi", "bwfi", "bczi", "mcfi" 和"mzi" 。
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 *
 * @author tx
 * @date 2018/05/08
 */
public class Test46 {
    public int numToStr(int number) {
        if (number < 0) {
            return 0;
        }
        String str = String.valueOf(number);
        int len = str.length();
        int[] index = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                index[i] = 1;
            } else {
                index[i] = index[i + 1];
                if (fun(str, i)) {
                    if (i == len - 2) {
                        index[i] += 1;
                    } else {
                        index[i] += index[i + 2];
                    }
                }
            }
        }
        System.out.println(index[0]);
        return index[0];
    }

    private boolean fun(String str, int i) {
        int a = str.charAt(i) - '0';
        int b = str.charAt(i + 1) - '0';
        int res = a * 10 + b;
        if (res >= 10 && res <= 25) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Test46 test46 = new Test46();
        int a = 12258;
        test46.numToStr(a);
    }
}
