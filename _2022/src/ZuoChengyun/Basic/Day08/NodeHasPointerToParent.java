package ZuoChengyun.Basic.Day08;

public class NodeHasPointerToParent {
    int val;
    NodeHasPointerToParent left;
    NodeHasPointerToParent right;
    NodeHasPointerToParent parent;

    public NodeHasPointerToParent(int val) {
        this.val = val;
    }

    //inorder
    public NodeHasPointerToParent findNext(NodeHasPointerToParent node) {
        if (node == null) return null;

        //has right
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        //has no right
        NodeHasPointerToParent p = node.parent;
        while (p != null && node == p.right) {
            node = p;
            p = node.parent;
        }
        return p;
    }

}
