package AC2_Course.Math;

public class FindPrime {
    public static int find(int start) {
        int res = 0;
        for (int i = start; ; i++) {
            boolean flag = true;
            for (int j = 2; j <= i / j; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(find(1073741789));
    }
}
