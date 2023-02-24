package Leetcode.NeetCode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class N332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();

        tickets.sort((a, b) -> {
            if (a.get(0).equals(b.get(0))) {
                return a.get(1).compareTo(b.get(1));
            }
            return a.get(0).compareTo(b.get(0));
        });

        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new ArrayList<>());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        List<String> path = new ArrayList<>();
        path.add("JFK");
        helper(map, "JFK", path, tickets.size() + 1);
        return path;
    }

    public boolean helper(Map<String, List<String>> map, String curr, List<String> path, int N) {
        if (path.size() == N) {
            return true;
        }

        List<String> adj = map.get(curr);
        if (adj == null) {
            return false;
        }

        for (int i = 0; i < adj.size(); i++) {
            String to = adj.get(i);
            path.add(to);
            adj.remove(i);
            if (helper(map, to, path, N)) {
                return true;
            }
            adj.add(i, to);
            path.remove(to);
        }
        return false;
    }

    @Test
    void test() {
        String[][] tickets = {{"EZE", "TIA"}, {"EZE", "HBA"}, {"AXA", "TIA"}, {"JFK", "AXA"}, {"ANU", "JFK"}, {"ADL", "ANU"}, {"TIA", "AUA"}, {"ANU", "AUA"}, {"ADL", "EZE"}, {"ADL", "EZE"}, {"EZE", "ADL"}, {"AXA", "EZE"}, {"AUA", "AXA"}, {"JFK", "AXA"}, {"AXA", "AUA"}, {"AUA", "ADL"}, {"ANU", "EZE"}, {"TIA", "ADL"}, {"EZE", "ANU"}, {"AUA", "ANU"}};

        List<List<String>> t = new ArrayList<>();
        for (String[] ticket : tickets) {
            t.add(Arrays.asList(ticket));
        }
        System.out.println(findItinerary(t));
    }
}
