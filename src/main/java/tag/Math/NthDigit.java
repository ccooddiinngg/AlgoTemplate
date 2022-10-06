package tag.Math;

// 1-9 len: 1, count: 9 * 1
// 10-99 len: 2, count: 90 * 2
// 100-999 len: 3, count: 900 * 3
public class NthDigit {
    public int findNthDigit(int n) {
        int i = 1;
        long j = 9;
        long x = 0;
        long p = x;
        while (x < n) {
            p = x;
            x += i * j;
            i++;
            j *= 10;
        }

        i--;
        n -= p;
        int delta = (n - 1) / i;
        int bit = (n - 1) % i;
        int num = (int) Math.pow(10, i - 1) + delta;
        return Integer.parseInt(String.valueOf(String.valueOf(num).charAt(bit)));
    }
}
