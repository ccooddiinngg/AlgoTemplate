package Leetcode.ACW_LeetCode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC554 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int pre = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                pre += row.get(i);
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
        }
        int max = 0;
        for (int key : map.keySet()) {
            // System.out.println(map.get(key));
            max = Math.max(max, map.get(key));
        }
        return wall.size() - max;
    }

}
