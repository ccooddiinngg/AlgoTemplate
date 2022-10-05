package tag.BinarySearch;


//总是试图抛弃一半
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (nums[mid] > nums[j]) {
                if (nums[mid] < target || nums[j] >= target) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            } else if (nums[mid] < nums[j]) {
                if (nums[mid] >= target || nums[j] < target) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            } else {
                j--;
            }
        }
        return nums[i] == target;
    }
}
