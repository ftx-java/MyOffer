package tx.offer;

/**
 * 牛客
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author tx
 * @date 2018/03/19
 */
public class TestElse01 {
    public int RectCover(int target) {
        if (target == 1 || target == 2 || target == 0) {
            return target;
        }

        int start = 1;
        int mid = 2;
        int result = 0;
        for (int i = 2; i < target; i++) {
            result = start + mid;
            start = mid;
            mid = result;
        }

        return result;
    }

    public static void main(String[] args) {
        TestElse01 testelse01 = new TestElse01();
        System.out.println(testelse01.RectCover(4));
    }

}
