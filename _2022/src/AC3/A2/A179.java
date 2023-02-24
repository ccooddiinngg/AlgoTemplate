package AC3.A2;

import java.util.*;

/*BFS from start to end*/
public class A179 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().replace(" ", "");
        String end = "12345678x";
        B b = new B(s, end);
        b.play();
    }

    static class B {
        Map<String, String> path = new HashMap<>();
        String start;
        String end;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        char[] dirString = {'d', 'u', 'r', 'l'};

        public B(String start, String end) {
            this.start = start;
            this.end = end;
        }

        public void play() {
            Queue<String> q = new LinkedList<>();
            q.add(start);
            path.put(start, "");
            boolean found = false;
            while (!q.isEmpty()) {
                String curr = q.poll();
                if (end.equals(curr)) {
                    found = true;
                    break;
                }
                int idx = curr.indexOf("x");
                for (int d = 0; d < 4; d++) {
                    int i = idx / 3 + dx[d];
                    int j = idx % 3 + dy[d];
                    if (i >= 0 && j >= 0 && i < 3 && j < 3) {
                        String str = swap(curr, idx, i * 3 + j);
                        if (!path.containsKey(str)) {
                            path.put(str, path.get(curr) + dirString[d]);
                            q.add(str);
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

    }
}
