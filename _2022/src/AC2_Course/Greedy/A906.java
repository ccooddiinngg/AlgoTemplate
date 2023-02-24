package AC2_Course.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class A906 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] seg = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                seg[i][j] = sc.nextInt();
            }
        }

        //1. 按左端点排序
        //2. 看能否插入到已有的组中, 修改这个组的最大值
//        Arrays.sort(seg, (a, b) -> a[0] - b[0]);
//        int[] group = new int[n];
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            boolean b = false;
//            for (int j = 0; j < count; j++) {
//                if (seg[i][0] > group[j]) {
//                    group[j] = seg[i][1];
//                    b = true;
//                    break;
//                }
//            }
//            if (!b) {
//                group[count++] = seg[i][1];
//
//            }
//        }
//        System.out.println(count);

        //用小根堆优化
        int count = 0;
        Arrays.sort(seg, (a, b) -> a[0] - b[0]);
        Queue<Integer> min = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (min.isEmpty() || min.peek() >= seg[i][0]) {
                count++;
            } else {
                min.poll();
            }
            min.add(seg[i][1]);
        }
        System.out.println(count);
    }
}
