import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {
    Graph graph = new Graph();

    @BeforeEach
    void setup() {

    }

    @Test
    void testDijkstra() {
        int[][] matrix = {
                {0, 2, 1, 0, 0, 0},
                {2, 0, 7, 0, 8, 4},
                {1, 7, 0, 7, 0, 3},
                {0, 0, 7, 0, 8, 4},
                {0, 8, 0, 8, 0, 5},
                {0, 4, 3, 4, 5, 0}};
        graph.build(matrix);
        int[] dis = graph.dijkstra();
        Assertions.assertArrayEquals(new int[]{0, 2, 1, 8, 9, 4}, dis);
    }

    @Test
    void testKruskal() {
        int[][] matrix = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        graph.build(matrix);
        int shortestPath = graph.kruskal();
        Assertions.assertEquals(37, shortestPath);
    }
}