package tx.offer;

/**
 * 第43题
 * 从1到n整数中1出现的次数
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数
 * （从1 到 n 中1出现的次数）。
 *
 * @author tx
 * @date 2018/05/08
 */
public class Test43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int number = 0;
        for (int i = 1; i <= n; i++) {
            number += fun(i);
        }
        System.out.println(number);
        return number;
    }

    private int fun(int n) {
        int number = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                number++;
            }
            n = n / 10;
        }
        return number;
    }

//大神解法
//    int countDigitOne(int n) {
//        int ones = 0;
//        for (long long m = 1;m <= n;m *= 10){
//            int a = n / m, b = n % m;
//            ones += (a + 8) / 10 * m + (a % 10 == 1) * (b + 1);
//        }
//        return ones;
//    }

    public static void main(String[] args) {
        Test43 test43 = new Test43();
        test43.NumberOf1Between1AndN_Solution(12);
    }
}
