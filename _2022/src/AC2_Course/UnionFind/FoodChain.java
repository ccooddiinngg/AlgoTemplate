package AC2_Course.UnionFind;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FoodChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            map.put(i, new Node(i));
        }

        int count = 0;
        for (int i = 0; i < K; i++) {
            int op = sc.nextInt();
            int id1 = sc.nextInt();
            int id2 = sc.nextInt();
            if (op == 1 && !isSame(id1, id2)) {
                count++;
            }
            if (op == 2 && !eat(id1, id2)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static Map<Integer, Node> map = new HashMap<>();

    public static Node findP(int id) {
        Node node = map.get(id);
        if (node.p != node) {
            Node p = findP(node.p.id);
            node.dis += node.p.dis;
            node.p = p;
        }
        return node.p;
    }

    //(id1.dis - id2.dis) % 3 == 1
    public static boolean eat(int id1, int id2) {
        if (map.get(id1) == null || map.get(id2) == null) {
            return false;
        }
        Node p1 = findP(id1);
        Node p2 = findP(id2);
        if (p1 == p2) {
            return (map.get(id1).dis - map.get(id2).dis - 1) % 3 == 0;
        } else {
            p1.p = p2;
            p1.dis = map.get(id2).dis + 1 - map.get(id1).dis;
            return true;
        }
    }

    //id1 and id2 are in same distance group
    public static boolean isSame(int id1, int id2) {
        if (map.get(id1) == null || map.get(id2) == null) {
            return false;
        }
        Node p1 = findP(id1);
        Node p2 = findP(id2);
        if (p1 == p2) {
            return (map.get(id1).dis - map.get(id2).dis) % 3 == 0;
        } else {
            p1.p = p2;
            p1.dis = map.get(id2).dis - map.get(id1).dis;
            return true;
        }
    }

    static class Node {
        int id;
        Node p;
        int dis;

        public Node(int id) {
            this.id = id;
            p = this;
            dis = 0;
        }
    }
}
