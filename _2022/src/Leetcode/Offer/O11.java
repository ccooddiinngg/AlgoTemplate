package Leetcode.Offer;

public class O11 {
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else if (numbers[mid] < numbers[r]) {
                r = mid;
            } else {
                r--;
            }
        }
        return numbers[l];
    }
}
