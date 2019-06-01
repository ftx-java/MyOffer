package tx.offer;

/**
 * 第3题
 * 数组中重复的数字 题目一
 *
 * @author tx
 * @date 2019/02/19
 */
public class Test03Demo01 {
    public static boolean duplicate(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 || arr[i] > arr.length - 1) {
                return false;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int temp;
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    System.out.println("重复的数字为：" + arr[i]);
                    return true;
                }
                temp = arr[i];
                arr[i] = arr[temp];
                arr[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 0, 2, 5, 3};
        boolean result = duplicate(a);
        System.out.println(result);
    }
}
