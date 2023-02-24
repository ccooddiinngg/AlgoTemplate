package Leetcode.Coding_Interview_6.C17;

import java.util.HashMap;
import java.util.Map;

public class S18 {
    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> map = new HashMap<>();
        int diff = 0;
        for (int num : small) {
            map.put(num, 0);
            diff++;
        }
        int n = big.length;
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        int i = 0;
        int j = 0;

        while (j < n) {
            if (map.containsKey(big[j])) {
                map.put(big[j], map.get(big[j]) + 1);
                if (map.get(big[j]) == 1) {
                    diff--;
                }
                if (diff == 0) {
                    while (i <= j) {
                        if (map.containsKey(big[i])) {
                            map.put(big[i], map.get(big[i]) - 1);
                            if (map.get(big[i]) < 1) {
                                diff++;
                                if (j - i + 1 < min) {
                                    min = j - i + 1;
                                    res[0] = i;
                                    res[1] = j;
                                }
                                i++;
                                break;
                            }
                        }
                        i++;
                    }
                }
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? new int[0] : res;
    }
}
