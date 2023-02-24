package AC2.A3;

import java.util.*;

public class A848 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] pre = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            map.get(from).add(to);
            pre[to]++;
        }
        bfs(n, map, pre);
    }


    //不需要visited， 如果有环就会停住，因为有pre[i] != 0
    static void bfs(int n, Map<Integer, List<Integer>> map, int[] pre) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < pre.length; i++) {
            if (pre[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for (int to : map.get(curr)) {
                pre[to]--;
                if (pre[to] == 0) {
                    q.add(to);
                }
            }
        }
        if (res.size() < n) {
            System.out.println(-1);
        } else {
            for (int v : res) {
                System.out.print(v + " ");
            }
        }
    }

}
