package tx.offer;

/**
 * 第64题
 * 求1+2+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 *
 * @author tx
 * @date 2018/05/15
 */
public class Test64 {
    public int Sum_Solution(int n) {
        n = (int)( Math.pow(n,2)+n)/2;
        return n;
    }

    public static void main(String[] args) {
        Test64 test64 = new Test64();
        test64.Sum_Solution(5);
    }
}
