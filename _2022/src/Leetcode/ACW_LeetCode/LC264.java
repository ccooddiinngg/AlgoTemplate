package Leetcode.ACW_LeetCode;

public class LC264 {
    public int nthUglyNumber(int n) {
        int[] p = new int[3];
        int[] nums = new int[n];
        nums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int n2 = nums[p[0]] * 2;
            int n3 = nums[p[1]] * 3;
            int n5 = nums[p[2]] * 5;
            int min = Math.min(Math.min(n2, n3), n5);
            if (min == n2) p[0]++;
            if (min == n3) p[1]++;
            if (min == n5) p[2]++;
            nums[i] = min;
        }
        return nums[n - 1];
    }
}
