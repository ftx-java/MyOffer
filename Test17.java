package tx.offer;

/**
 * 第17题
 * 打印从1到最大的n位数
 *
 * @author tx
 * @date 2018/03/28
 */
public class Test17 {
    public void printToMaxofDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] num = new char[n];
        //执行n次循环 放0进行初始化
        for (int i = 0; i < num.length; i++) {
            num[i] = '0';
        }
        while (!increment(num)) {
            printNum(num);
        }
    }

    /**
     * 模拟加法
     *
     * @param num
     * @return
     */
    private boolean increment(char[] num) {
        //判断是否溢出
        boolean isOverflow = false;
        //判断是否进位
        int nTakeOver = 0;
        int nLength = num.length;
        for (int i = nLength - 1; i >= 0; i--) {
            //取道第i位的字符转为数字加上进位符
            int nSum = num[i] - '0' + nTakeOver;
            if (i == nLength - 1) {
                //末尾加一
                ++nSum;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    num[i] = (char) ('0' + nSum);
                }
            } else {
                num[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 打印
     *
     * @param num
     */
    private void printNum(char[] num) {
        boolean isBegin0 = true;
        int nLength = num.length;
        for (int i = 0; i < nLength; i++) {
            if (isBegin0 && num[i] != '0') {
                isBegin0 = false;
            }
            if (!isBegin0) {
                System.out.print(num[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Test17 test17 = new Test17();
        test17.printToMaxofDigits(1);
    }
}
