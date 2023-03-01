### 133. Clone Graph

```java
class Solution {
    Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for (Node nei : node.neighbors) {
            copy.neighbors.add(cloneGraph(nei));
        }
        return copy;
    }
}
```

### 207. Course Schedule

```java
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (map.containsKey(curr)) {
                for (int nei : map.get(curr)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] > 0) return false;
        }
        return true;
    }
}
```

```java
class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[0])) {
                map.put(pre[0], new ArrayList<>());
            }
            map.get(pre[0]).add(pre[1]);
        }

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, new boolean[numCourses], visited)) {
                return false;
            }
        }
        return true;
    }


    //if path has circle
    public boolean dfs(int curr, boolean[] visiting, boolean[] visited) {
        if (visiting[curr]) return true;
        if (visited[curr]) return false;
        if (!map.containsKey(curr)) return false;
        visiting[curr] = true;
        for (int nei : map.get(curr)) {
            if (dfs(nei, visiting, visited)) {
                return true;
            }
        }
        visiting[curr] = false;
        visited[curr] = true;
        return false;
    }
}
```

### 210. Course Schedule II

```java
class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            if (!map.containsKey(pre[1])) {
                map.put(pre[1], new ArrayList<>());
            }
            map.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            list.add(curr);
            if (map.containsKey(curr)) {
                for (int nei : map.get(curr)) {
                    indegree[nei]--;
                    if (indegree[nei] == 0) {
                        q.offer(nei);
                    }
                }
            }
        }
        if (list.size() < numCourses) {
            return new int[0];
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
```

### 310. Minimum Height Trees

> 从外到内一层一层剥开， 最中间的一层就是答案

```java
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        int[] out = new int[n];
        for (int[] e : edges) {
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
            out[e[0]]++;
            out[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] trimed = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (out[i] <= 1) {
                q.offer(i);
                trimed[i] = true;
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                list.add(curr);
                for (int nei : map.get(curr)) {
                    out[nei]--;
                    if (out[nei] <= 1 && !trimed[nei]) {
                        q.offer(nei);
                        trimed[nei] = true;
                    }
                }
            }
        }
        return list;
    }


}
```

### 329. Longest Increasing Path in a Matrix

```java
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        cache = new int[matrix.length][matrix[0].length];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] cache;

    public int dfs(int[][] matrix, int x, int y) {
        if (cache[x][y] != -1) return cache[x][y];
        int next = 0;
        for (int i = 0; i < dir.length; i++) {
            int x1 = x + dir[i][0];
            int y1 = y + dir[i][1];
            if (x1 >= 0 && x1 < matrix.length && y1 >= 0 && y1 < matrix[0].length && matrix[x1][y1] > matrix[x][y]) {
                next = Math.max(next, dfs(matrix, x1, y1));
            }
        }
        cache[x][y] = next + 1;
        return cache[x][y];
    }
}
```

### 332. Reconstruct Itinerary

```java
class Solution {
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> t : tickets) {
            if (!map.containsKey(t.get(0))) {
                map.put(t.get(0), new PriorityQueue<>());
            }
            map.get(t.get(0)).offer(t.get(1));
        }

        Stack<String> path = new Stack<>();
        dfs("JFK", path);
        List<String> res = new ArrayList<>();
        while (!path.isEmpty()) {
            res.add(path.pop());
        }
        return res;
    }

    public void dfs(String curr, Stack<String> path) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String next = map.get(curr).poll();
            dfs(next, path);
        }
        path.push(curr);
    }
}
```

### 753. Cracking the Safe

```java
class Solution {
    public String crackSafe(int n, int k) {
        int bit = (int) Math.pow(10, n - 1);
        dfs(0, bit, k);
        for (int i = 1; i < n; i++) {
            path.append("0");
        }
        return path.toString();
    }

    Set<Integer> set = new HashSet<>();
    StringBuilder path = new StringBuilder();

    public void dfs(int curr, int bit, int k) {
        for (int i = 0; i < k; i++) {
            int next = curr * 10 + i;
            if (!set.contains(next)) {
                set.add(next);
                dfs(next % bit, bit, k);
                path.append(i);
            }
        }
    }
}
```

### 743. Network Delay Time

```java
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = 0x3f3f3f3f;
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int[] t : times) {
            if (!map.containsKey(t[0])) {
                map.put(t[0], new ArrayList<>());
            }
            map.get(t[0]).add(new Edge(t[0], t[1], t[2]));
        }
        int[] dis = dij(n, k, map);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dis[i]);
        }
        return max < INF ? max : -1;
    }


    public int[] dij(int n, int k, Map<Integer, List<Edge>> map) {
        int INF = 0x3f3f3f3f;
        Queue<Edge> q = new PriorityQueue<>((a, b) -> a.w - b.w);
        int[] dis = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dis, INF);
        //!
        dis[k] = 0;
        q.offer(new Edge(k, k, 0));
        while (!q.isEmpty()) {
            Edge curr = q.poll();
            visited[curr.t] = true;
            if (map.containsKey(curr.t)) {
                for (Edge next : map.get(curr.t)) {
                    if (dis[next.t] > dis[curr.t] + next.w) {
                        dis[next.t] = dis[curr.t] + next.w;
                        q.offer(new Edge(k, next.t, dis[next.t]));
                    }
                }
            }
        }
        return dis;
    }

    class Edge {
        int f;
        int t;
        int w;

        public Edge(int f, int t, int w) {
            this.f = f;
            this.t = t;
            this.w = w;
        }
    }
}
```

### 785. Is Graph Bipartite?

> 染色法

```java
class Solution {
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
}
```

### 787. Cheapest Flights Within K Stops

> Bellman-Ford

```java
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3f3f3f3f;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int k1 = 0; k1 < k + 1; k1++) {
            int[] pre = Arrays.copyOf(dist, dist.length);
            for (int[] f : flights) {
                dist[f[1]] = Math.min(dist[f[1]], pre[f[0]] + f[2]);
            }
        }
        return dist[dst] < INF ? dist[dst] : -1;
    }
}
```

### 797. All Paths From Source to Target

```java
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(), list);
        return list;
    }

    public void dfs(int[][] g, int curr, List<Integer> path, List<List<Integer>> list) {
        path.add(curr);
        if (curr == g.length - 1) {
            list.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < g[curr].length; i++) {
                dfs(g, g[curr][i], path, list);
            }
        }
        path.remove(path.size() - 1);
    }
}
```

### 802. Find Eventual Safe States

> 反向建图，拓扑排序

```java
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        int E = 40000;
        int[] e = new int[E], he = new int[m], ne = new int[E];
        int idx = 0;
        Arrays.fill(he, -1);

        int[] indegree = new int[m];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                int from = graph[i][j], to = i;
                e[idx] = to;
                ne[idx] = he[from];
                he[from] = idx;
                idx++;
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = he[curr]; i != -1; i = ne[i]) {
                indegree[e[i]]--;
                if (indegree[e[i]] == 0) {
                    q.offer(e[i]);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) list.add(i);
        }
        return list;
    }
}
```

### 834. Sum of Distances in Tree

> postOrder then preOrder

```java
class Solution {
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

    //计算出以0为根的数，每个节点的dist, dist[i](i节点所有子节点到i的距离和)以及每个节点的count, count[i](i的所有子节点加上i节点的个数)
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

    //从0节点开始，尝试变换子节点为根节点，，
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

}
```

### 841. Keys and Rooms

```java
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    void dfs(List<List<Integer>> rooms, int curr, boolean[] visited) {
        visited[curr] = true;
        for (int nei : rooms.get(curr)) {
            if (!visited[nei]) {
                dfs(rooms, nei, visited);
            }
        }
    }
}
```

### 847. Shortest Path Visiting All Nodes

```java
class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        boolean[][] set = new boolean[n][1 << n];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new Node(i, 1 << i, 0, i + ""));
            set[i][1 << i] = true;
        }
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.visited == (1 << n) - 1) {
                // System.out.println(curr.path);
                return curr.dist;
            }
            for (int i = 0; i < graph[curr.id].length; i++) {
                int id = graph[curr.id][i];
                int visited = curr.visited | 1 << id;
                int dist = curr.dist + 1;
                String path = curr.path + id;
                if (!set[id][visited]) {
                    set[id][visited] = true;
                    q.offer(new Node(id, visited, dist, path));
                }
            }
        }
        return -1;
    }

    class Node {
        int id;
        int visited;
        int dist;
        //如果需要的话
        String path;

        public Node(int id, int visited, int dist, String path) {
            this.id = id;
            this.visited = visited;
            this.dist = dist;
            this.path = path;
        }
    }
}
```

### 851. Loud and Rich

```java
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = quiet.length;
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < richer.length; i++) {
            map.get(richer[i][1]).add(richer[i][0]);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            dfs(map, i, quiet, ans);
        }
        return ans;
    }

    void dfs(Map<Integer, List<Integer>> map, int curr, int[] quiet, int[] ans) {
        if (ans[curr] != -1) return;
        int min = quiet[curr];
        int p = curr;
        for (int nei : map.get(curr)) {
            dfs(map, nei, quiet, ans);
            if (quiet[ans[nei]] < min) {
                min = quiet[ans[nei]];
                p = ans[nei];
            }
            ;
        }
        ans[curr] = p;
    }
}
```

### 882. Reachable Nodes In Subdivided Graph

> Dijkstra 求出发点到各点的距离，如果距离在Max之内，就count++；
> 判断每条边的顶点是非在Max之内，如果在，计算这条边上有多少各点；

```java
class Solution {
    int n;
    int m;
    int[] e;
    int[] he;
    int[] ne;
    int[] w;
    int idx;

    void init(int n, int m) {
        this.n = n;
        this.m = m;
        e = new int[m];
        he = new int[n];
        Arrays.fill(he, -1);
        ne = new int[m];
        w = new int[m];
        idx = 0;
    }

    void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        w[idx] = c;
        idx++;
    }

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        init(n, edges.length * 2);
        for (int[] e : edges) {
            int a = e[0], b = e[1], c = e[2];
            add(a, b, c + 1);
            add(b, a, c + 1);
        }

        int[] dist = dijkstra();
        // for (int v: dist) {
        //     System.out.print(v + " ");
        // }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves) {
                count++;
            }
        }
        for (int[] e : edges) {
            int f = e[0], t = e[1], cnt = e[2];
            int c1 = Math.max(0, maxMoves - dist[f]);
            int c2 = Math.max(0, maxMoves - dist[t]);
            count += Math.min(c1 + c2, cnt);
        }
        return count;
    }

    int[] dijkstra() {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int b = curr[0];
            if (visited[b]) continue;
            visited[b] = true;
            for (int i = he[b]; i != -1; i = ne[i]) {
                int b1 = e[i], c1 = w[i];
                if (dist[b1] > dist[b] + c1) {
                    dist[b1] = dist[b] + c1;
                    q.offer(new int[]{b1, dist[b1]});
                }
            }
        }
        return dist;
    }

    int INF = 0x3f3f3f3f;
}
```

### 886. Possible Bipartition

> 染色法判断2分图

```java
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        map = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            map[d[0]].add(d[1]);
            map[d[1]].add(d[0]);
        }
        int[] colors = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                if (!dfs(i, 1, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    //return true: OK with Bipartion
    boolean dfs(int curr, int color, int[] colors) {
        if (colors[curr] == color) return true;
        if (colors[curr] == 3 - color) return false;
        colors[curr] = color;
        for (int nei : map[curr]) {
            if (!dfs(nei, 3 - color, colors)) {
                return false;
            }
        }
        return true;
    }

    List<Integer>[] map;
}
```

> 并查集

```java
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        List<Integer>[] map = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] d : dislikes) {
            if (isSameSet(d[0], d[1])) return false;
            map[d[0]].add(d[1]);
            union(map[d[0]].get(0), d[1]);
            map[d[1]].add(d[0]);
            union(map[d[1]].get(0), d[0]);
        }
        return true;
    }

    int[] p;

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
        }
    }

    boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }
}
```