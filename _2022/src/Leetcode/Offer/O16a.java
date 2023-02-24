package Leetcode.Offer;

public class O16a {
    public double myPow(double x, int n) {
        if (n < 0) return 1 / find(x, -(long) n);
        return find(x, n);
    }

    double find(double x, long n) {
        if (n == 0) return 1;
        double res = find(x, n / 2);
        if (n % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }
    }
}
