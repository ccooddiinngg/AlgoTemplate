package Leetcode.Offer;

public class O39 {
    public int majorityElement(int[] nums) {
        int k = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                k = nums[i];
            }
            if (nums[i] == k) {
                count++;
            } else {
                count--;
            }
        }
        return k;
    }
}
