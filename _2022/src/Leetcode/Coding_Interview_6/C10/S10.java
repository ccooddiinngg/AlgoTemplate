package Leetcode.Coding_Interview_6.C10;

//树状数组
public class S10 {
    class StreamRank {
        int n = 50010;
        int[] t = new int[n];

        public StreamRank() {

        }

        void update(int i, int v) {
            while (i < n) {
                t[i] += v;
                i += i & -i;
            }
        }

        int ask(int i) {
            int res = 0;
            while (i > 0) {
                res += t[i];
                i -= i & -i;
            }
            return res;
        }

        public void track(int x) {
            update(x + 1, 1);
        }

        public int getRankOfNumber(int x) {
            return ask(x + 1);
        }
    }
}
