package AC2_Course.Graph;

import java.util.*;

/*861. 二分图的最大匹配

给定一个二分图，其中左半部包含 n1 个点（编号 1∼n1），右半部包含 n2 个点（编号 1∼n2），二分图共包含 m 条边。

数据保证任意一条边的两个端点都不可能在同一部分中。

请你求出二分图的最大匹配数。

二分图的匹配：给定一个二分图 G，在 G 的一个子图 M 中，M 的边集 {E} 中的任意两条边都不依附于同一个顶点，则称 M 是一个匹配。

二分图的最大匹配：所有匹配中包含边数最多的一组匹配被称为二分图的最大匹配，其边数即为最大匹配数。

输入格式
第一行包含三个整数 n1、 n2 和 m。

接下来 m 行，每行包含两个整数 u 和 v，表示左半部点集中的点 u 和右半部点集中的点 v 之间存在一条边。

输出格式
输出一个整数，表示二分图的最大匹配数。

数据范围
1≤n1,n2≤500,
1≤u≤n1,
1≤v≤n2,
1≤m≤105
输入样例：
2 2 4
1 1
1 2
2 1
2 2
输出样例：
2*/
public class A861 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n1; i++) {
            map.put(i, new ArrayList<>());
        }
        int[] matches = new int[n2 + 1];

        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            map.get(f).add(t);
        }

        int count = 0;
        for (int i = 1; i <= n1; i++) {
            //start a new challenge
            if (match(i, map, matches, new boolean[n2 + 1])) {
                count++;
            }
        }
        System.out.println(count);
    }

    //green[] : if this nei has been challenged
    static boolean match(int node, Map<Integer, List<Integer>> map, int[] matches, boolean[] green) {
        for (int nei : map.get(node)) {
            if (!green[nei]) {
                green[nei] = true;
                if (matches[nei] == 0 || match(matches[nei], map, matches, green)) {
                    matches[nei] = node;
                    return true;
                }
            }
        }
        return false;
    }

}
