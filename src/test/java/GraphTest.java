import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {
    private static final int INF = 0x3f3f3f3f;

    @BeforeEach
    void setup() {

    }

    @Test
    void testFloyd() {
        int[][] matrix = {
                {0, 2, 1, INF, INF, INF},
                {2, 0, 7, INF, 8, 4},
                {1, 7, 0, 7, INF, 3},
                {INF, INF, 7, 0, 8, 4},
                {INF, 8, INF, 8, 0, 5},
                {INF, 4, 3, 4, 5, 0}};
        Graph graph = new Graph(matrix);
        graph.floyd();
        Assertions.assertArrayEquals(new int[]{0, 2, 1, 8, 9, 4}, matrix[0]);
    }

    @Test
    void testDijkstra() {
        int[][] matrix = {
                {0, 2, 1, INF, INF, INF},
                {2, 0, 7, INF, 8, 4},
                {1, 7, 0, 7, INF, 3},
                {INF, INF, 7, 0, 8, 4},
                {INF, 8, INF, 8, 0, 5},
                {INF, 4, 3, 4, 5, 0}};
        Graph graph = new Graph(matrix);
        int[] dis = graph.dijkstra();
        Assertions.assertArrayEquals(new int[]{0, 2, 1, 8, 9, 4}, dis);
    }

    @Test
    void testKruskal() {
        int[][] matrix = {
                {0, 4, INF, INF, INF, INF, INF, 8, INF},
                {4, 0, 8, INF, INF, INF, INF, 11, INF},
                {INF, 8, 0, 7, INF, 4, INF, INF, 2},
                {INF, INF, 7, 0, 9, 14, INF, INF, INF},
                {INF, INF, INF, 9, 0, 10, INF, INF, INF},
                {INF, INF, 4, 14, 10, 0, 2, INF, INF},
                {INF, INF, INF, INF, INF, 2, 0, 1, 6},
                {8, 11, INF, INF, INF, INF, 1, 0, 7},
                {INF, INF, 2, INF, INF, INF, 6, 7, 0}};
        Graph graph = new Graph(matrix);
        int shortestPath = graph.kruskal();
        Assertions.assertEquals(37, shortestPath);
    }
}