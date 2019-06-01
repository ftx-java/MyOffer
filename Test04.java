package tx.offer;

/**
 * 第4题
 * 二维数组中的查找
 * arr1[][] = {{}}; 注意这种类型的数组
 *
 * @author tx
 * @date 2019/02/25
 */
public class Test04 {
    public boolean Find(int target, int[][] array) {
        int a = array.length;
        int b = array[0].length;
        if (array[0].length == 0 || target > array[a - 1][b - 1] || target < array[0][0]) {
            return false;
        }
        for (int i = 0; i < a; i++) {
            while (target < array[i][b - 1]) {
                b = b - 1;
                if (b == 0) {
                    return false;
                }
            }
            for (int j = 0; j < b; j++) {
                if (target > array[i][b - 1]) {
                    break;
                }
                if (target == array[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int arrX[][] = {{}};
        Test04 test03Demo02 = new Test04();
        boolean x = test03Demo02.Find(16, arrX);
        System.out.println(x);
    }
}
