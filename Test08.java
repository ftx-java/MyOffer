package tx.offer;

/**
 * 第8题
 * 二叉树的下一个节点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author tx
 * @date 2018/03/18
 */
public class Test08 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        //如果有右子树则一直找到他最左叶子节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        //若无右子树 则不断判断当前节点的父节点是否为空 若不为空 当前节点的父节点的左节点若是当前节点则找到
        //注意 next指向当前节点的父节点
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
        }
        //到根节点也没找到  返回null
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
