package tag.DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[0])) {
                map.put(pre[0], new ArrayList<>());
            }
            map.get(pre[0]).add(pre[1]);
        }
        int[] cache = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            if (dfs(i, visited, cache)) {
                return false;
            }
        }
        return true;
    }


    //if path circles
    private boolean dfs(int curr, boolean[] visited, int[] cache) {
        if (cache[curr] != 0) return cache[curr] == 1;
        if (visited[curr]) return true;
        if (!map.containsKey(curr)) {
            cache[curr] = 2;
            return false;
        }
        visited[curr] = true;
        for (int nei : map.get(curr)) {
            if (dfs(nei, visited, cache)) {
                cache[curr] = 1;
                return true;
            }
        }
        visited[curr] = false;
        cache[curr] = 2;
        return false;
    }
}
