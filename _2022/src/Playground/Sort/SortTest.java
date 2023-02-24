package Playground.Sort;

import java.util.Arrays;
import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = r.nextInt(100);
        }

        QuickSort quickSort = new QuickSort();
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(nums));
        mergeSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
