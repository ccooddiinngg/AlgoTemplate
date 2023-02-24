package Leetcode.ACW_LeetCode;

public class LC331 {
    public boolean isValidSerialization(String preorder) {
        String[] pre = preorder.split(",");
        int n = pre.length;
        int slot = 1;
        for (int i = 0; i < n; i++) {
            if (slot == 0) return false;
            if (pre[i].equals("#")) {
                slot--;
            } else {
                slot++;
            }
        }
        return slot == 0;
    }
}
