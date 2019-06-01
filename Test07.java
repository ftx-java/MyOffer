package tx.offer;


import java.util.ArrayList;
import java.util.List;

/**
 * 第7题
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author tx
 * @date 2018/03/12
 */
public class Test07 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        ArrayList<Integer> startList = new ArrayList<Integer>(pre.length);
        ArrayList<Integer> inList = new ArrayList<Integer>(in.length);
        for (int i : pre) {
            startList.add(i);
        }
        for (int i : in) {
            inList.add(i);
        }
        return getRootNode(startList, inList);
    }

    private TreeNode getRootNode(List<Integer> startList, List<Integer> inList) {
        if (startList.size() == 0 || inList.size() == 0) {
            return null;
        }

        int rootKey = startList.get(0);
        TreeNode treeNode = new TreeNode(rootKey);
        int index = inList.indexOf(rootKey);
        List<Integer> inLeftList = inList.subList(0, index);
        List<Integer> inRightList = inList.subList(index + 1, inList.size());
        List<Integer> startLeftList = startList.subList(1, inLeftList.size() + 1);
        List<Integer> startRightList = startList.subList(startList.size() - inRightList.size(), startList.size());

        treeNode.left = getRootNode(startLeftList, inLeftList);
        treeNode.right = getRootNode(startRightList, inRightList);
        return treeNode;
    }

    public static void main(String[] args) {
        Test07 test07 = new Test07();
       // test07.reConstructBinaryTree()
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

