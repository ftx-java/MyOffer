package tx.offer;

/**
 * 第53题
 * 在排序数组中查找数字
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author tx
 * @date 2018/05/10
 */
public class Test53 {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int first = firstOfK(array, k, 0, array.length - 1);
        int last = lastOfK(array, k, 0, array.length - 1);
        if (first == -1 || last == -1) {
            return 0;
        } else {
            System.out.println(last - first + 1);
            return last - first + 1;
        }
    }

    /**
     * 找到第一个k出现的索引
     */
    private int firstOfK(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = (end + start) / 2;
            if (k < array[mid]) {
                end = mid - 1;
            } else if (k > array[mid]) {
                start = mid + 1;
            } else {
                if (mid > 0 && k != array[mid - 1] || mid == 0) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 找到最后一个k出现的索引
     */
    private int lastOfK(int[] array, int k, int start, int end) {
        while (start <= end) {
            int mid = (end + start) / 2;
            if (k < array[mid]) {
                end = mid - 1;
            } else if (k > array[mid]) {
                start = mid + 1;
            } else {
                if (mid < array.length - 1 && k != array[mid + 1] || mid == array.length - 1) {
                    return mid;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Test53 test53 = new Test53();
        int [] arr= {1,2,3,3,3,3,4,5};
        test53.GetNumberOfK(arr,3);
    }
}
