package AC2.A6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A905 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<S> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            list.add(new S(l, r));
        }
        int min = getMin(list);
        System.out.println(min);
    }

    static int getMin(List<S> list) {
        list.sort((a, b) -> a.r - b.r);
        int end = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).l > end) {
                count++;
                end = list.get(i).r;
            }
        }
        return count;
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
