package tx.offer;

/**
 * 第10题
 * 01斐波那契数列
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * 用循环代替递归
 *
 * @author tx
 * @date 2018/03/05
 */
public class Test10Demo01 {
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int result=0;
        int result1 = 0;
        int result2 = 1;
        for (int i = 1; i < n; i++) {
            result = result1 + result2;
            result1 = result2;
            result2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Test10Demo01 test10 = new Test10Demo01();
        int a = test10.Fibonacci(6);
        System.out.println(a);
    }
}
