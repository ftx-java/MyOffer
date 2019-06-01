package tx.offer;

/**
 * 第28题
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @author tx
 * @date 2018/04/01
 */
public class Test28 {
    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode pRoot, TreeNode pRoot1) {
        if (pRoot == null && pRoot1 == null) {
            return true;
        }
        if (pRoot == null || pRoot1 == null) {
            return false;
        }
        if (pRoot.val != pRoot1.val) {
            return false;
        }

        return isSymmetrical(pRoot.left, pRoot1.right) && isSymmetrical(pRoot.right, pRoot1.left);
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
