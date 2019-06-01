package tx.offer;

/**
 * 第10题
 * 02青蛙跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author tx
 * @date 2018/03/05
 */
public class Test10Demo02 {
    public int JumpFloor(int target) {
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }

        int result = 0;
        int result1 = 1;
        int result2 = 2;
        for (int i = 2; i < target; i++) {
            result = result1 + result2;
            result1 = result2;
            result2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        Test10Demo02 test10Demo02 = new Test10Demo02();
        int a = test10Demo02.JumpFloor(4);
        System.out.println(a);
    }
}
