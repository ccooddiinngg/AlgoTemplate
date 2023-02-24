package Playground.BIT;

public class BIT {
    int[] tree;
    int n;

    public BIT(int n) {
        this.n = n;
        tree = new int[n + 1];
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    void update(int idx, int v) {
        while (idx <= n) {
            tree[idx] += v;
            idx += lowBit(idx);
        }
    }

    int ask(int idx) {
        int res = 0;
        while (idx > 0) {
            res += tree[idx];
            idx -= lowBit(idx);
        }
        return res;
    }

    int ask(int idx1, int idx2) {
        return ask(idx2) - ask(idx1 - 1);
    }
}
