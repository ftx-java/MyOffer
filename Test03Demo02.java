package tx.offer;

/**
 * 第3题
 * 不修改数组找出重复的数字 题目二
 *
 * @author tx
 * @date 2019/02/19
 */
public class Test03Demo02 {
    public int getDuplication(int[] arr, int length) {
        if (arr == null || length == 0) {
            return -1;
        }
        int[] num = new int[length];
        for (int i = 0; i < length; i++) {
            if (num[arr[i]] == 0) {
                num[arr[i]] = arr[i];
            } else {
                System.out.println(arr[i]);
                return arr[i];
            }
        }
        System.out.println(-1);
        return -1;
    }

    public static void main(String[] args) {
        Test03Demo02 test03Demo02 = new Test03Demo02();
        int[] a = {2, 3, 1, 0, 4, 5, 3};
        test03Demo02.getDuplication(a, a.length);
        int[] arr1 = {1, 2, 3, 4};
        test03Demo02.getDuplication(arr1, arr1.length);
    }
}
