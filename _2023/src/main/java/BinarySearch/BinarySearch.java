package BinarySearch;

public class BinarySearch {

    public int searchGreaterEqual(int[] nums, int t) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (nums[mid] >= t) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;
    }

    public int searchLessEqual(int[] nums, int t) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = i + j + 1 >> 1;
            if (nums[mid] <= t) {
                i = mid;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
