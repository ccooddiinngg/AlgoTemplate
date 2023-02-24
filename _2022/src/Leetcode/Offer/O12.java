package Leetcode.Offer;

public class O12 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, 0, word, visited)) return true;
            }
        }
        return false;
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    boolean dfs(char[][] b, int x, int y, int idx, String word, boolean[][] visited) {
        if (b[x][y] != word.charAt(idx)) return false;
        if (idx == word.length() - 1) return true;
        visited[x][y] = true;
        for (int[] d : dir) {
            int x1 = x + d[0];
            int y1 = y + d[1];
            if (x1 >= 0 && x1 < b.length && y1 >= 0 && y1 < b[0].length && !visited[x1][y1]) {
                if (dfs(b, x1, y1, idx + 1, word, visited)) return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
