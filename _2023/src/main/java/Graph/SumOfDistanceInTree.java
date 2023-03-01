package Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfDistanceInTree {

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }
        int[] count = new int[n];
        int[] dist = new int[n];
        int[] ans = new int[n];
        postOrder(0, -1, count, dist);
        preOrder(0, -1, count, dist, ans);
        return ans;
    }

    Map<Integer, List<Integer>> map = new HashMap<>();

    void postOrder(int curr, int father, int[] count, int[] dist) {
        count[curr] = 1;
        for (int nei : map.get(curr)) {
            if (nei != father) {
                postOrder(nei, curr, count, dist);
                count[curr] += count[nei];
                dist[curr] += dist[nei] + count[nei];
            }
        }
    }

    void preOrder(int curr, int father, int[] count, int[] dist, int[] ans) {
        ans[curr] = dist[curr];
        for (int nei : map.get(curr)) {
            if (nei != father) {
                int cc = count[curr], dc = dist[curr], cn = count[nei], dn = dist[nei];
                //move root from curr to nei
                count[curr] -= count[nei];
                dist[curr] -= dist[nei] + count[nei];
                dist[nei] += dist[curr] + count[curr];
                count[nei] += count[curr];
                preOrder(nei, curr, count, dist, ans);
                count[curr] = cc;
                dist[curr] = dc;
                count[nei] = cn;
                dist[nei] = dn;
            }
        }
    }


    @Test
    void test() {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        Assertions.assertArrayEquals(new int[]{8, 12, 6, 10, 10, 10}, sumOfDistancesInTree(n, edges));
    }

}
