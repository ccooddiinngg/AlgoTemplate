package AC2_Course.Sort;

/*
 * merge func need 3 args

 */

public class MergeSort implements Sort {

    @Override
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int l1 = l;
        int r1 = mid + 1;
        int index = 0;
        while (l1 <= mid && r1 <= r) {
            temp[index++] = nums[l1] < nums[r1] ? nums[l1++] : nums[r1++];
        }
        while (l1 <= mid) {
            temp[index++] = nums[l1++];
        }
        while (r1 <= r) {
            temp[index++] = nums[r1++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[l + i] = temp[i];
        }
    }
}
