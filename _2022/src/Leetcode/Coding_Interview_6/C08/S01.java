package Leetcode.Coding_Interview_6.C08;

public class S01 {
    public int waysToStep(int n) {
        int mod = 1000000007;
        int s0 = 1;
        int s1 = 1;
        int s2 = 2;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        for (int i = 3; i < n + 1; i++) {
            int si = ((s2 + s1) % mod + s0) % mod;
            s0 = s1;
            s1 = s2;
            s2 = si;
        }
        return s2;
    }
}
