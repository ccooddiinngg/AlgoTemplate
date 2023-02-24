package Leetcode.Coding_Interview_6.C04;

public class S01b {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        if (start == target) return true;
        for (int[] e : graph) {
            if (e[1] == target) {
                if (findWhetherExistsPath(n, graph, start, e[0])) {
                    return true;
                }
            }
        }
        return false;
    }
}
