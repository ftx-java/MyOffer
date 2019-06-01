package tx.offer;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 第60题
 * n个骰子的点数
 * 把 n 个骰子仍在地上，求点数和为 s 的概率。
 *
 * @author tx
 * @date 2018/05/15
 */
public class Test60 {
    public void dicesSum(int n) {
        List<Map.Entry<Integer, Double>> list = new ArrayList<>();
        final int face = 6;
        final int pointNum = face * n;
        //存储点数和为s的出现次数
        long[][] dp = new long[n + 1][pointNum + 1];

        for (int i = 1; i <= face; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            //使用i个骰子最小点数为i 最大为pointNum
            for (int j = i; j <= pointNum; j++) {
                for (int k = 1; k <= face && k <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        final double totalNum = Math.pow(6, n);
        for (int i = n; i <= pointNum; i++) {
            list.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / totalNum));
        }
        return;
    }

    public static void main(String[] args) {
        Test60 test60 = new Test60();
        test60.dicesSum(3);
    }
}
