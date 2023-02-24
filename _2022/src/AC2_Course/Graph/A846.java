package AC2_Course.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/*
846. 树的重心

给定一颗树，树中包含 n 个结点（编号 1∼n）和 n−1 条无向边。

请你找到树的重心，并输出将重心删除后，剩余各个连通块中点数的最大值。

重心定义：重心是指树中的一个结点，如果将这个点删除后，剩余各个连通块中点数的最大值最小，那么这个节点被称为树的重心。

输入格式
第一行包含整数 n，表示树的结点数。

接下来 n−1 行，每行包含两个整数 a 和 b，表示点 a 和点 b 之间存在一条边。

输出格式
输出一个整数 m，表示将重心删除后，剩余各个连通块中点数的最大值。

数据范围
1≤n≤105
输入样例
9
1 2
1 7
1 4
2 8
2 5
4 3
3 9
4 6
输出样例：
4
*/

public class A846 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/ACWING/Graph/A846Data.txt"));
        int n = sc.nextInt();
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new Node(i));
        }

        for (int i = 1; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            map.get(from).next.add(to);
            map.get(to).next.add(from);
        }

        Set<Integer> visited = new HashSet<>();
        getSize(1, map, visited, n);

        System.out.println(min);
    }

    static int min = Integer.MAX_VALUE;

    public static int getSize(int id, Map<Integer, Node> map, Set<Integer> visited, int n) {
        visited.add(id);
        int count = 1;
        int max = 0;
        for (int next : map.get(id).next) {
            if (!visited.contains(next)) {
                int sizeNext = getSize(next, map, visited, n);
                max = Math.max(max, sizeNext);
                count += sizeNext;
            }
        }
        max = Math.max(max, n - count);
        min = Math.min(min, max);
        return count;
    }

    static class Node {
        int id;
        List<Integer> next;

        public Node(int id) {
            this.id = id;
            next = new ArrayList<>();
        }
    }
}
