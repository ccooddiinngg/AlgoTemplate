package AC2_Course.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A842 {
    public static void main(String[] args) {
        int N = 3;
        List<List<Integer>> list = new ArrayList<>();
        dfs(N, 1, new ArrayList<>(), list, new HashSet<>());
        System.out.println(list);
    }

    public static void dfs(int N, int index, List<Integer> path, List<List<Integer>> list, Set<Integer> used) {
        if (index == N + 1) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!used.contains(i)) {
                used.add(i);
                path.add(i);
                dfs(N, index + 1, path, list, used);
                used.remove(i);
                path.remove(path.size() - 1);
            }
        }
    }
}
