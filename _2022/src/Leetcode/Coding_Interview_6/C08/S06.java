package Leetcode.Coding_Interview_6.C08;

import java.util.List;

public class S06 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        f(A, B, C, A.size());
    }

    void f(List<Integer> A, List<Integer> B, List<Integer> C, int n) {
        //一个的时候从A 移到 C
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        f(A, C, B, n - 1);
        C.add(A.remove(A.size() - 1));
        f(B, A, C, n - 1);
    }
}
