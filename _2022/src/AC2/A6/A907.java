package AC2.A6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A907 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        int n = sc.nextInt();
        List<S> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            list.add(new S(l, r));
        }
        int min = getMin(list, left, right);
        System.out.println(min);
    }

    static int getMin(List<S> list, int left, int right) {
        list.sort((a, b) -> a.l - b.l);
        int end = left;
        int count = 0;
        int i = 0;
        while (i < list.size() && end <= right) {
            if (list.get(i).l > end) {
                break;
            }
            int maxDis = end;
            while (i < list.size() && list.get(i).l <= end) {
                maxDis = Math.max(maxDis, list.get(i).r);
                i++;
            }
            if (maxDis >= end) {
                count++;
                end = maxDis;
            }
        }
        return end >= right ? count : -1;
    }

    static class S {
        int l;
        int r;

        public S(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
