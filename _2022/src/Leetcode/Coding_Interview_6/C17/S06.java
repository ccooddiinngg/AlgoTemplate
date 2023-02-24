package Leetcode.Coding_Interview_6.C17;

public class S06 {
    public int numberOf2sInRange(int n) {
        String str = String.valueOf(n);
        int m = str.length();
        int count = 0;
        // left(i)right eg: n = 1321
        // i = 0, left could be 0 to 131, which is 132 * 1. total = 132
        // i = 1, left could be 0 to 12, which is 13 * 10. when left = 13, right could be 0 to 1, which is 2.  total = 132
        // i = 2, left could be 0 to 1, which is 2 * 100. total = 200
        // i = 3, left is 0. total = 0
        // total 132 + 132 + 200 = 464
        for (int i = 0; i < m; i++) {
            int curr = (n / pow(i)) % 10;
            if (curr == 2) {
                count += left(n, i) * pow(i) + right(n, i) + 1;
            } else if (curr > 2) {
                count += (left(n, i) + 1) * pow(i);
            } else {
                count += left(n, i) * pow(i);
            }
        }
        return count;
    }

    int left(int n, int i) {
        return n / (pow(i + 1));
    }

    int right(int n, int i) {
        return n % (pow(i));
    }

    int pow(int i) {
        return (int) Math.pow(10, i);
    }
}
