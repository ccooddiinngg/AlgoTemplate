package ZuoChengyun.Basic.Day11;

import ZuoChengyun.Basic.Day10.UnionSet;

import java.util.*;

public class Graph {

    public Map<Integer, Vertex> vertices;
    public Set<Edge> edges;

    public Graph() {
        vertices = new HashMap<>();
        edges = new HashSet<>();
    }

    /*
     * [ [from, to, weight],...]
     * */
    public static Graph fromMatrixFromToWeight(Integer[][] matrix) {
        Graph graph = new Graph();
        for (Integer[] e : matrix) {
            Integer f = e[0];
            Integer t = e[1];
            Integer w = e[2];
            if (!graph.vertices.containsKey(f)) {
                graph.vertices.put(f, new Vertex(f));
            }
            if (!graph.vertices.containsKey(t)) {
                graph.vertices.put(t, new Vertex(t));
            }
            Vertex from = graph.vertices.get(f);
            Vertex to = graph.vertices.get(t);
            Edge edge = new Edge(from, to, w);
            from.next.add(to);
            from.out++;
            from.edges.add(edge);
            to.in++;

            graph.edges.add(edge);
        }
        return graph;
    }


    // 2D matrix
    public static Graph fromMatrix2D(Integer[][] matrix) {
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!graph.vertices.containsKey(i)) {
                    graph.vertices.put(i, new Vertex(i));
                }
                if (!graph.vertices.containsKey(j)) {
                    graph.vertices.put(j, new Vertex(j));
                }
                if (matrix[i][j] != null) {
                    Vertex from = graph.vertices.get(i);
                    Vertex to = graph.vertices.get(j);
                    Edge edge = new Edge(from, to, matrix[i][j]);
                    from.next.add(to);
                    from.out++;
                    from.edges.add(edge);
                    to.in++;
                    graph.edges.add(edge);
                }
            }
        }
        return graph;
    }

    public void BFS(Vertex v) {
        if (v == null) return;
        Queue<Vertex> queue = new LinkedList<>();
        Set<Vertex> set = new HashSet<>();
        queue.add(v);
        set.add(v);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            System.out.println(vertex.name);
            for (Vertex next : vertex.next) {
                if (!set.contains(next)) {
                    set.add(next);
                    queue.add(next);
                }
            }
        }
    }

    public void DFS(Vertex v) {
        if (v == null) return;
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> set = new HashSet<>();
        stack.push(v);
        set.add(v);
        System.out.println(v.name);
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            for (Vertex next : vertex.next) {
                if (!set.contains(next)) {
                    stack.push(vertex);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.name);
                    break;
                }
            }
        }
    }

    public void DFSRecursive(Vertex v, Set<Vertex> set) {
        if (v == null || set.contains(v)) {
            return;
        }
        System.out.println(v.name);
        set.add(v);
        for (Vertex next : v.next) {
            DFSRecursive(next, set);
        }
    }

    public List<Vertex> topology() {
        Map<Vertex, Integer> inMap = new HashMap<>();
        Queue<Vertex> queue = new LinkedList<>();
        List<Vertex> list = new ArrayList<>();
        for (Vertex vertex : vertices.values()) {
            inMap.put(vertex, vertex.in);
            if (vertex.in == 0) {
                queue.add(vertex);
            }
        }
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            list.add(vertex);
            for (Vertex next : vertex.next) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return list;
    }

    public Set<Edge> kruskalMST() {
        Queue<Edge> queue = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));
        queue.addAll(edges);
        UnionSet<Vertex> unionSet = new UnionSet<>(new ArrayList<>(vertices.values()));
        Set<Edge> set = new HashSet<>();

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            Vertex from = edge.from;
            Vertex to = edge.to;
            if (!unionSet.isSameSet(from, to)) {
                unionSet.union(from, to);
                set.add(edge);
            }
        }
        return set;
    }

    public Set<Edge> primMST() {
        Set<Vertex> visited = new HashSet<>();
        Queue<Edge> edges = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        Set<Edge> selected = new HashSet<>();

        for (Vertex v : vertices.values()) {
            if (!visited.contains(v)) {
                visited.add(v);
                edges.addAll(v.edges);
                while (!edges.isEmpty()) {
                    Edge edge = edges.poll();
                    if (!visited.contains(edge.to)) {
                        selected.add(edge);
                        visited.add(edge.to);
                        edges.addAll(edge.to.edges);
                    }
                }
            }
        }
        return selected;
    }

    public Map<Vertex, Integer> dijkstra(Vertex v) {
        Set<Vertex> selected = new HashSet<>();
        Map<Vertex, Integer> distanceMap = new HashMap<>();
        distanceMap.put(v, 0);
        Vertex curr = getNextMinVertex(distanceMap, selected);
        while (curr != null) {
            for (Edge edge : curr.edges) {
                Integer newWeight = distanceMap.get(curr) + edge.weight;
                if (!distanceMap.containsKey(edge.to) || newWeight < distanceMap.get(edge.to)) {
                    distanceMap.put(edge.to, newWeight);
                }
            }
            selected.add(curr);
            curr = getNextMinVertex(distanceMap, selected);
        }
        return distanceMap;
    }

    private Vertex getNextMinVertex(Map<Vertex, Integer> distanceMap, Set<Vertex> selected) {
        Integer min = Integer.MAX_VALUE;
        Vertex v = null;
        for (Vertex vertex : distanceMap.keySet()) {
            if (!selected.contains(vertex) && distanceMap.get(vertex) < min) {
                v = vertex;
                min = distanceMap.get(vertex);
            }
        }
        return v;
    }

    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2, 1}, {1, 3, 1}, {1, 4, 1}, {3, 1, 1},
                {4, 1, 1}, {2, 3, 1}, {3, 2, 1}, {2, 5, 1}, {3, 5, 1}, {5, 4, 1}};
        Graph graph = fromMatrixFromToWeight(matrix);
        graph.BFS(graph.vertices.get(1));
        System.out.println("==");
        graph.DFS(graph.vertices.get(1));
        System.out.println("==");
        graph.DFSRecursive(graph.vertices.get(1), new HashSet<>());

        Integer[][] matrix2D = {{null, 1, 2, null}, {1, null, null, 4}, {2, null, null, 7}, {null, 4, 7, null}};
        Graph graph2D = fromMatrix2D(matrix2D);
        Set<Edge> edgesKruskal = graph2D.kruskalMST();
        System.out.println(edgesKruskal);
        Set<Edge> edgesPrim = graph2D.primMST();
        System.out.println(edgesPrim);

        Integer[][] matrixDijkstra1 = {{1, 2, 1}, {2, 3, 4}, {1, 4, 5}, {2, 3, 4},
                {2, 4, 6}, {1, 3, 7}, {2, 4, 6}, {4, 3, 100}};
        Integer[][] matrixDijkstra2 = {{1, 2, 6}, {1, 4, 5}, {1, 3, 3}, {2, 5, 5}, {3, 4, 7}, {3, 5, 7}, {4, 5, 4}};

        Graph graphDijkstra = Graph.fromMatrixFromToWeight(matrixDijkstra2);

        Map<Vertex, Integer> dijkstra = graphDijkstra.dijkstra(graphDijkstra.vertices.get(1));
        System.out.println(dijkstra);

        DijkstraHeap dijkstraHeap = new DijkstraHeap(graphDijkstra);
        Map<Vertex, Integer> run = dijkstraHeap.run(graphDijkstra.vertices.get(1));
        System.out.println(run);

    }
}
