package Leetcode.Coding_Interview_6.C08;

public class S05 {
    /*
    其实就是用二进制的视角去看待min，比如12用二进制表示就是1100，即1000+0100。
    举个例子，13 * 12 = 13 * (8 + 4) = 13 * 8 + 13 * 4 = (13 << 3) + (13 << 2)
    */

    public int multiply(int A, int B) {
        return f(A, B, 0);
    }

    int f(int A, int B, int i) {
        if (B == 0) {
            return 0;
        }
        int res = f(A, B >> 1, i + 1);
        if ((B & 1) == 1) {
            res += A << i;
        }
        return res;
    }
}
