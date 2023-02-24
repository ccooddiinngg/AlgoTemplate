package AC2_Course.Sort;

//背就完事了
public class QuickSortMod implements Sort {
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int i = l - 1, j = r + 1, x = nums[l + r >> 1];
        while (i < j) {
            while (nums[++i] < x) ;
            while (nums[--j] > x) ;
            if (i < j) swap(nums, i, j);
        }
        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
