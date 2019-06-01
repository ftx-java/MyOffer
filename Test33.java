package tx.offer;

/**
 * 第33题
 * 二叉搜索树的后序遍历
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @author tx
 * @date 2018/04/05
 */
public class Test33 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    private boolean judge(int[] sequence, int start, int end) {
        //起始点大于等于结束点递归结束
        if (start >= end) {
            return true;
        }
        //遍历左子树的值均小于根节点的值
        int i = start;
        while (sequence[i] < sequence[end]) {
            i++;
        }
        //遍历右子树的值均要大于根节点的值
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        //递归判断左子树与右子树是否符合搜索树条件
        return judge(sequence, start, i - 1) && judge(sequence, i, end - 1);
    }

    public static void main(String[] args) {
        int[] a = {5,7,6,9,11,10,8};
        Test33 test33 = new Test33();
        boolean b = test33.VerifySquenceOfBST(a);
        System.out.println(b);
    }
}
