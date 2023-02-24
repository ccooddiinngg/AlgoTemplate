package Leetcode.ACW_LeetCode;

public class LC762 {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int x = count1(i);
            // System.out.println(x);
            if (isPrime(x)) {
                count++;
            }
        }
        return count;
    }

    int count1(int x) {
        int count = 0;
        while (x > 0) {
            count++;
            x = (x & (x - 1));
        }
        return count;
    }

    boolean isPrime(int x) {
        if (x < 2) return false;
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }


}
