package Playground.Sort;

public class QuickSort {

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int idx = partition(nums, l, r);
        quickSort(nums, l, idx);
        quickSort(nums, idx + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        int mid = nums[l + r >> 1];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (nums[++i] < mid) ;
            while (nums[--j] > mid) ;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
