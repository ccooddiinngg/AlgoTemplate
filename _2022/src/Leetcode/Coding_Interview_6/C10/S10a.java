package Leetcode.Coding_Interview_6.C10;

import java.util.ArrayList;
import java.util.List;

//2分查找
public class S10a {
    class StreamRank {
        List<Integer> list = new ArrayList<>();

        public StreamRank() {

        }

        public void track(int x) {
            int pos = getRankOfNumber(x);
            list.add(pos, x);
        }

        public int getRankOfNumber(int x) {
            if (list.size() == 0) return 0;
            int i = 0;
            int j = list.size() - 1;
            while (i < j) {
                int mid = i + j >> 1;
                if (list.get(mid) <= x) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            return list.get(i) <= x ? i + 1 : i;
        }
    }
}
