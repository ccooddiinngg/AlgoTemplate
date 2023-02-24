package AC2.A6;

import java.util.*;

public class A906 {
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
        list.sort((a, b) -> a.l - b.l);
        Queue<Integer> q = new PriorityQueue<>();
        int end = Integer.MAX_VALUE;
        q.add(end);
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).l <= q.peek()) {
                count++;
            } else {
                q.poll();
            }
            q.add(list.get(i).r);
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
