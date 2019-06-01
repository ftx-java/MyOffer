package tx.offer;

/**
 * 第56 第1题
 * 数组中数字出现的次数 异或运算
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * //num1,num2分别为长度为1的数组。传出参数
 * //将num1[0],num2[0]设置为返回结果
 *
 * @author tx
 * @date 2018/05/13
 */
public class Test56Demo01 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length == 0) {
            return;
        }
        int num = 0;
        //所有数进行异或 结果为两个不同的数的异或
        for (int i = 0; i < array.length; i++) {
            num ^= array[i];
        }
        //在num结果数字中找到第一个为1的位置，并对其进行标识
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if ((num & (1 << i)) != 0) {
                temp = i;
                break;
            }
        }
        num1[0] = 0;
        num2[0] = 0;
        //将数组分为两组 对应标识位为1为一组 为0则为另一组 对每组异或 得到两个不同的数字
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & (1 << temp)) == 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        Test56Demo01 test56 = new Test56Demo01();
        int[] arr = {2, 4, 3, 6, 3, 2, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        test56.FindNumsAppearOnce(arr, num1, num2);
    }
}
