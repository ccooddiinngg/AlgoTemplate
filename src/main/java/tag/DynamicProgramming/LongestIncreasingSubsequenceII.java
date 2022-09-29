package tag.DynamicProgramming;


//TODO review segment tree
public class LongestIncreasingSubsequenceII {
    int[] max;

    public int lengthOfLIS(int[] nums, int k) {
        int m = nums.length;
        int n = 0;
        for (int num : nums) {
            n = Math.max(n, num);
        }
        //segment tree
        max = new int[n * 4];

        for (int num : nums) {
            if (num == 1) {
                modify(1, 1, n, 1, 1);
            } else {
                int v = query(1, 1, n, Math.max(num - k, 1), num - 1);
                modify(1, 1, n, num, v + 1);
            }
        }
        return max[1];
    }

    void modify(int o, int l, int r, int idx, int v) {
        if (l == r) {
            max[o] = v;
            return;
        }
        int mid = l + r >> 1;
        if (idx <= mid) {
            modify(o << 1, l, mid, idx, v);
        } else {
            modify(o << 1 | 1, mid + 1, r, idx, v);
        }
        //push up
        max[o] = Math.max(max[o << 1], max[o << 1 | 1]);
    }

    int query(int o, int l, int r, int L, int R) {
        if (l >= L && r <= R) {
            return max[o];
        }
        int res = 0;
        int mid = l + r >> 1;
        if (mid >= L) res = query(o << 1, l, mid, L, R);
        if (mid < R) res = Math.max(res, query(o << 1 | 1, mid + 1, r, L, R));
        return res;
    }
}
