package tx.offer;

import java.util.ArrayList;

/**
 * 第32题  第一问
 * 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author tx
 * @date 2018/04/02
 */
public class Test32Demo01 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();

        if (root == null) {
            return list;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove(0);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
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
