package Leetcode.Coding_Interview_6.C05;

public class S06 {
    public int convertInteger(int A, int B) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int a = A >> i & 1;
            int b = B >> i & 1;
            if ((a ^ b) == 1) count++;
        }
        return count;
    }
}
