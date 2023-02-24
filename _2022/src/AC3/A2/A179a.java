package AC3.A2;

import java.util.*;

//A*
public class A179a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replace(" ", "");
        String end = "12345678x";
        B b = new B(s, end);
        b.play();
    }

    static class B {
        Map<String, String> path = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();
        String start;
        String end;
        int n = 3;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        char[] dirString = {'d', 'u', 'r', 'l'};

        public B(String start, String end) {
            this.start = start;
            this.end = end;
        }

        public void play() {
            Queue<P> q = new PriorityQueue<>((a, b) -> a.dis - b.dis);
            q.add(new P(getDis(start), start));
            path.put(start, "");
            dist.put(start, 0);

            boolean found = false;
            while (!q.isEmpty()) {
                P curr = q.poll();
                if (end.equals(curr.s)) {
                    found = true;
                    break;
                }
                int idx = curr.s.indexOf("x");
                for (int d = 0; d < 4; d++) {
                    int i = idx / 3 + dx[d];
                    int j = idx % 3 + dy[d];
                    if (i >= 0 && j >= 0 && i < 3 && j < 3) {
                        String str = swap(curr.s, idx, i * 3 + j);
                        if (!dist.containsKey(str) || dist.get(str) > dist.get(curr.s) + 1) {
                            dist.put(str, dist.get(curr.s) + 1);
                            path.put(str, path.get(curr.s) + dirString[d]);
                            q.add(new P(dist.get(curr.s) + getDis(str), str));
                        }
                    }
                }
            }
            if (found) {
                System.out.println(path.get(end));
            } else {
                System.out.println("unsolvable");
            }
        }

        private String swap(String s, int i, int j) {
            StringBuilder sb = new StringBuilder(s);
            char ci = sb.charAt(i);
            char cj = sb.charAt(j);
            sb.setCharAt(j, ci);
            sb.setCharAt(i, cj);
            return sb.toString();
        }

        private int getDis(String s) {
            int dis = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != 'x') {
                    int t = c - '1';
                    dis += Math.abs(i / n - t / n) + Math.abs(i % n - t % n);
                }
            }
            return dis;
        }

        static class P {
            int dis;
            String s;

            public P(int dis, String s) {
                this.dis = dis;
                this.s = s;
            }
        }
    }
}
