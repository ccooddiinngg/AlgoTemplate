package Leetcode.ACW_LeetCode;

import java.util.*;

public class LC207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        int[] p = new int[numCourses];
        for (int[] pre : prerequisites) {
            p[pre[1]]++;
            map.get(pre[0]).add(pre[1]);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (p[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int next : map.get(curr)) {
                p[next]--;
                if (p[next] == 0) q.offer(next);
            }
        }
        return count == numCourses;
    }
}
