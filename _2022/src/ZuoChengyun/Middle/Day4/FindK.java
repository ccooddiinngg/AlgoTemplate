package ZuoChengyun.Middle.Day4;

import org.junit.jupiter.api.Test;

import java.util.*;

public class FindK {

    static class StringAndFrequency {
        String s;
        int frequency;

        public StringAndFrequency(String s, int frequency) {
            this.s = s;
            this.frequency = frequency;
        }
    }

    public static List<String> find(String[] s, int k) {
        if (k == 0) return null;
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : s) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        Queue<StringAndFrequency> q = new PriorityQueue<>((o1, o2) -> o1.frequency - o2.frequency);
        for (String key : map.keySet()) {
            StringAndFrequency stringAndFrequency = new StringAndFrequency(key, map.get(key));
            if (q.size() < k) {
                q.add(stringAndFrequency);
            } else if (q.size() == k && stringAndFrequency.frequency > q.peek().frequency) {
                q.poll();
                q.add(stringAndFrequency);
            }
        }
        while (!q.isEmpty()) {
            list.add(q.poll().s);
        }
        return list;
    }

    @Test
    void test() {
        String[] s = {"abc", "abc", "xyz", "mn", "mn", "bbb", "abc"};
        int k = 3;
        System.out.println(find(s, k));
    }
}
