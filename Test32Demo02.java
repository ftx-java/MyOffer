package tx.offer;

import java.util.ArrayList;

/**
 * 第32题 第二问
 * 分行从上往下打印二叉树
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @author tx
 * @date 2018/04/02
 */
public class Test32Demo02 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();

        if (pRoot == null) {
            return res;
        }

        queue.add(pRoot);
        int start = 0;
        int end = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove(0);
            list.add(temp.val);
            start++;
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            if (start == end) {
                end = queue.size();
                start = 0;
                res.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return res;
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
