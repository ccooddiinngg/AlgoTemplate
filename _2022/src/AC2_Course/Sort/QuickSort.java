package AC2_Course.Sort;

/*
! Bug: use nums[mid] in if condition, when nums[mid] changes, partition failed;

* partition returns seed range, next sort should use l -> rangeLeft - 1 and rangeRight + 1 -> r ;

* 3 conditions: < = >
*/
public class QuickSort implements Sort {
    @Override
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int[] index = partition(nums, l, r);
        quickSort(nums, l, index[0] - 1);
        quickSort(nums, index[1] + 1, r);
    }

    private int[] partition(int[] nums, int l, int r) {
        int mid = (int) (l + Math.random() * (r - l));
        int seed = nums[mid];
        int i = l;
        int j = r;
        int p = l;
        while (p <= j) {
            if (nums[p] < seed) {
                swap(nums, p, i);
                p++;
                i++;
            } else if (nums[p] == seed) {
                p++;
            } else {
                swap(nums, p, j);
                j--;
            }
        }
        return new int[]{i, j};
    }
    void swap(int[] nums, int i , int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
