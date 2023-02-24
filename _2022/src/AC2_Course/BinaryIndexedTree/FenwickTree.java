package AC2_Course.BinaryIndexedTree;

public class FenwickTree {
    int[] bitArr;

    public FenwickTree(int n) {
        this.bitArr = new int[n + 1];
    }

    void update(int idx, int delta) {
        idx++;
        while (idx < bitArr.length) {
            bitArr[idx] += delta;
            idx += idx & (-idx);
        }
    }

    int ask(int idx) {
        idx++;
        int res = 0;
        while (idx > 0) {
            res += bitArr[idx];
            idx -= idx & (-idx);
        }
        return res;
    }

    int ask(int i, int j) {
        return ask(j) - ask(i - 1);
    }
}
