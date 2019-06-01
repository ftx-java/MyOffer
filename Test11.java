package tx.offer;

/**
 * 第11题
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author tx
 * @date 2018/03/07
 */
public class Test11 {
    public int minNumberInRotateArray(int[] array) {
        //如果数组长度为0返回0
        if (array == null || array.length <= 0) {
            return 0;
        }
        //若数组本身为升序数组 则返回第一个数
        if (array[0] < array[array.length - 1]) {
            return array[0];
        }
        //利用二分法快速找到最小值
        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = 0;
        while (array[index2] <= array[index1]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }

            indexMid = (int) (index1 + index2) / 2;
            //考虑特殊情况 如{3,2,3,3,3};
            if (array[index1] == array[indexMid] && array[index1] == array[index2]) {
                int temp = array[index1];
                for (int i = index1 + 1; i <= index2; i++) {
                    if (temp > array[i]) {
                        temp = array[i];
                    }
                    return temp;
                }
            }

            if (array[index1] <= array[indexMid]) {
                index1 = indexMid;
            } else if (array[index2] >= array[indexMid]) {
                index2 = indexMid;
            }
        }

        return array[indexMid];
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        int[] Data = {3, 4, 5, 1, 2};
        int[] special = {3, 2, 3, 3, 3};
        int a = test11.minNumberInRotateArray(special);
        System.out.println(a);
    }
}
