package ZuoChengyun.Basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TreeNode {

    final String val;
    final List<TreeNode> children;

    public TreeNode(String val, List<TreeNode> children) {
        this.val = val;
        this.children = children;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        print(buffer, "", "");
        return buffer.toString();
    }

    private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(val);
        buffer.append('\n');
        for (Iterator<TreeNode> it = children.iterator(); it.hasNext(); ) {
            TreeNode next = it.next();
            if (it.hasNext()) {
                next.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }

    public static void main(String[] args) {
        List<TreeNode> children = new ArrayList<>();
        TreeNode left = new TreeNode("left", new ArrayList<>());
        TreeNode right = new TreeNode("right", new ArrayList<>());
        children.add(left);
        children.add(right);
        TreeNode treeNode = new TreeNode("root", children);

        System.out.println(treeNode.toString());
    }
}

