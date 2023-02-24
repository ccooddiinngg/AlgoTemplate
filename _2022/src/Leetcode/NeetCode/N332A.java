package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

import java.util.*;


//@@ when stuck, insert current node to the path beginning!
public class N332A {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        List<String> path = new ArrayList<>();
        dfs(map, "JFK", path);
        return path;
    }

    public void dfs(Map<String, Queue<String>> map, String curr, List<String> path) {
        while (map.containsKey(curr) && !map.get(curr).isEmpty()) {
            dfs(map, map.get(curr).poll(), path);
        }
        path.add(0, curr);
    }

    @Test
    void test() {
        String[][] tickets = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};

        List<List<String>> t = new ArrayList<>();
        for (String[] ticket : tickets) {
            t.add(Arrays.asList(ticket));
        }
        System.out.println(findItinerary(t));
    }
}
