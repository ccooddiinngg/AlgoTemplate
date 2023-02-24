package AC2.A3;

import java.util.*;

public class A860 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            map.get(from).add(to);
            map.get(to).add(from);
        }

        int[] colors = new int[n + 1];
        boolean b = false;
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                if (!dye(map, i, 1, colors)) {
                    b = true;
                    break;
                }
            }
        }
        if (!b) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static boolean dye(Map<Integer, List<Integer>> map, int curr, int color, int[] colors) {
        if (colors[curr] == color) {
            return true;
        }
        if (colors[curr] + color == 3) {
            return false;
        }
        colors[curr] = color;
        for (int next : map.get(curr)) {
            if (!dye(map, next, 3 - color, colors)) {
                return false;
            }
        }
        return true;
    }
}
