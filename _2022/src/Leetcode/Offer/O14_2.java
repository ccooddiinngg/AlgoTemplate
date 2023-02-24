package Leetcode.Offer;

public class O14_2 {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        double mod = 1e9 + 7;
        long res = 1;
        while (n > 4) {
            n -= 3;
            res *= 3;
            res %= mod;
        }
        if (n == 2) return (int) (res * 2 % mod);
        if (n == 3) return (int) (res * 3 % mod);
        return (int) (res * 4 % mod);
    }
}
