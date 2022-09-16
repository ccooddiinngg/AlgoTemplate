package tag.BinaryIndexTree;

import java.util.Arrays;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        BIT bit = new BIT(people.length);

        int[][] res = new int[people.length][2];
        for (int[] p : people) {
            int idx = bit.find(p[1]);
            bit.update(idx, 1);
            res[idx - 1] = p;
        }
        return res;
    }

    class BIT {
        int[] arr;
        int n;

        public BIT(int n) {
            this.n = n;
            this.arr = new int[n + 1];
        }

        private int lowBit(int x) {
            return x & (-x);
        }

        public void update(int i, int d) {
            while (i <= n) {
                arr[i] += d;
                i += lowBit(i);
            }
        }

        public int ask(int i) {
            int res = 0;
            while (i > 0) {
                res += arr[i];
                i -= lowBit(i);
            }
            return res;
        }

        //find the index which (index - 1) - (nums of 1 before index) == e
        public int find(int e) {
            int i = 1;
            int j = n;
            while (i < j) {
                int mid = i + j >> 1;
                int v = ask(mid);
                if (mid - v - 1 < e) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            return i;
        }
    }
}

