package tx.offer;

/**
 * 第56 第2题 位运算
 * 数组中唯一出现1次的数字
 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次，找出出现了一次的那个数字
 *
 * @author tx
 * @date 2018/05/13
 */
public class Test56Demo02 {
    public int findNumOfOnce(int[] num) {
        if (num == null || num.length == 0) {
            throw new RuntimeException();
        }
        //利用长度为32的辅助数组来存储二进制表示的每一位的和
        int[] bitSum = new int[32];
        for (int i = 0; i < bitSum.length; i++) {
            bitSum[i] = 0;
        }
        for (int i = 0; i < num.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = bitMask & num[i];
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += (bitSum[i] % 3);
        }
        return result;
    }

    public static void main(String[] args) {
        Test56Demo02 test56Demo02 = new Test56Demo02();
        int[] arr = {4, 1, 2, 2, 3, 2, 3, 4, 3, 4};
        test56Demo02.findNumOfOnce(arr);
    }
}
