package AC2_Course.DP;

import java.util.*;

public class A285 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();

        int[] happiness = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int h = sc.nextInt();
            happiness[i] = h;
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int emp = sc.nextInt();
            int boss = sc.nextInt();
            map.get(boss).add(emp);
        }
        boolean[] notBoss = new boolean[n];
        for (int key : map.keySet()) {
            for (int emp : map.get(key)) {
                notBoss[emp - 1] = true;
            }
        }
        int boss = 0;
        for (int i = 0; i < n; i++) {
            if (!notBoss[i]) {
                boss = i + 1;
            }
        }
        int[][] dp = new int[n + 1][2];
        getMax(boss, map, dp, happiness);

        System.out.println(Math.max(dp[boss][0], dp[boss][1]));
    }

    //直接填cache
    public static void getMax(int id, Map<Integer, List<Integer>> map, int[][] dp, int[] happiness) {
        dp[id][1] = happiness[id];
        for (int emp : map.get(id)) {
            getMax(emp, map, dp, happiness);
            dp[id][0] = Math.max(dp[emp][0], dp[emp][1]);
            dp[id][1] += dp[emp][0];
        }
    }

}


