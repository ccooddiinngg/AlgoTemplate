package AC2_Course.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class A907 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();

        int n = sc.nextInt();
        int[][] seg = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                seg[i][j] = sc.nextInt();
            }
        }

        //左端排序
        //取每个开始坐标小于L的区间，记录最长可以到达的右端
        //更新L为上一步得到的最大值
        Arrays.sort(seg, (a, b) -> a[0] - b[0]);
        int i = 0;
        int count = 0;
        int p = L;
        while (i < n && p < R) {
            if (seg[i][0] > p) {
                break;
            }
            int max = p;
            while (i < n && seg[i][0] <= p) {
                max = Math.max(max, seg[i][1]);
                i++;
            }
            p = max;
            count++;
        }
        if (p >= R) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}
