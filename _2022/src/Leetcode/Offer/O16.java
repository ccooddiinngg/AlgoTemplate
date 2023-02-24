package Leetcode.Offer;

//快速幂
public class O16 {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) return 1 / find(x, -N);
        return find(x, N);
    }

    double find(double x, long N) {
        if (N == 0) return 1;
        double res = find(x, N / 2);
        return N % 2 == 0 ? res * res : res * res * x;
    }
}
