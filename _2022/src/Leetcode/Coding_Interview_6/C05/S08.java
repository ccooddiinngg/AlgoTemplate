package Leetcode.Coding_Interview_6.C05;

public class S08 {
    /*
     * >>表示有符号数的右移，如果为负数（高位为1），高位补1，如果为正数（高位为0），高位补0；
     * <<表示有符号数的左移，直接低位补0；>>>表示不管有符号数还是无符号数的右移，高位直接补0。
     */

    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int[] res = new int[length];
        int col = w / 32;
        //find index of x1 and x2
        int i1 = x1 / 32 + col * y;
        int i2 = x2 / 32 + col * y;
        x1 %= 32;
        x2 %= 32;

        if (i1 == i2) {
            res[i1] = -1 >>> (31 - x2) << (31 - x2) << (x1) >>> (x1);
        } else {
            res[i1] = -1 << (x1) >>> (x1);
            res[i2] = -1 >>> (31 - x2) << (31 - x2);
            for (int k = i1 + 1; k < i2; k++) {
                res[k] = -1;
            }
        }
        return res;
    }
}
