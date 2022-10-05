package tag.BinarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int m = nums.length;
        int i = 0;
        int j = m - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (nums[mid] > nums[j]) {
                if (nums[mid] < target || nums[j] >= target) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            } else {
                if (nums[mid] >= target || nums[j] < target) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            }
        }
        return nums[i] == target ? i : -1;
    }
}
