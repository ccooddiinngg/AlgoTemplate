package ZuoChengyun.Basic.Day09;

public class BuyApple {

    public static int buyV1(int N) {
        for (int i = 0; i <= N / 6; i++) {
            for (int j = 0; j <= N / 8; j++) {
                if (i * 6 + j * 8 == N) {
                    return i + j;
                }
            }
        }
        return -1;
    }

    public static int buyV2(int N) {
        if (N <= 0) return 0;
        if ((N & 1) != 0) {
            return -1;
        }
        if (N < 18) {
            return N == 6 || N == 8 ? 1 : N == 12 || N == 14 || N == 16 ? 2 : -1;
        }
        return (N - 18) / 8 + 3;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            System.out.println(buyV1(i));
            System.out.println(buyV2(i));
            System.out.println("==");
        }
    }
}
