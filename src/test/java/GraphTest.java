import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GraphTest {
    Graph graph = new Graph();

    @Test
    void test() {
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
}