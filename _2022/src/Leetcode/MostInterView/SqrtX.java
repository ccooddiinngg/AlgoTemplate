package Leetcode.MostInterView;

public class SqrtX {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int i = 1;
        int j = x;
        int ans = 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            //! find the upper bound
            if (mid <= x / mid) {
                i = mid + 1;
                ans = mid;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }

}
