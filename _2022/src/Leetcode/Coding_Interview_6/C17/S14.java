package Leetcode.Coding_Interview_6.C17;

public class S14 {
    public int[] smallestK(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int idx = partition(arr, l, r);
            if (idx == k - 1) {
                int[] res = new int[k];
                for (int i = 0; i < k; i++) {
                    res[i] = arr[i];
                }
                return res;
            } else if (idx < k - 1) {
                l = idx + 1;
            } else {
                r = idx;
            }
        }
        return new int[0];
    }

    // [l -> j] <= [j + 1 -> r] you don't know where mid is
    int partition(int[] arr, int l, int r) {
        int mid = arr[l + r >> 1];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {
            while (arr[++i] < mid) ;
            while (arr[--j] > mid) ;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return j;
    }
}
