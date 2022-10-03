package tag.UnionFind;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Node[][] matrix = new Node[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Node(i, j);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    if (board[i - 1][j] == 'O') union(matrix[i][j], matrix[i - 1][j]);
                    if (board[i + 1][j] == 'O') union(matrix[i][j], matrix[i + 1][j]);
                    if (board[i][j - 1] == 'O') union(matrix[i][j], matrix[i][j - 1]);
                    if (board[i][j + 1] == 'O') union(matrix[i][j], matrix[i][j + 1]);
                }
            }
        }
        //union all boundary nodes
        Node boundary = new Node(-1, -1);
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') union(matrix[i][0], boundary);
            if (board[i][n - 1] == 'O') union(matrix[i][n - 1], boundary);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') union(matrix[0][j], boundary);
            if (board[m - 1][j] == 'O') union(matrix[m - 1][j], boundary);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !isSameSet(matrix[i][j], boundary)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    class Node {
        int x;
        int y;
        Node p;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.p = this;
        }
    }

    Node find(Node node) {
        if (node.p != node) {
            node.p = find(node.p);
        }
        return node.p;
    }

    void union(Node n1, Node n2) {
        Node p1 = find(n1);
        Node p2 = find(n2);
        if (p1 != p2) {
            p1.p = p2;
        }
    }

    boolean isSameSet(Node n1, Node n2) {
        return find(n1) == find(n2);
    }
    
}
