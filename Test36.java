package tx.offer;

/**
 * 第36题
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author tx
 * @date 2018/04/07
 */
public class Test36 {
    /**
     * 双向链表的左边头结点和右边头节点
     */
    TreeNode head = null;
    TreeNode tail = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        //递归调用叶子节点的左右节点返回null
        if (pRootOfTree == null) {
            return null;
        }
        //第一次运行时，它会使最左边叶子节点为链表第一个节点
        Convert(pRootOfTree.left);
        if (tail == null) {
            head = tail = pRootOfTree;
        } else {
            //把根节点插入到双向链表右边，tail向后移动
            tail.right = pRootOfTree;
            pRootOfTree.left = tail;
            tail = pRootOfTree;
        }
        //把右叶子节点也插入到双向链表
        Convert(pRootOfTree.right);
        //返回左边头结点
        return head;
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
