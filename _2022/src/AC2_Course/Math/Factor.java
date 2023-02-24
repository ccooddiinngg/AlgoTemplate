package AC2_Course.Math;

public class Factor {
    public static void main(String[] args) {
        factor(1035);

        System.out.println(gcd(24, 16));
    }

    static void factor(int n) {
        // use i * i <= n could too big
        for (int i = 2; i <= n / i; i++) {
            //remove all found prime factor
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                System.out.println(i);
            }
        }
    }

    //最大公约数
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }


}
