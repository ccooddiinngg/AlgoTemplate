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