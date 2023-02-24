package AC2.A3;

import java.util.*;

public class A842 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(n, new ArrayList<>(), new HashSet<>());
    }

    private static void dfs(int n, List<Integer> path, Set<Integer> used) {
        if (path.size() == n) {
            for (int e : path) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            if (!used.contains(i)) {
                used.add(i);
                path.add(i);
                dfs(n, path, used);
                used.remove(i);
                path.remove(path.size() - 1);
            }
        }
    }
}
