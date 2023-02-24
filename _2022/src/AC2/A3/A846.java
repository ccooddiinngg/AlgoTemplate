package AC2.A3;

import java.util.*;

public class A846 {

    static int minSize = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            map.get(from).add(to);
            map.get(to).add(from);
        }
        getSize(n, 1, map, new HashSet<>());
        System.out.println(minSize);
    }

    //curr size;
    static int getSize(int n, int curr, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        visited.add(curr);
        int max = 0;
        int count = 1;
        for (int next : map.get(curr)) {
            if (!visited.contains(next)) {
                visited.add(next);
                int nextSize = getSize(n, next, map, visited);
                max = Math.max(max, nextSize);
                count += nextSize;
            }
        }
        max = Math.max(max, n - count);
        minSize = Math.min(minSize, max);
//        System.out.println(curr + " -> " + count);
        return count;
    }
}
