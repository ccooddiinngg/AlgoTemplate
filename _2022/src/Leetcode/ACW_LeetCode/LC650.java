package Leetcode.ACW_LeetCode;

public class LC650 {
    // public int minSteps(int n) {
    //     if (n == 1) return 0;
    //     cache = new int[n][n];
    //     return bt(n, 1, 1) + 1;
    // }

    // int[][] cache;
    // int bt(int n, int currLen, int copyLen) {
    //     if (currLen == n) return 0;
    //     if (currLen > n) return 0x3f3f3f3f;

    //     int next1 = bt(n, currLen + currLen, currLen) + 2;
    //     int next2 = bt(n, currLen + copyLen, copyLen) + 1;

    //     int min = Math.min(next1, next2);
    //     return min;
    // }

    public int minSteps(int n) {
        int len = 1;
        int copyLen = 0;
        int step = 0;

        while (len < n) {
            if (n % len == 0) {
                copyLen = len;
                step++;
            }
            len += copyLen;
            step++;
        }

        return step;
    }
}
