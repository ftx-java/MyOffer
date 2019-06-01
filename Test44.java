package tx.offer;

/**
 * 第44题
 * 数字序列中某一位的数字
 * 数字以01234567891011121314...的格式排列。
 * 在这个序列中，第5位（从0开始计）是5，第13位是1，第19位是4。求任意第n为对应的数字。
 *
 * @author tx
 * @date 2018/05/08
 */
public class Test44 {
//    以第1001位数字7为例
//    步骤1：首先确定该数字是属于几位数的;
//    如果是一位数，n<9;如果是两位数，n<9+90*2=189;如果是三位数，n<189+900*3=2889;
//    说明是三位数。
//    步骤2：确定该数字属于哪个数。100+(1001-190)/3= 370。
//    步骤3：确定是该数中哪一位。1001-190-(370-100)*3 = 1,所以位于“370”的下标为1的位置，即数字7

    /**
     * 步骤1：首先确定该数字是属于几位数;
     */
    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        if (index < 10) {
            return index;
        }
        int base = 10;
        int numLength = 2;
        int num = 10;
        while (index > base + fun(numLength)) {
            base += fun(numLength);
            num *= 10;
            numLength++;
        }
        //步骤2：确定该数字属于哪个数。
        int resNum = num + (index - base) / numLength;
        System.out.println(resNum);
        //步骤3：确定是该数中哪一位。
        StringBuffer sb = new StringBuffer();
        sb.append(resNum);
        int res = sb.charAt(index - base - (resNum - num) * 3) - '0';
        System.out.println(res);
        return res;
    }

    private int fun(int numLength) {
        int count = 9;
        for (int i = 1; i < numLength; i++) {
            count *= 10;
        }
        return count * numLength;
    }

    public static void main(String[] args) {
        Test44 test44 = new Test44();
        test44.digitAtIndex(1001);
    }
}
