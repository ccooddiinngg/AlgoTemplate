package Leetcode.Offer;

public class O42 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
