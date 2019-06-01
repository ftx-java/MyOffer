package tx.offer;

/**
 * 第15题
 * 二进制中的1个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @author tx
 * @date 2018/03/19
 */
public class Test15 {

    public int NumberOf1(int n) {
        int res = 0;

        while (n != 0) {

            n = (n - 1) & n;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Test15 test15 = new Test15();
        System.out.println(test15.NumberOf1(7));
    }
}
