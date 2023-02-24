package Leetcode.ACW_LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Node> q = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        for (int key : map.keySet()) {
            if (q.size() < k) {
                q.add(new Node(key, map.get(key)));
            } else {
                if (q.peek().freq < map.get(key)) {
                    q.poll();
                    q.add(new Node(key, map.get(key)));
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll().num;
        }
        return res;
    }

    class Node {
        int num;
        int freq;

        public Node(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
}
