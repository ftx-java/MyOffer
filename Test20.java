package tx.offer;

/**
 * 第20题
 * 表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * 字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author tx
 * @date 2018/03/29
 */
public class Test20 {
    /**
     * 利用正则表达式
     *
     * @param str
     * @return
     */
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }

    /**
     * 正常方法
     */
    int index = 0;

    public boolean isNum(char[] str) {
        if (str.length < 1) {
            return false;
        }
        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            //小数点后是否有整数？
            flag = scanUnsignedInteger(str);
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            //e E后面是否有+ - 以及+ - 后面的整数
            flag = scanInteger(str);
        }
        return flag && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        //+ -符号后面是否是整数？
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int pre = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        //是否存在整数
        return pre < index;
    }

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        char[] chars = {1, 2, 3, '.', 4, 5, 'e', '+', 6};
        System.out.println(test20.isNum(chars));
    }
}
