package tag.DepthFirstSearch;

import java.util.*;

public class CourseScheduleII {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
        }
        Stack<Integer> path = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, visited, visiting, path)) {
                return new int[1];
            }
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while (!path.isEmpty()) {
            res[idx++] = path.pop();
        }
        return res;
    }

    private boolean dfs(int curr, boolean[] visited, boolean[] visiting, Stack<Integer> path) {
        if (visiting[curr]) return true;
        if (visited[curr]) return false;
        visiting[curr] = true;
        if (map.containsKey(curr)) {
            for (int nei : map.get(curr)) {
                if (dfs(nei, visited, visiting, path)) {
                    return true;
                }
            }
        }
        visiting[curr] = false;
        visited[curr] = true;
        path.push(curr);
        return false;
    }
}

