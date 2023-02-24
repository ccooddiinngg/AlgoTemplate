package AC2;


public class PG {

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static class P {
        int x;
        int y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Edge {
        int f;
        int t;
        int w;

        public Edge(int f, int t, int w) {
            this.f = f;
            this.t = t;
            this.w = w;
        }
    }

    private static class UnionSet {
        static int[] p;

        public UnionSet(int n) {
            p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = i;
            }
        }

        private int find(int n) {
            if (p[n] != n) {
                p[n] = find(p[n]);
            }
            return p[n];
        }

        private void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) p[px] = py;
        }

        private boolean isSameSet(int x, int y) {
            return find(x) == find(y);
        }
    }

    
}
