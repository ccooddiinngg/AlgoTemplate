package Leetcode.Coding_Interview_6.C16;

import java.util.ArrayList;
import java.util.List;

public class S24a {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        mergeSort(nums, 0, nums.length - 1);
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (nums[j] > target - nums[i]) {
                j--;
            } else if (nums[j] == target - nums[i]) {
                list.add(List.of(nums[i], nums[j]));
                i++;
                j--;
            } else {
                i++;
            }
        }
        return list;
    }

    void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    void merge(int[] nums, int l, int mid, int r) {
        int[] t = new int[r - l + 1];
        int idx = 0;
        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            t[idx++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            t[idx++] = nums[i++];
        }
        while (j <= r) {
            t[idx++] = nums[j++];
        }
        for (int k = 0, k1 = l; k < t.length; k++, k1++) {
            nums[k1] = t[k];
        }
    }

    void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int[] i = partition(nums, l, r);
        quickSort(nums, l, i[0] - 1);
        quickSort(nums, i[1] + 1, r);
    }

    int[] partition(int[] nums, int l, int r) {
        int t = nums[l + r >> 1];
        int i = l;
        int j = r;
        int p = l;
        while (p <= j) {
            if (nums[p] < t) {
                swap(nums, i, p);
                i++;
                p++;
            } else if (nums[p] == t) {
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
}
