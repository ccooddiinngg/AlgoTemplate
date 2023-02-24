### 128. Longest Consecutive Sequence

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        init(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i], i);
            if (map.containsKey(nums[i] - 1)) {
                union(map.get(nums[i] - 1), i);
            }
            if (map.containsKey(nums[i] + 1)) {
                union(map.get(nums[i] + 1), i);
            }
        }
        int max = 0;
        for (int v : s) {
            max = Math.max(max, v);
        }
        return max;
    }

    int[] p;
    int[] s;

    void init(int cap) {
        p = new int[cap];
        for (int i = 0; i < cap; i++) {
            p[i] = i;
        }
        s = new int[cap];
        for (int i = 0; i < cap; i++) {
            s[i] = 1;
        }
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp != yp) {
            p[xp] = yp;
            s[yp] += s[xp];
        }
    }
}
```

### 130. Surrounded Regions

```java
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        init(m * n);
        for (int i = 0; i < m; i++) {
            union(i * n, 0);
            union(i * n + n - 1, 0);
        }
        for (int j = 0; j < n; j++) {
            union(j, 0);
            union((m - 1) * n + j, 0);
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    if (board[i - 1][j] == 'O') {
                        union(i * n + j, (i - 1) * n + j);
                    }
                    if (board[i + 1][j] == 'O') {
                        union(i * n + j, (i + 1) * n + j);
                    }
                    if (board[i][j + 1] == 'O') {
                        union(i * n + j, i * n + j + 1);
                    }
                    if (board[i][j - 1] == 'O') {
                        union(i * n + j, i * n + j - 1);
                    }
                }
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && !isSameSet(i * n + j, 0)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int[] p;

    void init(int cap) {
        p = new int[cap];
        for (int i = 0; i < cap; i++) {
            p[i] = i;
        }
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
        }
    }

    boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }
}
```

### 200. Number of Islands

```java
class Solution {
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        init(m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        union(g(i, j), g(i - 1, j));
                    }
                    if (i + 1 < m && grid[i + 1][j] == '1') {
                        union(g(i, j), g(i + 1, j));
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                        union(g(i, j), g(i, j - 1));
                    }
                    if (j + 1 < n && grid[i][j + 1] == '1') {
                        union(g(i, j), g(i, j + 1));
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    set.add(find(g(i, j)));
                }
            }
        }
        return set.size();
    }

    int m;
    int n;

    int g(int i, int j) {
        return i * n + j;
    }

    int[] p;

    void init(int m, int n) {
        p = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            p[i] = i;
        }
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
        }
    }

    boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }
}
```

### 399. Evaluate Division

![](/Users/hanjunkang/Documents/AlgoTemplate/_2023/src/main/resources/1609863006-GhibcH-image.png)

```java
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            union(getIfAbsent(a), getIfAbsent(b), values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            ans[i] = ask(a, b);
        }
        return ans;
    }

    class Node {
        String id;
        Node p;
        double w;

        public Node(String id) {
            this.id = id;
            this.p = this;
            this.w = 1.0;
        }
    }

    Map<String, Node> map = new HashMap<>();

    Node getIfAbsent(String id) {
        if (!map.containsKey(id)) {
            map.put(id, new Node(id));
        }
        return map.get(id);
    }

    Node getNode(String id) {
        return map.get(id);
    }

    Node find(Node node) {
        if (node.p != node) {
            //需要根据父节点来更改w， 但是递归以后父节点已经变成跟节点， 所以需要记录父节点
            Node p = node.p;
            node.p = find(node.p);
            node.w *= p.w;
        }
        return node.p;
    }

    //n1 / n2 = w
    void union(Node n1, Node n2, double w) {
        Node n1p = find(n1);
        Node n2p = find(n2);
        if (n1p != n2p) {
            n1p.p = n2p;
            n1p.w = n2.w * w / n1.w;
        }
    }

    boolean isSameSet(Node n1, Node n2) {
        Node n1p = find(n1);
        Node n2p = find(n2);
        return n1p == n2p;
    }

    double ask(String s1, String s2) {
        Node n1 = getNode(s1);
        Node n2 = getNode(s2);
        if (n1 != null && n2 != null && isSameSet(n1, n2)) {
            return n1.w / n2.w;
        }
        return -1.0;
    }
}
```

### 547. Number of Provinces

```java
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        p = new int[m];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] == i) count++;
        }
        return count;
    }

    int[] p;

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
        }
    }
}
```

### 684. Redundant Connection

```java
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        p = new int[1001];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        int idx = -1;
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            if (isSameSet(e[0], e[1])) {
                idx = i;
            }
            union(e[0], e[1]);
        }
        if (idx == -1) throw new NullPointerException();
        return edges[idx];
    }

    int[] p;

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
        }
    }

    boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

}
```

### 685. Redundant Connection II

> 1，有环无冲突
> 2，有环有冲突
> 3，无环有冲突

```java
class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int m = edges.length;
        p = new int[m + 1];
        for (int i = 0; i < m + 1; i++) {
            p[i] = i;
        }
        int[] pre = new int[m + 1];
        for (int i = 0; i < m + 1; i++) {
            pre[i] = i;
        }
        int conflict = -1;
        int circle = -1;

        for (int i = 0; i < m; i++) {
            int[] e = edges[i];
            if (p[e[1]] != e[1]) {
                conflict = i;
            } else {
                pre[e[1]] = e[0];
                if (isSameSet(e[1], e[0])) {
                    circle = i;
                } else {
                    union(e[1], e[0]);
                }
            }
        }

        if (conflict == -1) {
            return edges[circle];
        } else {
            if (circle == -1) {
                return edges[conflict];
            } else {
                return new int[]{pre[edges[conflict][1]], edges[conflict][1]};
            }
        }
    }

    int[] p;

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
        }
    }

    boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }
}
```

### 765. Couples Holding Hands

> 首先，我们总是以「情侣对」为单位进行设想：
> 当有两对情侣相互坐错了位置，ta们两对之间形成了一个环。需要进行一次交换，使得每队情侣独立（相互牵手）
> 如果三对情侣相互坐错了位置，ta们三对之间形成了一个环，需要进行两次交换，使得每队情侣独立（相互牵手）
> 如果四对情侣相互坐错了位置，ta们四对之间形成了一个环，需要进行三次交换，使得每队情侣独立（相互牵手）
> 也就是说，如果我们有 k 对情侣形成了错误环，需要交换 k - 1 次才能让情侣牵手。
> 于是问题转化成 n / 2 对情侣中，有多少个这样的环。
> 可以直接使用「并查集」来做。
> 由于 0和1配对、2和3配对 ... 因此互为情侣的两个编号除以 2 对应同一个数字，可直接作为它们的「情侣组」编号

```java
class Solution {
    public int minSwapsCouples(int[] row) {
        int m = row.length;
        p = new int[m / 2];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int i = 0; i < row.length; i += 2) {
            //pair [x, y]: x/2 == y/2
            union(row[i] / 2, row[i + 1] / 2);
        }
        int pair = m / 2;
        int circle = 0;
        for (int i = 0; i < p.length; i++) {
            if (i == find(i)) circle++;
        }

        return pair - circle;
    }

    int[] p;

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
        }
    }
}
```