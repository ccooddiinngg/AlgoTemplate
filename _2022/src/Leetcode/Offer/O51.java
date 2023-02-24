package Leetcode.Offer;

import java.util.Arrays;

public class O51 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] temp = Arrays.copyOfRange(nums, 0, n);
        Arrays.sort(temp);
        int[] arr = new int[n];
        //arr = [1, 2, 3... n]
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.binarySearch(temp, nums[i]) + 1;
        }
        BIT bit = new BIT(n);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            bit.update(arr[i], 1);
            res += i + 1 - bit.ask(arr[i]);
        }
        return res;
    }

    class BIT {
        int n;
        int[] nums;

        public BIT(int n) {
            this.n = n;
            nums = new int[n + 1];
        }

        int lowBit(int x) {
            return x & -x;
        }

        void update(int x, int v) {
            while (x <= n) {
                nums[x] += v;
                x += lowBit(x);
            }
        }

        int ask(int x) {
            int res = 0;
            while (x > 0) {
                res += nums[x];
                x -= lowBit(x);
            }
            return res;
        }
    }
}
