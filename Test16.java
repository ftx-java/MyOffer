package tx.offer;

/**
 * 第16题
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @author tx
 * @date 2018/03/20
 */
public class Test16 {
    double Power(double base, int exponent) {
        double res = 1;
        int n = 0;

        if (base == 0) {
            return 0;
        } else if (exponent > 0) {
            n = exponent;
        } else if (exponent < 0) {
            n = -exponent;
        } else {
            return 1;
        }

        while (n != 0) {
            if (n % 2 == 1) {
                res *= base;
            }
            base *= base;
            n >>= 1;
        }

        return exponent > 0 ? res : (1 / res);
//        if (exponent == 0) {
//            return 1;
//        }
//        if (base == 0) {
//            return 0;
//        }
//        if (exponent == 1) {
//            return base;
//        } else if (exponent == -1) {
//            return 1 / base;
//        }
//        return Power(base, exponent / 2) * Power(base, exponent / 2) * Power(base, exponent % 2);

    }

    public static void main(String[] args) {
        Test16 test16 = new Test16();
        System.out.println(test16.Power(3, -1));
    }
}
