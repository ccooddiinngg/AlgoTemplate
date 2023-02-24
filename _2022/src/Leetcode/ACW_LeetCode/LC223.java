package Leetcode.ACW_LeetCode;

public class LC223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int lenX = (ax2 - ax1) + (bx2 - bx1) - (Math.max(ax2, bx2) - Math.min(ax1, bx1));
        int lenY = (ay2 - ay1) + (by2 - by1) - (Math.max(ay2, by2) - Math.min(ay1, by1));
        int res = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        if (lenX > 0 && lenY > 0) {
            res -= lenX * lenY;
        }
        return res;
    }
}
