public class UnionFind {
    private int[] p;

    public UnionFind(int capacity) {
        this.p = new int[capacity];
        for (int i = 0; i < p.length; i++) {
            this.p[i] = i;
        }
    }

    private int find(int i) {
        if (p[i] != i) {
            p[i] = find(p[i]);
        }
        return p[i];
    }

    public boolean isSameSet(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        return pi == pj;
    }

    public void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi != pj) {
            p[pi] = pj;
        }
    }
}
