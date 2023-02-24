package Leetcode.Offer;

public class O49 {
    public int nthUglyNumber(int n) {
        int[] p = new int[3];
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int p2 = res[p[0]] * 2;
            int p3 = res[p[1]] * 3;
            int p5 = res[p[2]] * 5;
            int min = Math.min(Math.min(p2, p3), p5);
            if (p2 == min) p[0]++;
            if (p3 == min) p[1]++;
            if (p5 == min) p[2]++;
            res[i] = min;
        }
        return res[n - 1];
    }
}
