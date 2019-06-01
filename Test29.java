package tx.offer;

import java.util.ArrayList;

/**
 * 第29题
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * @author tx
 * @date 2018/04/02
 */
public class Test29 {
    ArrayList<Integer> res = new ArrayList<Integer>();

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //起始行与列的坐标 start
        int start = 0;
        if (matrix == null || rows <= 0 || cols <= 0) {
            return null;
        }

        while (rows > 2 * start && cols > 2 * start) {
            printMatrixCircle(matrix, rows, cols, start);
            ++start;
        }
        return res;
    }

    private void printMatrixCircle(int[][] matrix, int rows, int cols, int start) {
        //定义每次循环打印的结束行与结束列坐标
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        //从左到右打印一行
        for (int i = start; i <= endX; i++) {
            int num = matrix[start][i];
            System.out.println(num);
            res.add(num);
        }

        //从上到下打印一列
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                int num = matrix[i][endX];
                System.out.println(num);
                res.add(num);
            }
        }

        //从右到左打印一行
        if (endX > start && endY > start) {
            for (int i = endX - 1; i >= start; i--) {
                int num = matrix[endY][i];
                System.out.println(num);
                res.add(num);
            }
        }

        //从下倒上打印一列
        if (endY > start + 1 && endX > start) {
            for (int i = endY - 1; i > start; i--) {
                int num = matrix[i][start];
                System.out.println(num);
                res.add(num);
            }
        }
    }
}
