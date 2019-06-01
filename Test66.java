package tx.offer;

import java.util.Arrays;

/**
 * 第66题
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * @author tx
 * @date 2019/02/26
 */
public class Test66 {
    public int[] multiply(int[] A) {
        // 高效算法
        int[] B = new int[A.length];
        B[0] = 1;

        if (A == null || A.length < 2) {
            return null;
        }

        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            temp = temp * A[i + 1];
            B[i] *= temp;
        }

        System.out.println(Arrays.toString(B));
        return B;

//        /**
//         *  普通方法 连乘 让A[i]=1 这里注意：由于每次都要计算A的连乘 每次循环用的应该是A最初的值
//         *  所以不可以用C=A  而是 C = Arrays.copyOf(A, A.length);
//         */
//        int[] B = new int[A.length];
//        int[] C = Arrays.copyOf(A, A.length);
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < A.length; j++) {
//                if (i == j) {
//                    C[i] = 1;
//                }
//                if (j == 0) {
//                    continue;
//                }
//                C[j] = C[j] * C[j - 1];
//            }
//            B[i] = C[C.length - 1];
//            C = Arrays.copyOf(A, A.length);
//        }
//        System.out.println(Arrays.toString(B));
//        return B;
    }

    public static void main(String[] args) {
        int[] A = {3, 3, 4, 5, 6, 7, 9};
        Test66 test66 = new Test66();
        test66.multiply(A);
    }
}
