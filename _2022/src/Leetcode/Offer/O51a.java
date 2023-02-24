package Leetcode.Offer;

public class O51a {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        mergSort(nums, 0, nums.length - 1);
        // System.out.println(Arrays.toString(nums));
        return count;
    }

    int count = 0;

    void mergSort(int[] nums, int l, int r) {
        if (l == r) return;
        int mid = l + r >> 1;
        mergSort(nums, l, mid);
        mergSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[idx++] = nums[i++];
            } else {
                temp[idx++] = nums[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) {
            temp[idx++] = nums[i++];
        }
        while (j <= r) {
            temp[idx++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, l, temp.length);
    }
}
