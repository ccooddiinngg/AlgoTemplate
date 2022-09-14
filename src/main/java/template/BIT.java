package template;

public class BIT {
    private int[] p;
    private int n;

    public BIT(int n) {
        this.n = n;
        this.p = new int[n + 1];
    }

    private int lowBit(int x) {
        return x & (-x);
    }

    public void update(int idx, int val) {
        while (idx <= n) {
            this.p[idx] += val;
            idx += lowBit(idx);
        }
    }

    public int ask(int idx) {
        int res = 0;
        while (idx > 0) {
            res += this.p[idx];
            idx -= lowBit(idx);
        }
        return res;
    }

    //i <= j
    public int ask(int i, int j) {
        return ask(j) - ask(i - 1);
    }
}
