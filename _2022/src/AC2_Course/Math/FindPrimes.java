package AC2_Course.Math;

public class FindPrimes {
    //埃氏筛
    static void findAll1(int n) {
        boolean[] not = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            //only remove prime's multiple
            if (!not[i]) {
                for (int j = i + i; j <= n; j += i) {
                    not[j] = true;
                }
                System.out.println(i);
            }
        }
    }

    //线性筛
    static void findAll2(int n) {
        boolean[] not = new boolean[n + 1];
        int[] primes = new int[n + 1];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (!not[i]) {
                primes[cnt++] = i;
                System.out.println(i);
            }

            for (int j = 0; primes[j] <= n / i; j++) {
                not[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }

        }
    }
    /*
    n = 40
    2*2
    3*2 3*3
    4*2
    5*2 5*3 5*5
    6*2
    7*2 7*3 7*5
    8*2
    9*2 9*3
    10*2
    11*2 11*3
    12*2
    13*2 13*3
    14*2
    15*2
    16*2
    17*2
    18*2
    19*2
    20*2
    */

    public static void main(String[] args) {
        int n = 40;
        findAll1(n);
        findAll2(n);
    }
}
