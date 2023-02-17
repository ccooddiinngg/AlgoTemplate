package UnionFind;

public class UnionFind {
    int[] p;

    public UnionFind(int cap) {
        this.p = new int[cap];
        for (int i = 0; i < cap; i++) {
            p[i] = i;
        }
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp != yp) {
            p[xp] = yp;
        }
    }
}
