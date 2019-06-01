package tx.offer;


/**
 * 第47题
 * 礼物的最大价值 动态规划 从左上角开始
 * 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 *
 * @author tx
 * @date 2018/05/08
 */
public class Test47 {
    public int getMaxValue(int[][] values) {
        if (values == null || values.length <= 0 || values[0].length <= 0) {
            return -1;
        }
        int[] maxValue = new int[values[0].length];
        int rows = values.length;
        int cols = values.length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) {
                    up = maxValue[j];
                }
                if (j > 0) {
                    left = maxValue[j - 1];
                }
                maxValue[j] = Math.max(up, left) + values[i][j];
            }
        }
        System.out.println(maxValue[cols - 1]);
        return maxValue[cols - 1];
    }

    public static void main(String[] args) {
        int[][] num = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        Test47 test47 = new Test47();
        test47.getMaxValue(num);
    }
}
