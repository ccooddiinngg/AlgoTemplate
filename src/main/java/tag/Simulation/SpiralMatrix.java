package tag.Simulation;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        bt(matrix, 0, 0, 0, list, visited);
        return list;
    }

    //右 下 左 上
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    void bt(int[][] matrix, int x, int y, int d, List<Integer> list, boolean[][] visited) {
        list.add(matrix[x][y]);
        visited[x][y] = true;
        int x1 = x + dir[d][0];
        int y1 = y + dir[d][1];
        if (x1 < 0 || x1 == matrix.length || y1 < 0 || y1 == matrix[0].length || visited[x1][y1]) {
            d++;
            d %= 4;
        }
        //一个方向不行就再试下一个
        x1 = x + dir[d][0];
        y1 = y + dir[d][1];
        //两个方向都不行就结束
        if (x1 < 0 || x1 == matrix.length || y1 < 0 || y1 == matrix[0].length || visited[x1][y1]) {
            return;
        }
        bt(matrix, x1, y1, d, list, visited);
    }
}
