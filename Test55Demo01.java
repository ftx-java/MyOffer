package tx.offer;

/**
 * 第55 第1题
 * 二叉树的深度
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 *
 * @author tx
 * @date 2018/05/13
 */
public class Test55Demo01 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nLeft = TreeDepth(root.left);
        int nRight = TreeDepth(root.right);
        return (nLeft > nRight) ? nLeft + 1 : nRight + 1;
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
