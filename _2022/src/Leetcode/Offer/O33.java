package Leetcode.Offer;

public class O33 {
    public boolean verifyPostorder(int[] postorder) {
        return find(postorder, 0, postorder.length - 1);
    }

    boolean find(int[] nums, int l, int r) {
        if (l >= r) return true;
        int head = nums[r];
        int i = l;
        for (; i < r; i++) {
            if (nums[i] > head) break;
        }
        for (; i < r; i++) {
            if (nums[i] < head) return false;
        }
        return find(nums, l, i - 1) && find(nums, i, r - 1);
    }
}
