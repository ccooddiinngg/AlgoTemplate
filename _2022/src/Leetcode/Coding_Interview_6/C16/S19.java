package Leetcode.Coding_Interview_6.C16;

import java.util.ArrayList;
import java.util.List;

public class S19 {
    int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    int[] dy = {0, 0, 1, -1, 1, -1, -1, 1};
    int count = 0;
    List<Integer> list = new ArrayList<>();

    public int[] pondSizes(int[][] land) {
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 0) {
                    count = 0;
                    dfs(land, i, j);
                    list.add(count);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    void dfs(int[][] land, int x, int y) {
        land[x][y] = 3;
        count++;
        for (int i = 0; i < 8; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if (x1 >= 0 && x1 < land.length && y1 >= 0 && y1 < land[0].length && land[x1][y1] == 0) {
                dfs(land, x1, y1);
            }
        }
    }
}
