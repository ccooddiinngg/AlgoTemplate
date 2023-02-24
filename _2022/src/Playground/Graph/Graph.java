package Playground.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    int n;
    Map<Integer, List<Edge>> map;
    
    public Graph(int[][] matrix) {
        this.n = matrix.length;
        this.map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!map.containsKey(i)) {
                    map.put(i, new ArrayList<>());
                }
                map.get(i).add(new Edge(i, j, matrix[i][j]));
            }
        }
    }


}
