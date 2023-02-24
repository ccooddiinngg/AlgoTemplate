package Playground.UnionSet;

public class UnionSet {
    int[] p;

    public UnionSet(int n) {
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
    }

    public int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            p[px] = py;
        }
    }

    public boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }


}
