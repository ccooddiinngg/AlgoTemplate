package DivideAndConquer;

import Utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int m = nums.length;
        int i = 0;
        int j = m - 1;
        while (i < j) {
            int idx = partition(nums, i, j);
            if (idx >= m - k) {
                j = idx;
            } else {
                i = idx + 1;
            }
        }
        return nums[j];
    }

    private int partition(int[] nums, int l, int r) {
        if (l == r) return l;
        int seed = nums[l + r >> 1];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (nums[++i] < seed) ;
            while (nums[--j] > seed) ;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        System.out.printf("left: %d right: %d seed: %d index: %d\n", l, r, seed, j);
        System.out.println(Arrays.toString(nums));
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    @Test
    void test() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        /*left: 0 right: 8 seed: 2 index: 1
        [2, 1, 3, 2, 3, 4, 5, 5, 6]
        left: 2 right: 8 seed: 4 index: 5
        [2, 1, 3, 2, 3, 4, 5, 5, 6]
        left: 2 right: 5 seed: 2 index: 2
        [2, 1, 2, 3, 3, 4, 5, 5, 6]
        left: 3 right: 5 seed: 3 index: 3
        [2, 1, 2, 3, 3, 4, 5, 5, 6]
        left: 4 right: 5 seed: 3 index: 4
        [2, 1, 2, 3, 3, 4, 5, 5, 6]*/

        Assertions.assertEquals(4, findKthLargest(nums, k));
    }

    @Test
    void test1() {
        int[] nums = Utils.buildRandomArray(5);
        int k = (int) (Math.random() * nums.length) + 1;
        System.out.println(Arrays.toString(nums) + " k = " + k);
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        Assertions.assertEquals(copy[copy.length - k], findKthLargest(nums, k));
    }


}
