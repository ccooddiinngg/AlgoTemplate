package Leetcode.Coding_Interview_6.C08;

public class S10 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (x < 0 || y < 0 || x == image.length || y == image[0].length || image[x][y] != oldColor || image[x][y] == newColor)
            return;
        image[x][y] = newColor;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int dir = 0; dir < 4; dir++) {
            dfs(image, x + dx[dir], y + dy[dir], oldColor, newColor);
        }
    }
}
