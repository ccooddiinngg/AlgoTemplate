package Leetcode.ACW_LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        //hash
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> arr = new ArrayList<>(set);
        arr.sort((a, b) -> a - b);
        for (int i = 0; i < n; i++) {
            int idx = hash(arr, nums[i]) + 1;
            nums[i] = idx;
        }

        //BIT
        BIT bit = new BIT(n);
        int[] leftMin = new int[n];
        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(nums[i], leftMin[i - 1]);
        }
        bit.update(nums[n - 1], 1);
        for (int i = n - 2; i >= 1; i--) {
            if (nums[i] > leftMin[i]) {
                int count = bit.ask(nums[i] - 1) - bit.ask(leftMin[i]);
                if (count > 0) return true;
            }
            bit.update(nums[i], 1);
        }

        return false;
    }

    //index of number >= num
    int hash(List<Integer> arr, int num) {
        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (arr.get(mid) >= num) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    class BIT {
        int[] tree;
        int n;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lowBit(int n) {
            return n & -n;
        }

        void update(int idx, int val) {
            while (idx <= n) {
                tree[idx] += val;
                idx += lowBit(idx);
            }
        }

        int ask(int idx) {
            int res = 0;
            while (idx > 0) {
                res += tree[idx];
                idx -= lowBit(idx);
            }
            return res;
        }
    }

}
