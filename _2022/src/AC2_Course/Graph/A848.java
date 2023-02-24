package AC2_Course.Graph;

import java.util.*;

/*
848. 有向图的拓扑序列

给定一个 n 个点 m 条边的有向图，点的编号是 1 到 n，图中可能存在重边和自环。

请输出任意一个该有向图的拓扑序列，如果拓扑序列不存在，则输出 −1。

若一个由图中所有点构成的序列 A 满足：对于图中的每条边 (x,y)，x 在 A 中都出现在 y 之前，则称 A 是该图的一个拓扑序列。

输入格式
第一行包含两个整数 n 和 m。

接下来 m 行，每行包含两个整数 x 和 y，表示存在一条从点 x 到点 y 的有向边 (x,y)。

输出格式
共一行，如果存在拓扑序列，则输出任意一个合法的拓扑序列即可。

否则输出 −1。

数据范围
1≤n,m≤105
输入样例：
3 3
1 2
2 3
1 3
输出样例：
1 2 3
 */
public class A848 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new Node(i));
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            map.get(from).next.add(map.get(to));
            map.get(to).pre++;
        }

        Queue<Node> q = new LinkedList<>();
        for (int key : map.keySet()) {
            if (map.get(key).pre == 0) {
                q.add(map.get(key));
            }
        }
        int size = q.size();

        List<Integer> list = new ArrayList<>();

        while (size != 0) {
            Node node = q.poll();
            list.add(node.id);
            for (Node next : node.next) {
                next.pre--;
                if (next.pre == 0) {
                    q.add(next);
                }
            }
            size--;
            if (size == 0) {
                size = q.size();
            }
        }

        if (list.size() == n) {
            for (int num : list) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    static class Node {
        int id;
        List<Node> next;
        int pre;

        public Node(int id) {
            this.id = id;
            next = new ArrayList<>();
            pre = 0;
        }
    }
}
