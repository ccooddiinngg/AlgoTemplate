package AC2.A1;

import java.util.Scanner;

public class A785a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    static void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int p = partition(nums, l, r);
        quickSort(nums, l, p);
        quickSort(nums, p + 1, r);
    }

    static int partition(int[] nums, int l, int r) {
        int mid = nums[l + (r - l) / 2];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (nums[++i] < mid) ;
            while (nums[--j] > mid) ;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        return j;
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
