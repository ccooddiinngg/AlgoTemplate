package ZuoChengyun.Middle.Day9;

import ZuoChengyun.Basic.Node;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MaxIncome {
    public static int[] main(int N, int time, int[] times, int[] incomes, Map<Integer, List<Integer>> pre, Map<Integer, List<Integer>> next) {
        Map<Integer, TreeMap<Integer, Integer>> treeMaps = new HashMap<>();
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (!next.containsKey(i)) {
                end = i;
                break;
            }
        }
        build(times, incomes, pre, end, 0, 0, treeMaps);
        System.out.println(treeMaps);

        TreeMap<Integer, Integer> totalTreeMap = new TreeMap<>();
        for (Integer key : treeMaps.keySet()) {
            TreeMap<Integer, Integer> treeMap = treeMaps.get(key);
            for (Integer k : treeMap.keySet()) {
                totalTreeMap.put(k, Math.max(totalTreeMap.getOrDefault(k, 0), treeMap.get(k)));
            }
        }

        System.out.println(totalTreeMap);

        TreeMap<Integer, Integer> ans = new TreeMap<>();

        for (Integer i : totalTreeMap.keySet()) {
            if (ans.isEmpty() || totalTreeMap.get(i) > ans.get(ans.lastKey())) {
                ans.put(i, totalTreeMap.get(i));
            }
        }

        System.out.println(ans);
        Integer resultKey = ans.floorKey(time);
        if (resultKey == null) return new int[]{-1, -1};
        return new int[]{resultKey, ans.get(resultKey)};
    }

    public static void build(int[] times, int[] incomes, Map<Integer, List<Integer>> pre, int index, int sumIncome, int sumTime, Map<Integer, TreeMap<Integer, Integer>> treeMaps) {
        int currIncome = sumIncome + incomes[index];
        int currTime = sumTime + times[index];
        if (treeMaps.containsKey(index)) {
            TreeMap<Integer, Integer> treeMap = treeMaps.get(index);
            treeMap.keySet().removeIf(key -> key > currTime && treeMap.get(key) < currIncome);
            treeMap.put(currTime, Math.max(treeMap.getOrDefault(currTime, 0), currIncome));
        } else {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            treeMap.put(currTime, currIncome);
            treeMaps.put(index, treeMap);
        }
        List<Integer> preNodes = pre.get(index);
        if (preNodes != null) {
            for (Integer node : preNodes) {
                build(times, incomes, pre, node, sumIncome + incomes[index], sumTime + times[index], treeMaps);
            }
        }
    }

    @Test
    void test() {
        int N = 8;
        int time = 10;
        int[] times = {3, 3, 2, 1, 4, 2, 4, 3};
        int[] incomes = {2000, 4000, 2500, 1600, 3800, 2600, 4000, 3500};
        String[] edges = {"01100000", "00011000", "00010000", "00001110",
                "00000001", "00000001", "00000001", "00000000"};

        Map<Integer, List<Integer>> pre = new HashMap<>();
        Map<Integer, List<Integer>> next = new HashMap<>();
        creatMap(edges, pre, next);
        System.out.println(pre);
        System.out.println(next);

        int[] res = main(N, time, times, incomes, pre, next);
        System.out.println(Arrays.toString(res));
    }

    public void creatMap(String[] edges, Map<Integer, List<Integer>> pre, Map<Integer, List<Integer>> next) {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length(); j++) {
                if (edges[i].charAt(j) == '1') {
                    if (pre.containsKey(j)) {
                        pre.get(j).add(i);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        pre.put(j, list);
                    }
                    if (next.containsKey(i)) {
                        next.get(i).add(j);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        next.put(i, list);
                    }
                }
            }
        }
    }
}
