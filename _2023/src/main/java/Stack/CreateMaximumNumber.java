package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] nums = null;
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(nums1.length, k); i++) {
            int j = k - i;
            int[] ans = merge(maxNum(nums1, i), maxNum(nums2, j));
            if (nums == null || compare(nums, 0, ans, 0) < 0) {
                nums = Arrays.copyOf(ans, ans.length);
            }
        }
        return nums;
    }

    int[] maxNum(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            //how many nums i have: nums.length - 1 - i
            while (!stack.isEmpty() && stack.peek() < nums[i] && (nums.length - 1 - i + stack.size() >= k)) {
                stack.pop();
            }
            stack.push(nums[i]);
        }
        int[] ans = new int[k];
        int idx = k - 1;
        while (stack.size() > k) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            ans[idx--] = stack.pop();
        }
        return ans;
    }

    int[] merge(int[] a, int[] b) {
        int[] ans = new int[a.length + b.length];
        int idx = 0;
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (compare(a, i, b, j) > 0) {
                ans[idx++] = a[i++];
            } else {
                ans[idx++] = b[j++];
            }
        }
        while (i < a.length) {
            ans[idx++] = a[i++];
        }
        while (j < b.length) {
            ans[idx++] = b[j++];
        }
        return ans;
    }

    //compare arr starts from i, j
    int compare(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) return 1;
            if (a[i] < b[j]) return -1;
            i++;
            j++;
        }
        return (a.length - i) - (b.length - j);
    }


    @Test
    void test1() {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        Assertions.assertArrayEquals(new int[]{9, 8, 6, 5, 3}, maxNumber(nums1, nums2, k));
    }

    @Test
    void test2() {
        int[] nums1 = {6, 7};
        int[] nums2 = {6, 0, 4};
        int k = 5;
        Assertions.assertArrayEquals(new int[]{6, 7, 6, 0, 4}, maxNumber(nums1, nums2, k));
    }

    @Test
    void test3() {
        int[] nums1 = {6, 3, 9, 0, 5, 6};
        int[] nums2 = {2, 2, 5, 2, 1, 4, 4, 5, 7, 8, 9, 3, 1, 6, 9, 7, 0};
        int k = 23;
        Assertions.assertArrayEquals(new int[]{6, 3, 9, 2, 2, 5, 2, 1, 4, 4, 5, 7, 8, 9, 3, 1, 6, 9, 7, 0, 5, 6, 0}, maxNumber(nums1, nums2, k));
    }
}
