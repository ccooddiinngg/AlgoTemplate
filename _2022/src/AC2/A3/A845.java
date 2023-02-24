package AC2.A3;

import java.util.*;

public class A845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : s) {
            sb.append(str);
        }
        int step = bfs(sb.toString(), "12345678x", new HashSet<>());
        System.out.println(step);
    }

    static int bfs(String s, String tar, Set<String> set) {
        Queue<String> q = new LinkedList<>();
        q.add(s);
        int step = 0;
        int size = 1;
        boolean found = false;
        while (size > 0) {
            String curr = q.poll();
            if (curr.equals(tar)) {
                found = true;
                break;
            }
            List<String> next = transform(curr);
            for (String str : next) {
                if (!set.contains(str)) {
                    set.add(str);
                    q.add(str);
                }
            }
            size--;
            if (size == 0) {
                step++;
                size = q.size();
            }
        }
        return found ? step : -1;
    }

    static List<String> transform(String s) {
        List<String> list = new ArrayList<>();
        int idx = s.indexOf('x');
        int i = idx / 3;
        int j = idx % 3;
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int d = 0; d < 4; d++) {
            int i1 = i + dir[d][0];
            int j1 = j + dir[d][1];
            if (i1 >= 0 && j1 >= 0 && i1 < 3 && j1 < 3) {
                list.add(swap(s, idx, i1 * 3 + j1));
            }
        }
        return list;
    }

    static String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
        return String.valueOf(chars);
    }
}
