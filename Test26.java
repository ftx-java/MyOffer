package tx.offer;

/**
 * 第26题
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @author tx
 * @date 2018/03/31
 */
public class Test26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean flag = false;
        //当两个树都不为空的时候进行比较 否则返回false
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                //找到根节点后 判断剩下的结构的数据是否一致
                flag = DoesTree1HaveTree2(root1, root2);
            }
            if (!flag) {
                flag = HasSubtree(root1.left, root2);
            }
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }

    private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        //如果Tree2已经遍历完了都能对应的上，返回true
        if (root2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (root1 == null) {
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if (root1.val != root2.val) {
            return false;
        }

        //如果根节点对应的上，那么就分别去子节点里面匹配
        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
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
