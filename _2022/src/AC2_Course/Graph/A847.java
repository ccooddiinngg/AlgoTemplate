package AC2_Course.Graph;

import java.util.*;

public class A847 {
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
            map.get(from).next.add(to);
        }

        Queue<Node> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(map.get(1));
        int size = 1;
        int step = 0;
        boolean found = false;
        while (size > 0) {
            Node node = q.poll();
            if (node.id == n) {
                found = true;
                break;
            }
            for (int next : node.next) {
                if (!visited.contains(next)) {
                    q.add(map.get(next));
                    visited.add(next);
                }
            }
            size--;
            if (size == 0) {
                size = q.size();
                step++;
            }
        }
        if (found) {
            System.out.println(step);
        } else {
            System.out.println(-1);
        }

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
