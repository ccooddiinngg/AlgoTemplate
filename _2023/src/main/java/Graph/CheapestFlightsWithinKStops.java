package Graph;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3f3f3f3f;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;
        for (int k1 = 0; k1 < k + 1; k1++) {
            int[] pre = Arrays.copyOf(dist, dist.length);
            for (int[] f : flights) {
                dist[f[1]] = Math.min(dist[f[1]], pre[f[0]] + f[2]);
            }
        }
        return dist[dst] < INF ? dist[dst] : -1;
    }


}
