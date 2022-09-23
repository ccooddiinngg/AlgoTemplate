package tag.Graph;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> t : tickets) {
            map.putIfAbsent(t.get(0), new PriorityQueue<>());
            map.get(t.get(0)).offer(t.get(1));
        }
        bt(map, "JFK");
        return path;
    }

    List<String> path = new ArrayList<>();

    void bt(Map<String, PriorityQueue<String>> map, String curr) {
        while (map.containsKey(curr) && !map.get(curr).isEmpty()) {
            String next = map.get(curr).poll();
            bt(map, next);
        }
        path.add(0, curr);
    }
}
