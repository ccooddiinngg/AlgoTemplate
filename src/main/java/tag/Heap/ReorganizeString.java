package tag.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//每次从堆中取2个
public class ReorganizeString {
    public String reorganizeString(String s) {
        int m = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<P> q = new PriorityQueue<>((a, b) -> b.n - a.n);
        for (char key : map.keySet()) {
            q.offer(new P(key, map.get(key)));
        }
        StringBuilder sb = new StringBuilder();
        while (q.size() > 1) {
            P p1 = q.poll();
            P p2 = q.poll();
            sb.append(p1.c).append(p2.c);
            p1.n--;
            if (p1.n > 0) q.offer(p1);
            p2.n--;
            if (p2.n > 0) q.offer(p2);
        }
        if (!q.isEmpty()) {
            sb.append(q.poll().c);
        }
        if (sb.length() < m) return "";
        return sb.toString();
    }

    class P {
        char c;
        int n;

        public P(char c, int n) {
            this.c = c;
            this.n = n;
        }
    }
}
