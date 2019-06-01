package tx.offer;

/**
 * 第13题
 * 机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * @author tx
 * @date 2018/03/26
 */
public class Test13 {
    public int movingCount(int threshold, int rows, int cols) {
        int[][] flag = new int[rows][cols];
        return result(0, 0, rows, cols, flag, threshold);
    }

    private int result(int i, int j, int rows, int cols, int[][] flag, int threshold) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || sum(i) + sum(j) > threshold || flag[i][j] == 1) {
            return 0;
        }
        flag[i][j] = 1;
        return 1 + result(i + 1, j, rows, cols, flag, threshold)
                + result(i - 1, j, rows, cols, flag, threshold)
                + result(i, j + 1, rows, cols, flag, threshold)
                + result(i, j - 1, rows, cols, flag, threshold);
    }

    private int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        System.out.println(test13.sum(135));

        int res = test13.movingCount(2,3,3);
        System.out.println(res);
    }
}
