package tag.BinarySearch;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (nums[mid] > nums[j]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return nums[i];
    }
}
