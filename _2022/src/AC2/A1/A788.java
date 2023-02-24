package AC2.A1;

import java.util.Scanner;

public class A788 {
    static long count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(count);
    }

    static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    static void merge(int[] nums, int l, int mid, int r) {
        int[] t = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] > nums[j]) {
                //发现第一个比nums[j]大的数，从i以后都是nums[j]的逆序对
                count += mid - i + 1;
                t[k++] = nums[j++];
            } else {
                t[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            t[k++] = nums[i++];
        }
        while (j <= r) {
            t[k++] = nums[j++];
        }
        for (int m = l, n = 0; m <= r; m++, n++) {
            nums[m] = t[n];
        }
    }

}
