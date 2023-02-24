package Leetcode.Offer;

public class O56_2 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            count(count, num);
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 == 1) res += 1 << i;
        }
        return res;
    }

    void count(int[] count, int num) {
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) count[i]++;
        }
    }
}
