package Playground.Tree;

public class DeserializerDFS implements Deserializer {


    @Override
    public TreeNode deserialize(String[] strs) {
        return dfs(strs);
    }

    private int idx = 0;

    private TreeNode dfs(String[] strs) {
        if (strs[idx].equals("null")) {
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[idx]));
        idx++;
        root.left = dfs(strs);
        root.right = dfs(strs);
        return root;
    }
}
