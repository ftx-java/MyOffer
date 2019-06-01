package tx.offer;

/**
 * 第14题
 * 剪绳子
 * 动态规划
 *
 * @author tx
 * @date 2018/03/26
 */
public class Test14 {
    /**
     * 动态规划
     *
     * @param len
     * @return
     */
    private int maxResult(int len) {
        if (len < 2) {
            return 0;
        }
        if (len == 2) {
            return 1;
        }
        if (len == 3) {
            return 2;
        }

        //存储长度从 0-len 的最大结果
        //当length<=3的时候，我们直接返回了结果。如果整个绳子的长度为3，我们必须把绳子剪开，
        // 因为题目要求m>1，其中一段为2，另一段为1，这样结果就是2。 当length>=4的时候，
        // 我们可以把绳子剪成两段，其中一段为3另一段为１，这样长度为3的那一段的最大值就是3而不是2，
        // 因为这一段我们不需要再剪了。当然长度为4的最大值是2和2的组合，我们已经存储了2的长度。
        int[] f = new int[len + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;

        int res = 0;
        for (int i = 4; i <= len; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int maxRes = f[j] * f[i - j];
                if (max < maxRes) {
                    max = maxRes;
                }
                f[i] = max;
            }
        }
        res = f[len];
        return res;
    }

    /**
     * 贪婪算法
     *
     * @param len
     * @return
     */
    private int maxRes(int len) {
        if (len < 2) {
            return 0;
        }
        if (len == 2) {
            return 1;
        }
        if (len == 3) {
            return 2;
        }

        int timesOf3 = len / 3;
        if (len - timesOf3 * 3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (len - timesOf3 * 3) / 2;
        int max = (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
        return max;
    }

    public static void main(String[] args) {
        Test14 test14 = new Test14();
        System.out.println(test14.maxResult(8));
        System.out.println(test14.maxRes(8));
    }
}
