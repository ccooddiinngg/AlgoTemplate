package Leetcode.Coding_Interview_6.C04;

import java.util.Arrays;

public class S01c {
    int N = 100010;
    int[] h = new int[N];
    int[] e = new int[N];
    int[] ne = new int[N];
    boolean[] visited = new boolean[N];
    int idx = 0;

    void add(int from, int to) {
        e[idx] = to;
        ne[idx] = h[from];
        h[from] = idx++;
    }

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Arrays.fill(h, -1);
        for (int[] e : graph) {
            add(e[0], e[1]);
        }
        return dfs(start, target);
    }


    boolean dfs(int start, int target) {
        if (start == target) return true;
        visited[start] = true;
        for (int idx = h[start]; idx != -1; idx = ne[idx]) {
            int next = e[idx];
            if (!visited[next]) {
                if (dfs(next, target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
