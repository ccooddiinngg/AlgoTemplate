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