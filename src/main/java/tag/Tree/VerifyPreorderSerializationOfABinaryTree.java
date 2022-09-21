package tag.Tree;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        String[] pre = preorder.split(",");
        int slot = 1;
        for (int i = 0; i < pre.length; i++) {
            if ("#".equals(pre[i])) {
                slot--;
            } else {
                slot++;
            }
            if (i < pre.length - 1 && slot <= 0) return false;
        }
        return slot == 0;
    }
}
