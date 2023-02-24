package AC2_Course.Graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
849. Dijkstra求最短路 I

给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环，所有边权均为正值。

请你求出 1 号点到 n 号点的最短距离，如果无法从 1 号点走到 n 号点，则输出 −1。

输入格式
第一行包含整数 n 和 m。

接下来 m 行每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。

输出格式
输出一个整数，表示 1 号点到 n 号点的最短距离。

如果路径不存在，则输出 −1。

数据范围
1≤n≤500,
1≤m≤105,
图中涉及边长均不超过10000。

输入样例：
3 3
1 2 2
2 3 1
1 3 4
输出样例：
3
*/
public class A849 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n + 1][n + 1];
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int w = sc.nextInt();
            map[from][to] = Math.min(map[from][to], w);
        }

        int[] dis = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        int s = 1;
        dis[s] = 0;

        int count = 0;
        while (count < n) {
            //find the shortest neighbor
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!set.contains(j) && (t == -1 || dis[j] < dis[t])) {
                    t = j;
                }
            }
            set.add(t);

            //use shortest neighbor update all distance
            for (int i = 1; i <= n; i++) {
                if (map[t][i] != Integer.MAX_VALUE) {
                    dis[i] = Math.min(dis[i], dis[t] + map[t][i]);
                }
            }

            count++;
        }

        System.out.println(dis[n] == Integer.MAX_VALUE ? -1 : dis[n]);
    }

}


