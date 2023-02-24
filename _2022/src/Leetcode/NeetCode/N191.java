package Leetcode.NeetCode;

public class N191 {
    public int hammingWeight(int n) {
        int count = 0;
        int i = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
