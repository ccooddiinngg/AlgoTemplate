package AC2_Course.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*372. 棋盘覆盖

给定一个 N 行 N 列的棋盘，已知某些格子禁止放置。

求最多能往棋盘上放多少块的长度为 2、宽度为 1 的骨牌，骨牌的边界与格线重合（骨牌占用两个格子），并且任意两张骨牌都不重叠。

输入格式
第一行包含两个整数 N 和 t，其中 t 为禁止放置的格子的数量。

接下来 t 行每行包含两个整数 x 和 y，表示位于第 x 行第 y 列的格子禁止放置，行列数从 1 开始。

输出格式
输出一个整数，表示结果。

数据范围
1≤N≤100,
0≤t≤100
输入样例：
8 0
输出样例：
32*/
public class A372 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/ACWING/Graph/A372Data.txt"));
        int N = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[N + 1][N + 1];
        /*
        BUG: 右下应为0
        0, -1
        -1, 1

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                boolean isHead = true;
                for (int k = 0; k < 4; k++) {
                    int x = i + h[k];
                    int y = j + v[k];
                    if (x > 0 && x <= N && y > 0 && y <= N && map[x][y] == 1) {
                        isHead = false;
                    }
                }
                if (isHead) {
                    map[i][j] = 1;
                }
            }
        }*/

        //chess board distinguish
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if ((i + j) % 2 == 0) {
                    map[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x][y] = -1;
        }

        int[] h = {1, -1, 0, 0};
        int[] v = {0, 0, 1, -1};

        Map<Integer, List<Integer>> g = new HashMap<>();
        int[] matches = new int[(N + 1) * (N + 1)];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int node = i * N + j;
                if (map[i][j] == 1) {
                    g.put(node, new ArrayList<>());
                    for (int k = 0; k < 4; k++) {
                        int x = i + h[k];
                        int y = j + v[k];
                        if (x > 0 && x <= N && y > 0 && y <= N && map[x][y] == 0) {
                            int nei = x * N + y;
                            g.get(node).add(nei);
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1; i < (N + 1) * (N + 1); i++) {
            if (g.containsKey(i)) {
                if (match(i, g, matches, new boolean[(N + 1) * (N + 1)])) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    //@@ return if node can find a place with green and matches constraint
    static boolean match(int node, Map<Integer, List<Integer>> g, int[] matches, boolean[] green) {
        for (int nei : g.get(node)) {
            if (!green[nei]) {
                green[nei] = true;
                if (matches[nei] == 0 || match(matches[nei], g, matches, green)) {
                    matches[nei] = node;
                    return true;
                }
            }
        }
        return false;
    }

}
