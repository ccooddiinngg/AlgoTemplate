package Leetcode.Coding_Interview_6.C05;

public class S03 {
    public int reverseBits(int num) {
        int count = 0, pre = 0, max = 0;
        for (int i = 0; i < 32; i++) {
            if (((num >> i) & 1) == 1) {
                count++;
            } else {
                pre = count;
                count = 0;
            }
            max = Math.max(max, pre + count + 1);
        }
        //if num = -1, max could be 33
        return Math.min(max, 32);
    }
}
