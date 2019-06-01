package tx.offer;

/**
 * 第55 第2题
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * @author tx
 * @date 2018/05/13
 */
public class Test55Demo02 {
    public boolean IsBalanced_Solution(TreeNode root) {
        return TreeDepth(root) != -1;
    }

    private int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = TreeDepth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
