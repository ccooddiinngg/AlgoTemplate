package Leetcode.Coding_Interview_6.C05;

public class S07 {
    public int exchangeBits(int num) {
        for (int i = 0; i < 31; i += 2) {
            int j = i + 1;
            int e = num >> i & 1;
            int o = num >> j & 1;
            if ((e ^ o) == 1) {
                if (e == 0) {
                    num += 1 << i;
                } else {
                    num -= 1 << i;
                }
                if (o == 0) {
                    num += 1 << j;
                } else {
                    num -= 1 << j;
                }
            }
        }
        return num;
    }
}
