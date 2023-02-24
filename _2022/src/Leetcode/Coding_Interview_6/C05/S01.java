package Leetcode.Coding_Interview_6.C05;

public class S01 {
    public static void main(String[] args) {
        int N = 1143207437;
        int M = 1017033;
        int i = 11;
        int j = 31;
    }

    public int insertBits(int N, int M, int i, int j) {

        //不能用 N >> (j + 1) , 如果j == 31, 那么就是 N >> 32 ， 等与N
        return ((N >> j >> 1) << j << 1) | (M << i) | (N & ((1 << i) - 1));
    }
}
