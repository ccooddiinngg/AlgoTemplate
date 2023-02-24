package Leetcode.Offer;

public class O15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n -= n & -n;
        }
        return count;
    }
}
