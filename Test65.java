package tx.offer;

/**
 * 第65题
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @author tx
 * @date 2018/05/15
 */
public class Test65 {
    public int Add(int num1, int num2) {
        int sum, index;
        do {
            sum = num1 ^ num2;
            index = (num1 & num2) << 1;
            num1 = sum;
            num2 = index;
        } while (num2 != 0);
        System.out.println(num1);
        return num1;
    }

    public static void main(String[] args) {
        Test65 test65 = new Test65();
        test65.Add(3, 5);
    }
}
