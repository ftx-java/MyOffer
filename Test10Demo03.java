package tx.offer;

/**
 * 第10题
 * 03变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author tx
 * @date 2018/03/06
 */
public class Test10Demo03 {
    public int JumpFloorII(int target) {
        if (target == 0 || target == 1) {
            return target;
        }

        int result = 1;
        for (int i = 1; i < target; i++) {
            result = result * 2;
        }
        return result;

    }

    public static void main(String[] args) {
        Test10Demo03 test10Demo03 = new Test10Demo03();
        int a = test10Demo03.JumpFloorII(5);
        System.out.println(a);
    }
}
