package tx.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 第32题 第三问
 * 之字形打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author tx
 * @date 2018/04/04
 */
public class Test32Demo03 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return list;
        }
        //s1保存奇数层节点 s2保存偶数层节点
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(pRoot);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                ArrayList<Integer> list1 = new ArrayList<Integer>();
                while (!s1.isEmpty()) {
                    TreeNode temp = s1.pop();
                    list1.add(temp.val);
                    if (temp.left != null) {
                        s2.push(temp.left);
                    }
                    if (temp.right != null) {
                        s2.push(temp.right);
                    }
                }
                list.add(list1);
            } else {
                ArrayList<Integer> list1 = new ArrayList<Integer>();
                while (!s2.isEmpty()) {
                    TreeNode temp = s2.pop();
                    list1.add(temp.val);
                    if (temp.right != null) {
                        s1.push(temp.right);
                    }
                    if (temp.left != null) {
                        s1.push(temp.left);
                    }
                }
                list.add(list1);
            }
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
