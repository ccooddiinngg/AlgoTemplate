package Playground.Tree;

public class TreeSerializeDFSDemo {
    public static void main(String[] args) {
        String data = "4,2,1,null,null,3,null,null,6,5,null,null,7,null,null";
        TreeNode root = deserialize(data);
        System.out.println(serialize(root));
    }


    static String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    static TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        return deSerial(strs);
    }

    static int idx = 0;

    static TreeNode deSerial(String[] strs) {
        if (strs[idx].equals("null")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[idx]));
        idx++;
        root.left = deSerial(strs);
        root.right = deSerial(strs);
        return root;
    }
}
