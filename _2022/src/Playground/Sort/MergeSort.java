package Playground.Sort;

public class MergeSort {
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l == r) return;
        int mid = l + r >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] t = new int[r - l + 1];
        int idx = 0;
        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] < nums[j]) {
                t[idx++] = nums[i++];
            } else {
                t[idx++] = nums[j++];
            }
        }
        while (i <= mid) {
            t[idx++] = nums[i++];
        }
        while (j <= r) {
            t[idx++] = nums[j++];
        }
        System.arraycopy(t, 0, nums, l, t.length);
    }
}
