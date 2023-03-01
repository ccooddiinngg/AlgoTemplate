package Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        boolean[][] set = new boolean[n][1 << n];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new Node(i, 1 << i, 0));
            set[i][1 << i] = true;
        }
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.visited == (1 << n) - 1) {
                return curr.dist;
            }
            for (int i = 0; i < graph[curr.id].length; i++) {
                int id = graph[curr.id][i];
                int visited = curr.visited | 1 << id;
                if (!set[id][visited]) {
                    set[id][visited] = true;
                    q.offer(new Node(id, visited, curr.dist + 1));
                }
            }
        }
        return -1;
    }

    class Node {
        int id;
        int visited;
        int dist;

        public Node(int id, int visited, int dist) {
            this.id = id;
            this.visited = visited;
            this.dist = dist;
        }

    }

    @Test
    void test() {
        int[][] graph = {{2, 3, 5, 7}, {2, 3, 7}, {0, 1}, {0, 1}, {7}, {0}, {10}, {9, 10, 0, 1, 4}, {9}, {7, 8}, {7, 6}};
        Assertions.assertEquals(14, shortestPathLength(graph));
    }
}
