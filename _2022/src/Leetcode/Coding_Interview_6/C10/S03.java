package Leetcode.Coding_Interview_6.C10;

public class S03 {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        while (i <= j) {
            if (arr[i] == target) return i;
            int mid = i + (j - i) / 2;
            if (arr[mid] == target) {
                j = mid;
            } else if (arr[mid] > arr[0]) {
                if (arr[mid] > target && target >= arr[i]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else if (arr[mid] < arr[n - 1]) {
                if (arr[mid] < target && target <= arr[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            } else {
                i++;
            }
        }
        return -1;
    }
}
