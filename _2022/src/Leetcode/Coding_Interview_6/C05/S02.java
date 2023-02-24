package Leetcode.Coding_Interview_6.C05;

public class S02 {
    //用2乘十进制小数，可以得到积，将积的整数部分取出，再用2乘余下的小数 部分，又得到一个积，再将积的整数部分取出，如此进行，直到积中的小数部分为零，或者达到所要求的精度为止。
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        int i = 32;
        while (num != 0 && i > 0) {
            num *= 2;
            if (num >= 1) {
                sb.append("1");
                num -= 1;
            } else {
                sb.append("0");
            }
            i--;
        }
        if (num != 0) return "ERROR";
        return sb.toString();
    }
}
