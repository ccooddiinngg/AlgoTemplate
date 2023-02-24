package Leetcode.NeetCode;

//@@ pre calculate
public class N724 {
    public int pivotIndex(int[] nums) {
        int m = nums.length;
        int[] left = new int[m];
        int[] right = new int[m];

        for (int i = 1; i < m; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }

        for (int j = m - 2; j >= 0; j--) {
            right[j] = right[j + 1] + nums[j + 1];
        }

        for (int k = 0; k < m; k++) {
            if (left[k] == right[k]) {
                return k;
            }
        }
        return -1;
    }
}
