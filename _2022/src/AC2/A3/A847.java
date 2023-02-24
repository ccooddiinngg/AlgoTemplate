package AC2.A3;

import java.util.*;

public class A847 {
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
        }
        extend(map, 1, n, new HashSet<>());
    }

    static void extend(Map<Integer, List<Integer>> map, int start, int end, Set<Integer> visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int range = 0;
        int size = 1;
        boolean found = false;
        while (size > 0) {
            int curr = q.poll();
            visited.add(curr);
            if (curr == end) {
                found = true;
                break;
            }
            for (int next : map.get(curr)) {
                if (!visited.contains(next)) {
                    q.add(next);
                }
            }
            size--;
            if (size == 0) {
                range++;
                size = q.size();
            }
        }
        if (found) {
            System.out.println(range);
        } else {
            System.out.println(-1);
        }
    }
}
