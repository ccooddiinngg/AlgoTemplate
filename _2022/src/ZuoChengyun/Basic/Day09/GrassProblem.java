package ZuoChengyun.Basic.Day09;

public class GrassProblem {

    //goat first , cow second, 1, 4, 16, 64,...
    //true if goat wins
    public static boolean eat(int N) {
        if (N < 5) {
            return N != 0 && N != 2;
        }
        int num = 1;
        while (num <= N) {
            if (!eat(N - num)) {
                return true;
            }
            if (num > N / 4) break;
            num *= 4;
        }
        return false;
    }

    public static boolean eatV2(int N) {
        int n = N % 5;
        return n != 0 && n != 2;
    }

    public static void main(String[] args) {
        int N = 20;
        for (int i = 0; i <= N; i++) {
            boolean res = eat(i);
            System.out.print(res);
            /*
            false
            true
            false
            true
            true
            */
            System.out.print(" == ");
            boolean resV2 = eatV2(i);
            System.out.print(resV2);
            System.out.println();
        }
    }
}
