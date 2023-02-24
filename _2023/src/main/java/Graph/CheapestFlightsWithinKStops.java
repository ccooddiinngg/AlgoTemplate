package Graph;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3f3f3f3f;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        //最多k+1条边
        for (int i = 0; i < k + 1; i++) {
            int[] copy = Arrays.copyOf(dist, dist.length);
            for (int j = 0; j < flights.length; j++) {
                dist[flights[j][1]] = Math.min(dist[flights[j][1]], copy[flights[j][0]] + flights[j][2]);
            }
        }
        return dist[dst] < INF ? dist[dst] : -1;
    }

}
