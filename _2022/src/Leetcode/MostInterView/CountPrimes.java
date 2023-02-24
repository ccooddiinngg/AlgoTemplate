package Leetcode.MostInterView;

public class CountPrimes {
    public int countPrimes(int n) {
        int[] nums = new int[n];
        int count = 0;
        //! to n square root
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (nums[i] == 0) {
                for (int j = 2; j * i < n; j++) {
                    nums[i * j] = 1;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }

        return count;
    }
}
