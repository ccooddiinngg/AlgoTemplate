package Leetcode.NeetCode;

import java.util.HashMap;
import java.util.Map;

//@@ put the max frequency char first, followed by second and so on...
public class N621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int max = 0;
        int count = 0;
        int sum = 0;
        for (char key : map.keySet()) {
            sum += map.get(key);

            if (map.get(key) > max) {
                max = map.get(key);
                count = 1;
                continue;
            }
            if (map.get(key) == max) {
                count++;
            }
        }
        int min = (max - 1) * (n + 1) + count;
        return Math.max(sum, min);
    }
}
