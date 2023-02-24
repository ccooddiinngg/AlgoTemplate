package AC2_Course.Graph;

import java.util.*;

public class A845 {
    public static void main(String[] args) {
        //"2  3  4  1  5  x  7  6  8" -> 19
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            String s = sc.next();
            sb.append(s);
        }
        bfs(sb.toString());
    }

    public static void bfs(String board) {
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        set.add(board);
        q.add(board);
        int size = 1;
        int step = 0;
        boolean found = false;
        while (!q.isEmpty()) {
            String s = q.poll();
            if (check(s)) {
                found = true;
                break;
            }
            List<String> trans = transform(s);
            for (String str : trans) {
                if (!set.contains(str)) {
                    set.add(str);
                    q.add(str);
                }
            }
            size--;
            if (size == 0) {
                size = q.size();
                step++;
            }
        }
        if (found) {
            System.out.println(step);
        } else {
            System.out.println(-1);
        }
    }

    public static List<String> transform(String s) {
        List<String> list = new ArrayList<>();
        int[] hor = {1, -1, 0, 0};
        int[] ver = {0, 0, 1, -1};

        int x = s.indexOf("x");
        for (int k = 0; k < 4; k++) {
            int i = x / 3 + hor[k];
            int j = x % 3 + ver[k];
            if (i >= 0 && i < 3 && j >= 0 && j < 3) {
                list.add(swap(s, x, i * 3 + j));
            }
        }
        return list;
    }

    public static String swap(String s, int a, int b) {
        char[] chars = s.toCharArray();
        char t = chars[a];
        chars[a] = chars[b];
        chars[b] = t;
        return String.valueOf(chars);
    }


    public static boolean check(String s) {
        return "12345678x".equals(s);
    }

}

