package AC2_Course.Graph;

import java.util.*;

/*860. 染色法判定二分图

给定一个 n 个点 m 条边的无向图，图中可能存在重边和自环。

请你判断这个图是否是二分图。

输入格式
第一行包含两个整数 n 和 m。

接下来 m 行，每行包含两个整数 u 和 v，表示点 u 和点 v 之间存在一条边。

输出格式
如果给定图是二分图，则输出 Yes，否则输出 No。

数据范围
1≤n,m≤105
输入样例：
4 4
1 3
1 4
2 3
2 4
输出样例：
Yes*/
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
            int a = sc.nextInt();
            int b = sc.nextInt();
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int[] colors = new int[n + 1];

        //@@ need traverse every node bc maybe some nodes are not connected.
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                if (!dfs(i, 1, map, colors)) {
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    //color : 1 || 2
    static boolean dfs(int node, int color, Map<Integer, List<Integer>> map, int[] colors) {
        if (colors[node] == 3 - color) {
            return false;
        }

        if (colors[node] == color) {
            return true;
        }
        colors[node] = color;

        for (int next : map.get(node)) {
            if (!dfs(next, 3 - color, map, colors)) {
                return false;
            }
        }
        return true;
    }
}
