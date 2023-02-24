package Leetcode.ACW_LeetCode;

public class LC52 {
    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] d1 = new boolean[n * 2];
        boolean[] d2 = new boolean[n * 2];
        return bt(n, 0, col, d1, d2);
    }


    int bt(int n, int x, boolean[] col, boolean[] d1, boolean[] d2) {
        if (x == n) return 1;
        int op = 0;
        for (int y = 0; y < n; y++) {
            if (!col[y] && !d1[x + y] && !d2[x - y + n]) {
                col[y] = true;
                d1[x + y] = true;
                d2[x - y + n] = true;
                op += bt(n, x + 1, col, d1, d2);
                col[y] = false;
                d1[x + y] = false;
                d2[x - y + n] = false;
            }
        }
        return op;
    }
}
