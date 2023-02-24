package Leetcode.MostLiked100;

import java.util.*;

public class TopKFrequentElements {
    static class MaxHeap {
        static class Node {
            int key;
            int val;

            public Node(int k, int v) {
                key = k;
                val = v;
            }
        }

        List<Node> heap = new ArrayList<>();
        //key:index
        Map<Integer, Integer> map = new HashMap<>();

        public void swap(List<Node> heap, int i, int j) {
            Node node = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, node);
            map.put(heap.get(i).key, i);
            map.put(heap.get(j).key, j);
        }

        public void insert(int key) {
            if (map.containsKey(key)) {
                increase(key);
                return;
            }
            Node node = new Node(key, 1);
            heap.add(node);
            map.put(key, heap.size() - 1);
            heapInsert(heap.size() - 1);
        }

        public Node poll() {
            Node node = heap.get(0);
            swap(heap, 0, heap.size() - 1);
            map.remove(node.key);
            heap.remove(heap.size() - 1);
            heapify(0);
            return node;
        }

        public void increase(int key) {
            int index = map.get(key);
            Node node = heap.get(index);
            node.val = node.val + 1;
            heapInsert(index);
            heapify(index);
        }

        public void heapInsert(int index) {
            while ((index - 1) / 2 >= 0 && heap.get((index - 1) / 2).val < heap.get(index).val) {
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public void heapify(int index) {
            while (index * 2 + 1 < heap.size()) {
                int max = index * 2 + 1;
                if (index * 2 + 2 < heap.size() && heap.get(index * 2 + 2).val > heap.get(max).val) {
                    max = index * 2 + 2;
                }
                if (heap.get(index).val > heap.get(max).val) {
                    max = index;
                }
                if (max == index) {
                    break;
                } else {
                    swap(heap, index, max);
                    index = max;
                }
            }
        }

    }

    //good
    public static int[] topKFrequent(int[] nums, int k) {
        MaxHeap maxHeap = new MaxHeap();
        for (int i = 0; i < nums.length; i++) {
            maxHeap.insert(nums[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().key;
        }
        return res;
    }

    public static int[] topKFrequentPriorityQueue(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (int key : map.keySet()) {
            queue.add(key);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll();
        }
        return res;
    }

    //worst
    public static int[] topKFrequentMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int[] res = new int[k];
        int index = 0;
        while (index < k) {
            int max = 0;
            int maxKey = 0;
            for (int key : map.keySet()) {
                if (map.get(key) > max) {
                    max = map.get(key);
                    maxKey = key;
                }
            }
            res[index++] = maxKey;
            map.remove(maxKey);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

        System.out.println(Arrays.toString(topKFrequentMap(nums, k)));

        System.out.println(Arrays.toString(topKFrequentPriorityQueue(nums, k)));

    }
}

