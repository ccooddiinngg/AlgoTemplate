package Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !dfs(graph, i, 1, colors)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] g, int curr, int color, int[] colors) {
        if (colors[curr] == color) return true;
        if (colors[curr] == 3 - color) return false;
        colors[curr] = color;
        for (int i = 0; i < g[curr].length; i++) {
            if (!dfs(g, g[curr][i], 3 - color, colors)) {
                return false;
            }
        }
        return true;
    }

    @Test
    void test() {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        Assertions.assertTrue(isBipartite(graph));
    }
}
