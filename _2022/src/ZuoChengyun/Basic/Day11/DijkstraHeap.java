package ZuoChengyun.Basic.Day11;

import java.util.Map;

public class DijkstraHeap {
    private MinVerticesHeap minVerticesHeap;
    private Graph graph;

    public DijkstraHeap(Graph graph) {
        this.graph = graph;
        minVerticesHeap = new MinVerticesHeap(graph.vertices.size());
    }

    public Map<Vertex, Integer> run(Vertex v) {
        minVerticesHeap.addUpdateIgnore(v, 0);
        while (!minVerticesHeap.isEmpty()) {
            Vertex min = minVerticesHeap.pop();
            for (Edge next : min.edges) {
                minVerticesHeap.addUpdateIgnore(next.to, minVerticesHeap.weightMap.get(min) + next.weight);
            }
        }
        return minVerticesHeap.weightMap;
    }

    public static void main(String[] args) {
        Integer[][] matrixDijkstra = {{1, 2, 6}, {1, 4, 5}, {1, 3, 3}, {2, 5, 5}, {3, 4, 7}, {3, 5, 7}, {4, 5, 4}};
        DijkstraHeap dijkstraHeap = new DijkstraHeap(Graph.fromMatrixFromToWeight(matrixDijkstra));
        Map<Vertex, Integer> run = dijkstraHeap.run(dijkstraHeap.graph.vertices.get(1));
        System.out.println(run);
    }
}
