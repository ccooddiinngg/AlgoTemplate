package Graph;

import java.util.*;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        int E = 40000;
        int[] e = new int[E], he = new int[m], ne = new int[E];
        int idx = 0;
        Arrays.fill(he, -1);

        int[] indegree = new int[m];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int from = graph[i][j], to = i;
                e[idx] = to;
                ne[idx] = he[from];
                he[from] = idx;
                idx++;
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = he[curr]; i != -1; i = ne[i]) {
                indegree[e[i]]--;
                if (indegree[e[i]] == 0) {
                    q.offer(e[i]);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) list.add(i);
        }
        return list;
    }
}
