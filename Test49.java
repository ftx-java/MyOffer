package tx.offer;

import java.util.ArrayList;

/**
 * 第49题
 * 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
 * 因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * @author tx
 * @date 2018/05/10
 */
public class Test49 {
    /**
     * 我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
     */
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int n2 = 0, n3 = 0, n5 = 0;
        while (list.size() < index) {
            int m2 = list.get(n2) * 2;
            int m3 = list.get(n3) * 3;
            int m5 = list.get(n5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (min == m2) {
                n2++;
            }
            if (min == m3) {
                n3++;
            }
            if (min == m5) {
                n5++;
            }
        }
        System.out.println(list.get(list.size() - 1));
        return list.get(list.size() - 1);
    }

//    //暴力解法
//    public int GetUglyNumber_Solution(int index) {
//        if(index<=0){
//            return 0;
//        }
//        int temp = 0;
//        int number = 0;
//        while(temp<index){
//            number++;
//            if(fun(number)){
//                temp++;
//            }
//        }
//        System.out.println(number);
//        return number;
//    }
//
//    private boolean fun(int number) {
//        while(number%2==0){
//            number=number/2;
//        }
//        while(number%3==0){
//            number=number/3;
//        }
//        while(number%5==0){
//            number=number/5;
//        }
//        return number==1?true:false;
    //}


    public static void main(String[] args) {
        Test49 test49 = new Test49();
        test49.GetUglyNumber_Solution(7);
    }
}
