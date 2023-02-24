package AC2_Course.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class A908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] seg = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                seg[i][j] = sc.nextInt();
            }
        }

        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        int count = 0;

//        左端排序
//        Arrays.sort(seg, (a, b) -> a[0] - b[0]);
//        for (int i = 0; i < n; i++) {
//            if (seg[i][0] <= end) {
//                if (seg[i][1] < end) {
//                    end = seg[i][1];
//                }
//            } else {
//                start = seg[i][0];
//                end = seg[i][1];
//                count++;
//            }
//        }

        //右端排序
        Arrays.sort(seg, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            if (seg[i][0] > end) {
                count++;
                end = seg[i][1];
            }
        }

        System.out.println(count);
    }
}
