package tx.offer;

/**
 * 第63题
 * 股票的最大利润
 *
 * @author tx
 * @date 2018/05/15
 */
public class Test63 {
    public int MaxDiff(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int min = arr[0];
        int maxDiff = arr[1] - min;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] < min) {
                min = arr[i - 1];
            }
            if (arr[i] - min > maxDiff) {
                maxDiff = arr[i] - min;
            }
        }
        System.out.println(maxDiff);
        return maxDiff;
    }

    public static void main(String[] args) {
        Test63 test63 = new Test63();
        int[] arr = {9, 11, 8, 5, 7, 12, 16, 14};
        test63.MaxDiff(arr);
    }
}
