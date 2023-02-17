### 399. Evaluate Division

> a <==2==> b <==3==> c

```java
class Solution {
    Map<String, Node> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values);

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            Set<String> visited = new HashSet<>();
            visited.add(a);
            ans[i] = dfs(a, b, 1.0, visited);
        }
        return ans;
    }

    double dfs(String curr, String end, double path, Set<String> visited) {
        if (!map.containsKey(curr)) {
            return -1;
        }
        if (curr.equals(end)) {
            return path;
        }
        for (Edge e : map.get(curr).edges) {
            if (!visited.contains(e.t)) {
                visited.add(e.t);
                double next = dfs(e.t, end, path * e.w, visited);
                visited.remove(e.t);
                if (next != -1) {
                    return next;
                }
            }
        }
        return -1;
    }

    void buildGraph(List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            Node na = getNode(a);
            Node nb = getNode(b);
            na.edges.add(new Edge(a, b, values[i]));
            nb.edges.add(new Edge(b, a, 1 / values[i]));
        }
    }

    class Edge {
        String f;
        String t;
        double w;

        public Edge(String f, String t, double w) {
            this.f = f;
            this.t = t;
            this.w = w;
        }
    }

    class Node {
        String name;
        List<Edge> edges;

        public Node(String name) {
            this.name = name;
            this.edges = new ArrayList<>();
        }
    }

    Node getNode(String name) {
        if (!map.containsKey(name)) {
            map.put(name, new Node(name));
        }
        return map.get(name);
    }
}
```

### 695. Max Area of Island

```java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        return 1 + dfs(grid, x + 1, y) + dfs(grid, x - 1, y) + dfs(grid, x, y + 1) + dfs(grid, x, y - 1);
    }
}
```

### 1020. Number of Enclaves

```java
class Solution {
    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, grid[0].length - 1);
        }
        for (int j = 0; j < grid[0].length; j++) {
            dfs(grid, 0, j);
            dfs(grid, grid.length - 1, j);
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
```
