package Leetcode.Coding_Interview_6.C05;

public class S04 {
    /*
    找到稍微大的数：
    找到第一个01变成10

    最简单情况 ...00000111 从低位到高位，找到第一个01变成10 0000 0111->0000 1011即可
    复杂情况 ...0011 1000 找到第一个01变成10以后，把低位的1右移 0011 1000->01011000->0100 0011第三个数是稍微大的，符合题意

    找到稍微小的数：
    找到第一个10变成01

    最简单情况 ...1110 0000 从低位到高位，找到第一个10变成01 1110 0000->1101 0000即可
    复杂情况 ...1110 0011 找到第一个10变成01以后，把低位的1右移 1110 0011->1110 0011->1101 0011->1101 1100 第三个数符合题意
    */
    public int[] findClosedNumbers(int num) {
        return new int[]{findMax(num), findMin(num)};
    }

    int findMax(int num) {
        boolean found = false;
        int count = 0;
        int i = 0;
        for (; i < 32; i++) {
            if ((num >> i & 1) == 1) found = true;
            if (found && (num >> i & 1) == 0) break;
            if (found) count++;
        }
//        System.out.print(i + " " + count);
        if (i == 31) return -1;
        num = ((num >> i) | 1) << i;
        num = num | ((1 << (count - 1)) - 1);
        return num;
    }

    int findMin(int num) {
        boolean found = false;
        int count = 0;
        int i = 0;
        for (; i < 32; i++) {
            if (!found && (num >> i & 1) == 0) found = true;
            if (found && (num >> i & 1) == 1) break;
            if (!found) count++;
        }
        if (i == 32) return -1;
        // System.out.print(i + " " + count);
        num = num >> i >> 1 << i << 1;
        num = num | ((1 << (count + 1)) - 1) << (i - count - 1);
        return num;
    }
}
