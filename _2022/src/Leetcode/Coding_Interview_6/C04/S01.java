package Leetcode.Coding_Interview_6.C04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S01 {
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
        return bfs(start, target);
    }


    boolean bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int curr = q.poll();
            visited[curr] = true;
            for (int idx = h[curr]; idx != -1; idx = ne[idx]) {
                int next = e[idx];
                if (next == target) {
                    found = true;
                    break;
                }
                if (!visited[next]) {
                    q.add(next);
                }
            }
        }
        return found;
    }
}
