package Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class GraphTest {
    public String crackSafe(int n, int k) {
        int bit = (int) Math.pow(10, n - 1);
        dfs(0, bit, k);
        for (int i = 1; i < n; i++) {
            path.append("0");
        }
        return path.toString();
    }

    Set<Integer> set = new HashSet<>();
    StringBuilder path = new StringBuilder();

    public void dfs(int curr, int bit, int k) {
        for (int i = 0; i < k; i++) {
            int next = curr * 10 + i;
            if (!set.contains(next)) {
                set.add(next);
                dfs(next % bit, bit, k);
                path.append(i);
            }
        }
    }

    @Test
    void test() {
        String res = crackSafe(3, 2);
        Assertions.assertEquals("0011101000", res);
    }
}
