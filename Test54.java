package tx.offer;

import java.util.ArrayList;

/**
 * 第54题
 * 二叉搜索树的第k大节点  中序遍历
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author tx
 * @date 2018/05/10
 */
public class Test54 {
    ArrayList<TreeNode> list = new ArrayList<TreeNode>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        fun(pRoot);
        if (pRoot == null || k == 0 || k > list.size()) {
            return null;
        }
        return list.get(k - 1);
    }

    /**
     * 中序遍历将值存到list
     */
    private void fun(TreeNode pRoot) {
        if (pRoot != null) {
            return;
        } else {
            fun(pRoot.left);
            list.add(pRoot);
            fun(pRoot.right);
        }
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
