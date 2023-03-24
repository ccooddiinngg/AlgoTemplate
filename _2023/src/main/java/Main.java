import Utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

    }

    void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int[] idx = partition(nums, l, r);
        quickSort(nums, l, idx[0] - 1);
        quickSort(nums, idx[1] + 1, r);
    }

    int[] partition(int[] nums, int l, int r) {
        int seed = nums[l + r >> 1];
        int i = l;
        int j = r;
        int p = l;
        while (p <= j) {
            if (nums[p] < seed) {
                swap(nums, i, p);
                i++;
                p++;
            } else if (nums[p] == seed) {
                p++;
            } else {
                swap(nums, p, j);
                j--;
            }
        }
        return new int[]{i, j};
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    @RepeatedTest(100)
    void repeatedTest() {
        int[] nums = Utils.buildRandomArray(10);
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        quickSort(nums, 0, nums.length - 1);
        Assertions.assertArrayEquals(copy, nums);
    }

}
