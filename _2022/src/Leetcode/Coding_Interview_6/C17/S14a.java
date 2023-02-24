package Leetcode.Coding_Interview_6.C17;

public class S14a {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) return new int[0];
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int[] range = partition(arr, l, r);
            if (k - 1 <= range[1] && k - 1 >= range[0]) {
                int[] res = new int[k];
                for (int i = 0; i < k; i++) {
                    res[i] = arr[i];
                }
                return res;
            } else if (k - 1 < range[0]) {
                r = range[0] - 1;
            } else {
                l = range[1] + 1;
            }
        }
        return new int[0];
    }

    int[] partition(int[] arr, int l, int r) {
        int p = l;
        int mid = arr[l + r >> 1];
        while (p <= r) {
            if (arr[p] < mid) {
                swap(arr, p, l);
                p++;
                l++;
            } else if (arr[p] == mid) {
                p++;
            } else {
                swap(arr, p, r);
                r--;
            }
        }
        return new int[]{l, r};
    }

    void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
