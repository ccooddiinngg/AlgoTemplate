package AC2.A3;

import java.util.*;

public class A861 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n1; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            map.get(from).add(to);
        }
        int[] match = new int[n2 + 1];

        int count = 0;
        for (int i = 1; i <= n1; i++) {
            if (find(map, match, i, new int[n2 + 1])) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean find(Map<Integer, List<Integer>> map, int[] match, int curr, int[] green) {
        for (int next : map.get(curr)) {
            if (green[next] == 0) {
                green[next] = curr;
                if (match[next] == 0 || find(map, match, match[next], green)) {
                    match[next] = curr;
                    return true;
                }
            }
        }
        return false;
    }
}
