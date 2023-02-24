package Leetcode.Coding_Interview_6.C05;

public class S07a {
    public int exchangeBits(int num) {
        int odd = 0b10101010101010101010101010101010;
        int even = 0b01010101010101010101010101010101;
        //提取奇数位 与 偶数位
        odd = odd & num;
        even = even & num;
        //奇数位变偶数位， 偶数位变奇数位
        return (odd >> 1) | (even << 1);
    }
}
