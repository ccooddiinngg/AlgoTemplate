package Leetcode.Offer;

public class O14_1 {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;

        if ((n - 2) % 3 == 0) return (int) Math.pow(3, (n - 2) / 3) * 2;
        if ((n - 3) % 3 == 0) return (int) Math.pow(3, (n - 3) / 3) * 3;
        return (int) Math.pow(3, (n - 4) / 3) * 4;
    }
}
