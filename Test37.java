package tx.offer;

/**
 * 第37题
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * @author tx
 * @date 2018/04/07
 */
public class Test37 {
    int index = -1;

    String Serialize(TreeNode root) {
        StringBuilder ss = new StringBuilder();
        if (root == null) {
            ss.append("$,");
            return ss.toString();
        }
        ss.append(root.val + ",");
        ss.append(Serialize(root.left));
        ss.append(Serialize(root.right));
        return ss.toString();
    }

    TreeNode Deserialize(String str) {
        index++;
        String[] strings = str.split(",");
        TreeNode node = null;
        if (!strings[index].equals("$")) {
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
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
